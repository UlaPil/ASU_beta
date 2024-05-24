package main.core;

public class ChangeColorCard implements Playable{
    Card card;
    public ChangeColorCard() { card = new Card("changeColor", "black") ; }

    @Override
    public boolean isPlayable(String color, String symbol) { return true; }

    @Override
    public String getColor() { return card.getColor(); }

    @Override
    public String getSymbol() { return card.getSymbol(); }

    @Override
    public void onPlay(Board board) {
        //board.setNextPlayerStatus("changecolor");
    }

    public String toString() { return card.toString(); }
}
