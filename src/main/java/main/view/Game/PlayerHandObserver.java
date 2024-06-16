package main.view.Game;

import main.model.Player;


public class PlayerHandObserver implements HandObserver {
    GameView view;
    Player player;
    public PlayerHandObserver(GameView view, Player player) {
        this.view = view;
        this.player = player;
    }
    public void notify(CardDisplay card, Player player, boolean add) {
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
