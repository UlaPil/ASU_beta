package core;

import java.util.*;
public class Board {
    protected ArrayList<? extends Player> playerList;
    private String nextPlayerAction;
    private int gameDirection;

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

    public Board() {

    }
    public void addPlayer(Player player){}
    public void removePlayer(String name){}
    public void notifyPlayer(String name){}
    public String toString(){
        return null;
    }
    public void playOnBoard(Playable card) {

    }
    public Playable drawFromPile() {
        return null;
    }
    public void setNextPlayerAction(String actiom) {

    }
    public String getNextPlayerAction() {
        return null;
    }
    public Playable getTopCard() {
        return null;
    }
    public void reverseGameDirection() {

    }
}
//
//
//package core;
//
//import java.util.*;
//
//public class Board {
//    public class Deck {
//        private Stack<Playable> draw;
//        private Stack<Playable> play;
//        private ArrayList<? extends Playable> cards = new ArrayList<>();
//        Deck() {
//            draw = shuffleAndStack(cards);
//            play = new Stack<>();
//        }
//
//        private Stack<Playable> shuffleAndStack(ArrayList<? extends Playable> cards) {
//            Collections.shuffle(cards);
//            Stack<Playable> stack = new Stack<>();
//            for (Playable card: cards)
//                stack.push(card);
//            return stack;
//        }
//
//        public Playable draw() {
//            return draw.pop();
//        }
//
//        public void play(Playable card) {
//            play.push(card);
//        }
//    }
//    private List<Player> players = new ArrayList<>();
//    private int direction; // kierunek kolejki 1 lub -1
//}