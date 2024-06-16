package main.model;

import java.util.ArrayList;
import java.util.Comparator;

public class Hand {
    private final ArrayList<Playable> cards = new ArrayList<>();
    private final Comparator<Playable> comparator = (a,b) -> a.getColor().compareTo(b.getColor()) == 0 ? a.getSymbol().compareTo(b.getSymbol()) : a.getColor().compareTo(b.getColor());
    @Override
    public String toString() {
        cards.sort(comparator);
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
        cards.sort(comparator);
    }

    public Playable getFromHand(int index) {
        return cards.get(index);
    }

    public void removeFromHand(Playable card) {
        cards.remove(card);
    }
    public ArrayList<Playable> getCards() {
        return cards;
    }
    public void clear() {
        cards.clear();
    }
}
