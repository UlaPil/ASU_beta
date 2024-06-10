package main.viewModel;

import main.view.GameEndObserver;

public class GameEndManager {
    GameEndObserver gameEndObserver;
    public GameEndManager() {
        gameEndObserver = new GameEndObserver();
    }
    public void notify(int index) {
        gameEndObserver.notify(index);
    }
}
