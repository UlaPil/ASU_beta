package main.view;

import main.model.Player;

public class GameEndObserver {
    int index;
    Winner winner;
    public GameEndObserver() {
        winner = new Winner();
    }
    public void notify(int index) {
        this.index = index;
        winner.show(index);
    }
}
