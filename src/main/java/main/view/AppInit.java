package main.view;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.model.Game;
import main.model.NoMoreCardsInDeck;
import main.viewModel.ModelManager;
import main.viewModel.TopCardManager;
import main.viewModel.ViewModelMain;

import java.util.HashMap;
import java.util.Map;


public class AppInit {
    public enum SceneName {
        MENU,
        PLAY,
        HISTORY
    }
    private final Map<SceneName, AsuScene> Scenes = new HashMap<>();
    private final Game game;
    private final ViewModelMain viewModel;
    private final GameView gameView;
    Stage stage;
    public AppInit(Stage stage) {
        this.stage = stage;
        game = new Game("");
        viewModel = new ViewModelMain(game);
        Scenes.put(SceneName.MENU, new Menu());
        gameView = new GameView(new CardDisplay(game.getTopCard()),new EventFactory(viewModel.getModelManager()), game.getPlayerList());
        viewModel.setTopCardManager(new TopCardManager(gameView));
        Scenes.put(SceneName.PLAY, gameView );
        initializeScenes();
        initializeObservers();
    }
    private void initializeScenes() {
        //Menu
        Menu scene = (Menu)Scenes.get(SceneName.MENU);
        scene.setEvent(Menu.But.EXIT, getCloser());
        scene.setEvent(Menu.But.PLAY, getSceneChanger(SceneName.PLAY));
        //scene.setEvent(Menu.But.HISTORY, getSceneChanger(SceneName.HISTORY));
        GameView scene2 = (GameView)Scenes.get(SceneName.PLAY);
        scene2.defineExit(getCloser());
    }
    private void initializeObservers() {
        viewModel.getTopCardManager().addObserver(new TopCardObserver(gameView));
        game.addCardObserver(viewModel.getTopCardManager());
        for(int i = 0 ; i < game.getPlayerList().size() ; i++) {
            if(i == 0) {
                viewModel.getHandManager().addObserver(new PlayerHandObserver(gameView, game.getPlayerList().get(i)));
            }
            else{
                    viewModel.getHandManager().addObserver(new RobotHandObserver(gameView, game.getPlayerList().get(i)));
                }
        }
        game.addHandObserver(viewModel.getHandManager());
    }
    public void init() {
        stage.setScene(Scenes.get(SceneName.MENU).getScene());
        stage.setResizable(false);
        stage.initStyle(StageStyle.TRANSPARENT);
        try {
            game.startGame();
        } catch(NoMoreCardsInDeck e) {
            throw new RuntimeException(e);
        }
        stage.show();

    }
    public EventHandler<MouseEvent> getSceneChanger(SceneName name ) {
        return e -> stage.setScene(Scenes.get(name).getScene());
    }
    public EventHandler<MouseEvent> getGameStarter() {
        return e -> {
            game.reset();
            gameView.reset();
            try {
                game.startGame();
            } catch(NoMoreCardsInDeck ex) {
                throw new RuntimeException(ex);
            }
            stage.setScene(Scenes.get(SceneName.PLAY).getScene());
        };
    }
    public EventHandler<MouseEvent> getCloser() {
        return e -> stage.close();
    }

}
