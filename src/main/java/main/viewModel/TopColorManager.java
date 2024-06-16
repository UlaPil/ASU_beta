package main.viewModel;

import main.model.Cards.Color;
import main.model.Game;

public class TopColorManager {
    Game game;
    public TopColorManager(Game game) {
        this.game = game;
    }
    public void getTopColor(Color  color) {
        game.getBoard().setTopColor(color);
    }
}
