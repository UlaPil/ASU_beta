package main.viewModel;

import main.model.Playable;
import main.model.Player;
import main.view.CardDisplay;
import main.view.HandObserver;

import java.util.ArrayList;
import java.util.List;

public class HandManager {
    List<HandObserver> handObservers;
    HandManager() {
        handObservers = new ArrayList<>();
    }
    public void addObserver(HandObserver handObserver) {
        handObservers.add(handObserver);
    }
    public void removeObserver(HandObserver handObserver) {
        handObservers.remove(handObserver);
    }
    public void notify(Playable card, Player player, boolean add) {
        for(HandObserver handObserver : handObservers) {
            handObserver.notify(player,new CardDisplay(card),add);
        }
    }
}
