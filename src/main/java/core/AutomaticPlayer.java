package core;

public class AutomaticPlayer implements Player {
    @Override
    public String getName() {
        return "";
    }

    @Override
    public boolean didIWin() {
        return false;
    }

    @Override
    public void draw(int count) throws NoMoreCardsInDeck {
        return false;
    }
}
