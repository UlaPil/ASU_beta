package core;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Playable> cards = new ArrayList<>();
    @Override
    public String toString() {
        StringBuilder a = new StringBuilder();
        for(int i = 0 ; i < cards.size() ; i++) {
            a.append(i + 1).append(':').append(cards.get(i)).append(", ");
        }
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
