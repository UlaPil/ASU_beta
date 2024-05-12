package core;

public interface Player {
    String getName();
    boolean didIWin();
    void draw(int count) throws NoMoreCardsInDeck;
    String toString();

}
