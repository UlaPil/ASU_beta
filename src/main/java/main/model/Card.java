package main.model;

public class Card implements Playable{
    private Symbol symbol;
    private Color color;
    private int hash;
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
        if(this.color.equals(color) || this.symbol.equals(symbol)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "(" + color.toString() + ", " + symbol.toString() + ")";
    }
}