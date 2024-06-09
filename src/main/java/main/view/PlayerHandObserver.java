package main.view;

import java.util.Observer;

public class PlayerHandObserver{
    GameView view;
    PlayerHandObserver(GameView view) {
        this.view = view;
    }
    public void notify(CardDisplay card, boolean add) {
        if (add) {
            view.addCardToPlayerHand(card);
        }
        else {
            view.removeCardFromPlayerHand(card);
        }
    }
}
