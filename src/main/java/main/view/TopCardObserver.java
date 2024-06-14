package main.view;


import main.model.Playable;

public class TopCardObserver {
    GameView gameView;
    TopCardObserver(GameView gameView) {
        this.gameView = gameView;
    }
    public void notify( Playable card) {
        gameView.setTopCard(new CardDisplay(card));
        gameView.setTopColor(card.getColor());
    }
}
