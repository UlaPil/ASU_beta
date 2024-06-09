package main.viewModel;

import main.model.Playable;
import main.model.Player;
import main.view.CardDisplay;
import main.view.HandObserver;

import java.util.ArrayList;
import java.util.List;

public class HandManager {
    List<HandObserver> handObservers;
    public HandManager() {
        handObservers = new ArrayList<>();
    }
    public void addObserver(HandObserver handObserver) {
        System.out.println("addHandObserver");
        handObservers.add(handObserver);
    }
    public void removeObserver(HandObserver handObserver) {
        handObservers.remove(handObserver);
    }
    public void notify(int index, Playable card, Player player, boolean add) {
        for(HandObserver handObserver : handObservers) {
            handObserver.notify(index, new CardDisplay(card),player,add);
        }
        System.out.println("notifyHandObservers");
    }
}
