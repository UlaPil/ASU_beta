package main.viewModel;

import main.model.Game;
import main.view.GameView;

public class ViewModelMain {
    private HandManager handManager;
    private ModelManager modelManager;
    private TopCardManager topCardManager;
    private TopColorManager topColorManager;
    public ViewModelMain(Game game, GameView gameView) {
        handManager = new HandManager();
        modelManager = new ModelManager(game);
        topColorManager = new TopColorManager(game);
        topCardManager = new TopCardManager(gameView);
    }
    public HandManager getHandManager() {return handManager;}
    public ModelManager getModelManager() {return modelManager;}
    public TopCardManager getTopCardManager() {return topCardManager;}
    public TopColorManager getTopColorManager() {return topColorManager;}

}
