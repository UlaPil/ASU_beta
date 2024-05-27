package main.viewModel;

import main.model.Game;
import main.model.Playable;
import main.view.GameView;

public class HandObserver {
    HandManager manager;
    HandObserver(GameView view) {
        this.manager = new HandManager(view);
    }
    public void updateAdd(Playable card) {
        manager.updateAdd(card);
    }
    public void updateDelete(Playable card) {
        manager.updateDelete(card);
    }
}
