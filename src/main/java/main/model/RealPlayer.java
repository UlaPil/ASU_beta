package main.model;

import java.util.ArrayList;

public class RealPlayer implements Player{
    public RealPlayer(String name) {
        this.name = name;
        myHand = new Hand();
    }
    private final String name;
    private Hand myHand;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean didIWin() {
        return myHand.getSize() == 0;
    }

    @Override
    public void draw(Playable card) throws NoMoreCardsInDeck {
        myHand.putInHand(card);
    }

    @Override
    public void playCard(Playable card) {
        myHand.removeFromHand(card);
    }
    // Asu i po  asu
    @Override
    public String toString() {
        return myHand.toString();
    }

    @Override
    public Playable getCard(int index) {
        return myHand.getFromHand(index);
    }

    @Override
    public int getHandSize() {
        return myHand.getSize();
    }

    @Override
    public Hand getHand() {
        return myHand;
    }

    @Override
    public void clearHand() {
        myHand.clear();
    }
}
