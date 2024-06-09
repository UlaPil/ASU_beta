package main.viewModel;

import main.model.Playable;
import main.model.Player;
import main.view.HandObserver;

import java.util.List;

public class HandManager {
    List<HandObserver> handObservers;
    public void addObserver(HandObserver handObserver) {
        if (handObservers == null) {}
    }
    void notify(Playable card, Player player, boolean add) {

    }
}
