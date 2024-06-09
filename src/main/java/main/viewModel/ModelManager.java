package main.viewModel;

import main.model.Game;
import main.model.Player;
import main.view.CardDisplay;

public class ModelManager {
    Game game;
    public ModelManager(Game game) { this.game = game;}

    public void removeFromPlayerHand(Player player, CardDisplay card) {
        game.playCard(player, card.getCard());
    }

    public void addToPlayerHand(Player player) {
        try {
            game.drawCard(player);
        } catch (Exception e) {}
    }

}
