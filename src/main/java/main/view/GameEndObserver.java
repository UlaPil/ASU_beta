package main.view;

public class GameEndObserver {
    private final Winner winner;
    public GameEndObserver() {
        winner = new Winner();
    }
    public void notify(int index) {
        winner.show(index);
    }
}
