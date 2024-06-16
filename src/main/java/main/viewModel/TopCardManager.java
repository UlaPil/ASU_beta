package main.viewModel;


import main.model.Cards.Playable;
import main.view.Game.GameView;
import main.view.Game.TopCardObserver;

import java.util.ArrayList;
import java.util.List;

public class TopCardManager{
    private final List<TopCardObserver> observers;

    public TopCardManager(GameView gameView) {
        observers = new ArrayList<>();
    }
    public void addObserver(TopCardObserver observer) {observers.add(observer);}
    public void removeObserver(TopCardObserver observer) {observers.remove(observer);}

    public void notify(Playable card){
        for(TopCardObserver observer : observers){
            observer.notify(card);
        }
    }

}

