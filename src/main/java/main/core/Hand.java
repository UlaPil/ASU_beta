package main.core;

import java.util.ArrayList;
import java.util.Comparator;

public class Hand {
    private ArrayList<Playable> cards = new ArrayList<>();

    @Override
    public String toString() {
        cards.sort(new Comparator<Playable>() {
            @Override
            public int compare(Playable card1, Playable card2) {
                int colorsCompare = card1.getColor().compareTo(card2.getColor());
                if (colorsCompare != 0) return colorsCompare;
                return card1.getSymbol().compareTo(card2.getSymbol());
            }
        });
        StringBuilder a = new StringBuilder();
        for(int i = 0 ; i < cards.size() ; i++) {
            a.append(i + 1).append(": ").append(cards.get(i)).append("\n");
        }
        a.deleteCharAt(a.length()-1);
        return a.toString();
    }
    public int getSize() {
        return cards.size();
    }

    public void putInHand(Playable card) {
        cards.add(card);
    }

    public Playable getFromHand(int index) {
        return cards.get(index);
    }

    public void removeFromHand(int index) {
        cards.remove(index);
    }

}
