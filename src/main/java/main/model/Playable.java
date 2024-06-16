package main.model;
//symbole : 0-9 cyfry

public interface Playable {
    boolean isPlayable(Symbol symbol, Color color);
    Color getColor();
    Symbol getSymbol();
}
