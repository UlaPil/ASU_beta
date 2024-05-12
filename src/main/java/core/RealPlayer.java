package core;

public class RealPlayer implements Player {
    public RealPlayer(String name, Board board) {
        this.name = name;
        myHand = new Hand();
        myBoard = board;
        cardControl = new CardControl(board);
    }
    private final String name;
    private Hand myHand;
    private Board myBoard;
    private final CardControl cardControl;
    public String getName() {
        return name;
    }

    @Override
    public boolean didIWin() {
        return myHand.getSize() == 0;
    }

    @Override
    public void draw(int count) throws NoMoreCardsInDeck {
        myHand.putInHand(myBoard.drawFromPile());
    }

    @Override
    public boolean play(int index) {
        Playable topCard = myBoard.getTopCard();
        if(myHand.getFromHand(index).isPlayable(topCard.getColor(), topCard.getSymbol())) {
            myBoard.playOnBoard(myHand.getFromHand(index));
            cardControl.onPlay(myHand.getFromHand(index));
            myHand.removeFromHand(index);
            return true;
        }
        return false;
    }

    // Asu i po  asu

    public String toString() {
        return myHand.toString();
    }
}
