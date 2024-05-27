package main.model;
//symbole : 0-9 cyfry

public interface Playable {
    public boolean isPlayable(String color, String symbol);

    public String getColor();
    public String getSymbol();
    public void onPlay(Board  board);
}