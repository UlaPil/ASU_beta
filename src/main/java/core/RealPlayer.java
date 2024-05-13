package core;

public class RealPlayer implements Player {
    public RealPlayer(String name, Board board) {
        this.name = name;
        myHand = new Hand();
        myBoard = board;
    }
    private final String name;
    private Hand myHand;
    private Board myBoard;
    public String getName() {
        return name;
    }

    @Override
    public boolean didIWin() {
        return myHand.getSize() == 0;
    }

    @Override
    public void draw(int count) throws NoMoreCardsInDeck {
        for(int i=0 ; i<count ; i++) myHand.putInHand(myBoard.drawFromPile());
    }

    @Override
    public boolean playCard(int index) throws IncorrectInput {
        if(index <= 0 || index > myHand.getSize()) {throw new IncorrectInput();}
        Playable topCard = myBoard.getTopCard();
        if(myHand.getFromHand(index).isPlayable(topCard.getColor(), topCard.getSymbol())) {
            myBoard.playOnBoard(myHand.getFromHand(index - 1));
            myBoard.getTopCard().onPlay(myBoard);
            myHand.removeFromHand(index - 1);
            return true;
        }
        return false;
    }

    // Asu i po  asu
    @Override
    public String toString() {
        return myHand.toString();
    }
}
