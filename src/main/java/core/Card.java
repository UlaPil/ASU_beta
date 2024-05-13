package core;

public class Card implements Playable{
    private String symbol;
    private String color;
    public Card(String symbol, String color) {
        this.symbol = symbol;
        this.color = color;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public void onPlay(Board board) {
    }

    public String getColor() {
        return color;
    }

    @Override
    public boolean isPlayable(String color, String symbol) {
        if(this.color.equals(color) || this.symbol.equals(symbol)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "(" + color + " ," + symbol + ")";
    }
}
