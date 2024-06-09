package main.viewModel;

import main.model.Game;
import main.view.GameView;

public class ViewModelMain {
    private HandManager handManager;
    private ModelManager modelManager;
    private TopCardManager topCardManager;
    private TopColorManager topColorManager;
    public ViewModelMain(Game game) {
        handManager = new HandManager();
        modelManager = new ModelManager(game);
        topColorManager = new TopColorManager(game);
    }
    public void setTopCardManager(TopCardManager topCardManager) {
        this.topCardManager = topCardManager;
    }
    public HandManager getHandManager() {return handManager;}
    public ModelManager getModelManager() {return modelManager;}
    public TopCardManager getTopCardManager() {return topCardManager;}
    public TopColorManager getTopColorManager() {return topColorManager;}

}
