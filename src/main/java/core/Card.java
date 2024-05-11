package core;

public class Card implements Playable{
    protected int number;
    protected String color;
    public Card(int number, String color) {
        this.number = number;
        this.color = color;
    }

    public int getNumber() {
        return number;
    }
    public String getColor() {
        return color;
    }

    @Override
    public boolean isPlayable(String color, int number) {
        if(this.color.equals(color) || this.number == number) {
            return true;
        }
        return false;
    }
    public void play(Board board) {

    }
}
