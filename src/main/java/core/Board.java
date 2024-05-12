package core;

import java.util.*;
public class Board {
    protected ArrayList<Player> playerList;
    private int gameDirection;
    private Deck deck;

    protected static class Deck {
        Stack<Playable> drawPile;
        Stack<Playable> playPile;

        //inicjalizacja dwoch stackow które mamy;
        Deck(Collection<Playable> cards) {
            drawPile = new Stack<>();
            playPile = new Stack<>();
            for (Playable card: cards)
                drawPile.push(card);
            shuffle();
            // wyłożenie pierwszej karty na play pile
            try {
                play(draw());
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
        }

        public Playable getTopCard() {
            return playPile.firstElement();
        }
    }

    public Board(Collection<Playable> cards) {
        deck = new Deck(cards);
        gameDirection = 1;
    }

    public void removePlayer(Player player) {
        playerList.remove(player);
    }

    public void notifyPlayers(String name) {
        // notyfikuje wszystkich graczy jaką kartę wystawił gracz kończący swoją turę
        // czyli informuje o aktualnych zmianach na stole
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
        gameDirection = -1;
    }

    public int getGameDirection() {
        return gameDirection;
    }
}