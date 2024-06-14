package main.model;

import java.util.ArrayList;

public interface Player {
    String getName();
    boolean didIWin();
    void draw(Playable card) throws NoMoreCardsInDeck;
    void playCard(Playable card);
    String toString();
    Playable getCard(int i);
    int getHandSize();
    Hand getHand();
    void clearHand();
}
