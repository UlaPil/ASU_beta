package core;
//symbole : 0-9 cyfry

public interface Playable {
    public boolean isPlayable(String color, String symbol);

    public String getColor();
    public String getSymbol();

}
