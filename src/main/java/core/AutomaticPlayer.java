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

    }

    @Override
    public boolean play(int index){
        return false;
    }
}
