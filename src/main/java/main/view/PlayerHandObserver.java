package main.view;

import main.model.Player;

import java.util.Observer;

public class PlayerHandObserver implements HandObserver{
    GameView view;
    Player player;
    PlayerHandObserver(GameView view) {
        this.view = view;
    }
    public void notify(Player player, CardDisplay card, boolean add) {
        if(!this.player.equals(player)) {
            return;
        }
        if (add) {
            view.addCardToPlayerHand(card);
        }
        else {
            view.removeCardFromPlayerHand(card);
        }
    }
}
