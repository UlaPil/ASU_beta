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
    public EventHandler<MouseEvent> getPlayEvent(Player player, CardDisplay card) {
        return e -> {modelManager.removeFromPlayerHand(player, card.getCard());};
    }
    public EventHandler<MouseEvent> getDrawEvent( Player player) {
        return e-> modelManager.addToPlayerHand(player);
    }
}
