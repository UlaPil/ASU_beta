package main.viewModel;

import main.model.Game;
import main.model.Playable;

public class TopCardObserver {
    TopCardManager menager;
    TopCardObserver(Game game) {
        menager = new TopCardManager(game);
    }
    public void update(Playable card) {
        menager.update(card);
    }
}
