package main.view;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import main.model.Player;
import main.viewModel.ModelManager;


public class EventFactory {
    ModelManager modelManager;
    EventFactory(ModelManager modelManager) {
        this.modelManager = modelManager;
    }
    public EventHandler<MouseEvent> getPlayEvent(CardDisplay card, Player player) {
        return e -> {modelManager.removeFromPlayerHand(player, card);
            System.out.println(modelManager.game.getCurrentPlayer());
            System.out.println(player);};
    }
    public EventHandler<MouseEvent> getDrawEvent( Player player) {
        return e-> modelManager.addToPlayerHand(player);
    }
}
