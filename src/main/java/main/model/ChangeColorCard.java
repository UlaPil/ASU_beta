package main.model;

import static main.model.Color.wild;
import static main.model.Symbol.changeColor;

public class ChangeColorCard implements Playable{
    private final Card card;
    public ChangeColorCard() { card = new Card(changeColor, wild) ; }

    @Override
    public boolean isPlayable(Symbol symbol, Color color) { return true; }

    @Override
    public Color getColor() { return card.getColor(); }

    @Override
    public Symbol getSymbol() { return card.getSymbol(); }



    public String toString() { return card.toString(); }
}
