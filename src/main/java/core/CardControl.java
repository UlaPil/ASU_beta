package core;

public class CardControl {
    Board board;
    CardControl(Board board) {
        this.board = board;
    }
    public void onPlay(Playable card) {
        if(card.getSymbol().equals("reverse")) {board.reverseGameDirection();}
    }
}
