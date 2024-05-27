package main.viewModel;

import main.model.Game;
import main.model.Playable;

public class HandObserver {
    HandManager menager;
    HandObserver(Game game) {
        menager = new HandManager(game);
    }
    public void updateAdd(Playable card) {
        menager.updateAdd(card);
    }
    public void updateDelete(Playable card) {
        menager.updateDelete(card);
    }
}
