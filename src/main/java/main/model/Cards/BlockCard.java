package main.model.Cards;

import static main.model.Cards.Symbol.block;

public class BlockCard implements Playable {
    private final Card card;
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


    public String toString() { return card.toString(); }
}
