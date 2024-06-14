package main.model;

import java.util.*;

import static main.model.Symbol.*;

public class Board {
    ArrayList<Playable> drawPile;
    ArrayList<Playable> playPile;
    Color topColor;

    public Board(Collection<Playable> cards) {
        drawPile = new ArrayList<>();
        playPile = new ArrayList<>();

        drawPile.addAll(cards);

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
        return new Card(playPile.get(playPile.size() - 1).getSymbol(), topColor);
    }

    public void setTopColor(Color color) {
        topColor = color;
    }

    @Override
    public String toString() {
        return getTopCard().toString();
    }

    public void playOnBoard(Playable card) {
        playPile.add(card);
        topColor = card.getColor();
    }

    public Playable drawFromPile() throws NoMoreCardsInDeck {
        if (drawPile.isEmpty()) {
            if (refillDrawPile()) {
                return drawPile.remove(drawPile.size() - 1);
            }
        } else {
            return drawPile.remove(drawPile.size() - 1);
        }
        throw new NoMoreCardsInDeck();
    }
    public void reset() {
        while(!playPile.isEmpty()) {
            drawPile.add(playPile.get(playPile.size() - 1));
            playPile.remove(playPile.size() - 1);
        }
        shuffle();
        try {
            do {
                playOnBoard(drawFromPile());
            } while (List.of(block, changeColor, reverse, plusFour, plusTwo).contains(getTopCard().getSymbol()));
        } catch (NoMoreCardsInDeck e) {
            throw new RuntimeException(e);
        }
    }
    public void addToPile(Collection<? extends Playable> cards) {
        playPile.addAll(cards);
    }
    private boolean refillDrawPile() {
        if (playPile.isEmpty() || playPile.size() == 1) return false;
        Playable lastCard = playPile.remove(playPile.size() - 1);
        while (!playPile.isEmpty()) {
            drawPile.add(playPile.get(playPile.size() - 1));
            playPile.remove(playPile.size() - 1);
        }
        shuffle();
        playPile.add(lastCard);
        return true;
    }
}