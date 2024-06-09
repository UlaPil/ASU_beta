package main.viewModel;


import main.model.Playable;
import main.model.Player;
import main.view.CardDisplay;
import main.view.GameView;
import main.view.HandObserver;

import java.util.ArrayList;
import java.util.List;

public class PlayerHandManager {
    List<HandObserver> observers = new ArrayList<>();
    Player player;
    PlayerHandManager(Player player) {
        this.player = player;
    }
    public void addObserver(HandObserver observer) {
        observers.add(observer);
    }
    public void removeObserver(HandObserver observer) {
        observers.remove(observer);
    }
    public void notify(Playable playable, Player player, boolean add) {
        if (this.player == player) {

        }
    }
}
