package core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Stack;
import java.util.Collections;
//TODO zaimplementowac wszystkie metody i zastanowic sie czy czegos nie brakuje
public class Board {
    protected ArrayList<? extends Player> playerList;
    private String nextPlayerAction;
    private int gameDirection;
    protected static class Deck {
        Stack<? extends Playable> drawPile;
        Stack<? extends Playable> playPile;
        //inicjalizacja dwoch stackow które mamy;
        Deck(Collection<? extends Playable> cards) {
        }
        private void shuffle() {
            //nie ma za co (jak cos to ta metoda nie jest gotowa raczej)
            Collections.shuffle(drawPile);
        }
        // zwraca true jesli chociaz jedna karta zostala przerzucona na draw pile
        private boolean refillDrawPile() {
            return false;
        }
        //rzuca wyjatek gdy nie ma kart do dobrania
        public Playable draw() throws NoMoreCardsInDeck {
            return null;
        }
        public void play(Playable card) {
        }
        public Playable getTopCard(){
            return null;
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
