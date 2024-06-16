package main.viewModel;

import main.model.Game;

public class ViewModelMain {
    private final HandManager handManager;
    private final ModelManager modelManager;
    private TopCardManager topCardManager;
    private final TopColorManager topColorManager;
    private final GameEndManager gameEndManager;
    public ViewModelMain(Game game) {
        handManager = new HandManager();
        modelManager = new ModelManager(game);
        topColorManager = new TopColorManager(game);
        gameEndManager = new GameEndManager();
    }
    public void setTopCardManager(TopCardManager topCardManager) {
        this.topCardManager = topCardManager;
    }
    public HandManager getHandManager() {return handManager;}
    public ModelManager getModelManager() {return modelManager;}
    public TopCardManager getTopCardManager() {return topCardManager;}
    public TopColorManager getTopColorManager() {return topColorManager;}
    public GameEndManager getGameEndManager() {return gameEndManager;}
}
