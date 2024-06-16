package main.view.Game;

import main.model.Player;

public interface HandObserver {
     void notify(CardDisplay card, Player player, boolean add);

}
