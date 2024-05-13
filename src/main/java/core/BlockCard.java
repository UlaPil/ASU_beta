package core;

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
        return card.getSymbol();
    }

    @Override
    public String getSymbol() {
        return card.getColor();
    }

    @Override
    public void onPlay(Board board) {
        board.setNextPlayerStatus("block ");
    }
}
