package core;

import java.util.*;
public class Board {
    private int gameDirection;
    private Deck deck;
    private String nextPlayerStatus;
    private int howManySpecialCards;

    protected static class Deck {
        Stack<Playable> drawPile;
        Stack<Playable> playPile;
        String topColor;

        //inicjalizacja dwoch stackow które mamy;
        Deck(Collection<Playable> cards) {
            drawPile = new Stack<>();
            playPile = new Stack<>();

            for (Playable card: cards)
                drawPile.push(card);

            shuffle();
            
            // wyłożenie pierwszej karty na play pile
            try {
                do {
                    play(draw());
                } while (List.of("block", "changeColor", "reverse").contains(getTopCard().getSymbol()));
            } catch (NoMoreCardsInDeck e) {
                throw new RuntimeException(e);
            }
        }

        private void shuffle() {
            Collections.shuffle(drawPile);
        }

        // zwraca true jesli chociaz jedna karta zostala przerzucona na draw pile
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

        //rzuca wyjatek gdy nie ma kart do dobrania
        public Playable draw() throws NoMoreCardsInDeck {
            if (drawPile.isEmpty()) throw new NoMoreCardsInDeck();
            return drawPile.pop();
        }

        public void play(Playable card) {
            playPile.push(card);
            topColor = card.getColor();
        }

        public Playable getTopCard() {
            return new Card(playPile.lastElement().getSymbol(), topColor);
        }
    }

    public Board(Collection<Playable> cards) {
        deck = new Deck(cards);
        gameDirection = 1;
        howManySpecialCards =0;
        nextPlayerStatus="";
    }

    public void setTopColor(String color) {
        deck.topColor = color;
    }

    @Override
    public String toString() {
        return deck.getTopCard().toString();
    }

    public void playOnBoard(Playable card) {
        deck.play(card);
    }

    public Playable drawFromPile() throws NoMoreCardsInDeck {
        try {
            return deck.draw();
        } catch (NoMoreCardsInDeck e) {
            if (deck.refillDrawPile()) {
                return deck.draw();
            }
            throw new NoMoreCardsInDeck();
        }
    }

    public Playable getTopCard() {
        return deck.getTopCard();
    }

    public void reverseGameDirection() {
        gameDirection = -1 * gameDirection;
    }

    public int getGameDirection() {
        return gameDirection;
    }

    public void setNextPlayerStatus(String status) {
        nextPlayerStatus = status;
    }

    public String getNextPlayerStatus() {
        return nextPlayerStatus;
    }

    public int getHowMany() {
        return howManySpecialCards;
    }

    public void incrementSpecialCard() {
        howManySpecialCards++;
    }
}