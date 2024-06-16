package main.model;

public class Card implements Playable{
    private final Symbol symbol;
    private final Color color;
    public Card(Symbol symbol, Color color) {
        this.symbol = symbol;
        this.color = color;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public boolean isPlayable(Symbol symbol, Color color) {
        return this.color.equals(color) || this.symbol.equals(symbol);
    }

    @Override
    public String toString() {
        return "(" + color.toString() + ", " + symbol.toString() + ")";
    }
}