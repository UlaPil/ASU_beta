package main.view.Game;


import main.model.Cards.Card;
import main.model.Cards.Color;
import main.model.Cards.Playable;
import main.model.Cards.Symbol;

public class TopCardObserver {
    private final GameView gameView;
    public TopCardObserver(GameView gameView) {
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
