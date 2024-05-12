package core;

public class RealPlayer implements Player {
    public RealPlayer(String name, Board board) {
        this.name = name;
        myHand = new Hand();
        myBoard = board;
    }
    private String name;
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
        myHand.putInHand(myBoard.drawFromPile());
    }
    // Asu i po  asu

    public String toString() {
        return myHand.toString();
    }
}
