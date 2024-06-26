package main.viewModel;

import main.model.Cards.Color;
import main.model.Game;
import main.model.Cards.Playable;
import main.model.Player;

public class ModelManager {
    public final Game game;
    public ModelManager(Game game) { this.game = game;}

    public void removeFromPlayerHand(Player player, Playable card) {
        game.playCard(player, card);
    }

    public void addToPlayerHand(Player player) {
        try {
            game.drawCard(player);
        } catch (Exception ignored) {}
    }

    public void changeTopColor(Color color) {
        game.setTopCard(color);
    }

}
