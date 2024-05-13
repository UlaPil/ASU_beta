package core;

public class ChangeColorCard implements Playable{
    

    @Override
    public boolean isPlayable(String color, String symbol) {
        return false;
    }

    @Override
    public String getColor() {
        return ;
    }

    @Override
    public String getSymbol() {
        return null;
    }

    @Override
    public void onPlay(Board board) {

    }
}
