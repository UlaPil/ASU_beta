package main.view;

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
