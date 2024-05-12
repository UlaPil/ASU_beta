package core;

public class ReverseCard implements Playable {
    Card card;
    public ReverseCard(String color) {
        card = new Card(color, "reverse");

    }
    @Override
    public boolean isPlayable(String color, String symbol) {
        return card.isPlayable(color, symbol);
    }

    @Override
    public String getColor() {
        return card.getColor();
    }

    @Override
    public String getSymbol() {
        return card.getSymbol();
    }
}
