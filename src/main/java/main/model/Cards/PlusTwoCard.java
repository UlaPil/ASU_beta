package main.model.Cards;

import static main.model.Cards.Symbol.plusTwo;

public class PlusTwoCard implements Playable {
    private final Card card;
    public PlusTwoCard(Color color) { card = new Card(plusTwo, color); }

    @Override
    public boolean isPlayable(Symbol symbol, Color color) { return card.isPlayable(symbol, color); }

    @Override
    public Color getColor() { return card.getColor(); }

    @Override
    public Symbol getSymbol() { return card.getSymbol(); }

    @Override
    public String toString() { return card.toString(); }
}
