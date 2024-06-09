package main.viewModel;

import main.model.Playable;
import main.model.Player;

public interface HandManager {
    public void notify(Playable card, Player player, boolean add);
}
