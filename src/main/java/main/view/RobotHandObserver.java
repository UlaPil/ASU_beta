package main.view;

import main.model.Hand;
import main.model.Player;

import java.util.Collection;

public class RobotHandObserver {
    Player player;
    GameView view;
    public RobotHandObserver(GameView view) {
        this.view = view;
    }
    public void notify(boolean add) {
        if (add) {}
    }
}
