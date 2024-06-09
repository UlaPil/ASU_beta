package main.view;

import main.model.Player;

public interface HandObserver {
     void notify(Player player, CardDisplay card, boolean add);

}
