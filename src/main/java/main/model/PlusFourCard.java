package main.model;

import static main.model.Color.wild;
import static main.model.Symbol.plusFour;

public class PlusFourCard implements Playable {
    Card card;
    public PlusFourCard() { card = new Card(plusFour, wild); }

    @Override
    public boolean isPlayable(Symbol symbol, Color color) { return true; }

    @Override
    public Color getColor() { return card.getColor(); }

    @Override
    public Symbol getSymbol() { return card.getSymbol(); }

    @Override
    public int getHash() {
        return card.getHash();
    }

    @Override
    public void setHash(int hash) {
        card.setHash(hash);
    }

    @Override
    public String toString() { return card.toString(); }
}
