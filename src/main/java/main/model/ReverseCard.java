package main.model;

import static main.model.Symbol.reverse;

public class ReverseCard implements Playable {
    private final Card card;
    public ReverseCard(Color color) {
        card = new Card(reverse, color);

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
    public String toString () { return card.toString(); }
}
