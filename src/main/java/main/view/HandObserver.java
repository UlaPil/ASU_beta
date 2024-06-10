package main.view;

import main.model.Player;

public interface HandObserver {
     void notify(CardDisplay card, Player player, boolean add);

}
