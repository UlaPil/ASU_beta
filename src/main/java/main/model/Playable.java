package main.model;
//symbole : 0-9 cyfry

public interface Playable {
    public boolean isPlayable(Symbol symbol, Color color);

    public Color getColor();
    public Symbol getSymbol();
    public int getHash();
    public void setHash(int hash);
}
