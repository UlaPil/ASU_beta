package main.view.Game;

import main.model.Player;

public class RobotHandObserver implements HandObserver {
    private final GameView view;
    private final Player player;
    public RobotHandObserver(GameView view, Player player) {
        this.view = view;
        this.player = player;
    }
    public void notify(CardDisplay card, Player player, boolean add) {
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
