package core;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Playable> cards = new ArrayList<>();
    @Override
    public String toString() {
        StringBuilder a=new StringBuilder();
        for(Playable card : cards) {
            a.append(card.toString());
        }
        return a.toString();
    }
    public int getSize() {
        return cards.size();
    }

}
