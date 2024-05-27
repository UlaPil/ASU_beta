package main.model;

public class BlockCard implements Playable{
    Card card;
    public BlockCard(String color) {
        card = new Card("block", color) ;
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
        board.setNextPlayerStatus("block");
    }

    public String toString() { return card.toString(); }
}
