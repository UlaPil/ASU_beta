package main.view;

import main.model.Player;

public interface HandObserver {
     void notify( int index, CardDisplay card, Player player, boolean add);

}
