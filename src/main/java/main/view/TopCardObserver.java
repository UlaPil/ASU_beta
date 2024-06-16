package main.view;


import main.model.Card;
import main.model.Color;
import main.model.Playable;
import main.model.Symbol;

public class TopCardObserver {
    private final GameView gameView;
    TopCardObserver(GameView gameView) {
        this.gameView = gameView;
    }
    public void notify(Playable card) {
        if (card.getSymbol() == Symbol.changeColor || card.getSymbol() == Symbol.plusFour) {
            gameView.setTopCard(new CardDisplay(new Card(card.getSymbol(), Color.wild)));
            if (card.getColor() == Color.wild) {
                Color color = gameView.showColorPicker();
                gameView.setTopColor(color);
                gameView.eventFactory.changeTopColor(color);
            }
        } else
            gameView.setTopCard(new CardDisplay(card));
        gameView.setTopColor(card.getColor());
    }
}
