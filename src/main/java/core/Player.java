package core;

public interface Player {
    String getName();
    boolean didIWin();
    void draw(int count) throws NoMoreCardsInDeck;
    boolean playCard(int index) throws IncorrectInput;
    String toString();
    boolean ifBlocked();
    void setBlocked(int amount);
}
