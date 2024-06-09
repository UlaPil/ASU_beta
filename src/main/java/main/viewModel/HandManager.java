package main.viewModel;

import main.model.Playable;
import main.model.Player;

public interface HandManager {
    void notify(Playable card, Player player, boolean add);
}
