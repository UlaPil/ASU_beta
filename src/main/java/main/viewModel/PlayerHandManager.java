package main.viewModel;


import main.model.Playable;
import main.view.CardDisplay;
import main.view.GameView;

public class PlayerHandManager {

    GameView view;
    public PlayerHandManager(GameView view) {
        this.view = view;
    }

    public void updateAdd(Playable card) {
        view.addCardToPlayerHand(new CardDisplay(card));
    }
    public void updateDelete(Playable card) {
        view.removeCardFromPlayerHand(new CardDisplay(card));
    }
}
