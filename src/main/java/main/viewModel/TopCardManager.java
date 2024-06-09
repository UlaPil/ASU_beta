package main.viewModel;


import main.model.Playable;
import main.view.GameView;
import main.view.TopCardObserver;

import java.util.List;

public class TopCardManager{
    List<TopCardObserver> observers;
    GameView gameView;
    TopCardManager(GameView gameView) {
        this.gameView = gameView;
    }
    public void addObserver(TopCardObserver observer) {observers.add(observer);}
    public void removeObserver(TopCardObserver observer) {observers.remove(observer);}

    public void update(Playable card){
        for(TopCardObserver observer : observers){
            observer.notify(card);
        }
    }

}

