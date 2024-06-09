package main.view;

import main.model.Player;

public class RobotHandObserver implements HandObserver {
    GameView view;
    Player player;
    RobotHandObserver(GameView view, Player player) {
        this.view = view;
        this.player = player;
    }
    public void notify( int index, CardDisplay card, Player player,boolean add) {
        if(!this.player.equals(player)) {
            return;
        }
        if (add) {
            view.addCardToRobotHand(player);
        }
        else {
            view.removeCardFromRobotHand(player);
        }
    }
}
