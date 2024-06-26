package main.view;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import main.model.Cards.Color;
import main.model.Player;
import main.view.Game.CardDisplay;
import main.viewModel.ModelManager;


public class EventFactory {
    private final ModelManager modelManager;
    EventFactory(ModelManager modelManager) {
        this.modelManager = modelManager;
    }
    public EventHandler<MouseEvent> getPlayEvent(Player player, CardDisplay card) {
        return e -> modelManager.removeFromPlayerHand(player, card.getCard());
    }
    public EventHandler<MouseEvent> getDrawEvent( Player player) {
        return e-> modelManager.addToPlayerHand(player);
    }
    public void changeTopColor(Color color) {
        modelManager.changeTopColor(color);
    }
}
