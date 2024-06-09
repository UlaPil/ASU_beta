package main.model;

import static main.model.Color.wild;
import static main.model.Symbol.changeColor;

public class ChangeColorCard implements Playable{
    Card card;
    public ChangeColorCard() { card = new Card(changeColor, wild) ; }

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

    public String toString() { return card.toString(); }
}
