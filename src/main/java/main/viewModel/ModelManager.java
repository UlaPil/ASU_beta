package main.viewModel;

import main.model.Game;
import main.model.Playable;
import main.model.Player;
import main.view.CardDisplay;

public class ModelManager {
    public Game game;
    public ModelManager(Game game) { this.game = game;}

    public void removeFromPlayerHand(Player player, Playable card) {
        game.playCard(player, card);
    }

    public void addToPlayerHand(Player player) {
        try {
            game.drawCard(player);
        } catch (Exception e) {}
    }

}
