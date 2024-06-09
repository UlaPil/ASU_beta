package main.model;

import java.util.*;

import static main.model.Symbol.*;

public class Board {
    Stack<Playable> drawPile;
    Stack<Playable> playPile;
    Color topColor;

    public Board(Collection<Playable> cards) {
        drawPile = new Stack<>();
        playPile = new Stack<>();

        for (Playable card: cards)
            drawPile.push(card);

        shuffle();

        // wyłożenie pierwszej karty na play pile
        try {
            do {
                playOnBoard(drawFromPile());
            } while (List.of(block, changeColor, reverse, plusFour, plusTwo).contains(getTopCard().getSymbol()));
        } catch (NoMoreCardsInDeck e) {
            throw new RuntimeException(e);
        }
    }

    private void shuffle() {
        Collections.shuffle(drawPile);
    }

    public Playable getTopCard() {
        return new Card(playPile.lastElement().getSymbol(), topColor);
    }

    public void setTopColor(Color color) {
        topColor = color;
    }

    @Override
    public String toString() {
        return getTopCard().toString();
    }

    public void playOnBoard(Playable card) {
        playPile.push(card);
        topColor = card.getColor();
    }

    public Playable drawFromPile() throws NoMoreCardsInDeck {
        if (drawPile.isEmpty()) {
            if (refillDrawPile()) {
                return drawPile.pop();
            }
        } else {
            return drawPile.pop();
        }
        throw new NoMoreCardsInDeck();
    }

    private boolean refillDrawPile() {
        if (playPile.isEmpty() || playPile.size() == 1) return false;
        Playable lastCard = playPile.pop();
        while (!playPile.isEmpty()) {
            drawPile.push(playPile.pop());
        }
        shuffle();
        playPile.push(lastCard);
        return true;
    }
}