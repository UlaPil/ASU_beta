package main.view;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.model.Game;
import main.model.NoMoreCardsInDeck;

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
    Stage stage;
    public AppInit(Stage stage) {
        this.stage = stage;
        game = new Game(" ");
        Scenes.put(SceneName.MENU, new Menu());
        Scenes.put(SceneName.PLAY, new GameView(new CardDisplay(game.getTopCard())));
        try {
            game.startGame();
        } catch(NoMoreCardsInDeck e) {
            throw new RuntimeException(e);
        }
        initializeScenes();
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

    public void init() {
        stage.setScene(Scenes.get(SceneName.MENU).getScene());
        stage.setResizable(false);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();

    }
    public EventHandler<MouseEvent> getSceneChanger(SceneName name ) {
        return e -> stage.setScene(Scenes.get(name).getScene());
    }
    public EventHandler<MouseEvent> getCloser() {
        return e -> stage.close();
    }

}
