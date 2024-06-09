package main.model;

import static main.model.Symbol.block;

public class BlockCard implements Playable{
    Card card;
    public BlockCard(Color color) {
        card = new Card(block, color) ;
    }
    @Override
    public boolean isPlayable(Symbol symbol, Color color) {
        return card.isPlayable(symbol, color);
    }

    @Override
    public Color getColor() {
        return card.getColor();
    }

    @Override
    public Symbol getSymbol() {
        return card.getSymbol();
    }

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
