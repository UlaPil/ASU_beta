package main.model;

public class ReverseCard implements Playable {
    Card card;
    public ReverseCard(String color) {
        card = new Card("reverse", color);

    }
    @Override
    public boolean isPlayable(String color, String symbol) {
        return card.isPlayable(color, symbol);
    }

    @Override
    public String getColor() {
        return card.getColor();
    }

    @Override
    public String getSymbol() {
        return card.getSymbol();
    }

    @Override
    public void onPlay(Board board) {
        //board.reverseGameDirection();
    }

    @Override
    public String toString () { return card.toString(); }
}
