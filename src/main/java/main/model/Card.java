package main.model;

public class Card implements Playable{
    private Symbol symbol;
    private Color color;
    private int hash;
    public Card(Symbol symbol, Color color) {
        this.symbol = symbol;
        this.color = color;
        this.hash = 17 * symbol.getHash()+ color.getHash();
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public Color getColor() {
        return color;
    }
    public int getHash() {return hash;}
    public void setHash(int i) {
        this.hash += i*512 ;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Card o) {
            return getHash() == o.getHash();
        }
        return false;
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