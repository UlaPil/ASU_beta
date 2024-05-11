package core;

import java.util.*;

public class Board {
    public class Deck {
        private Stack<Playable> draw;
        private Stack<Playable> play;
        private ArrayList<? extends Playable> cards = new ArrayList<>();
        Deck() {
            draw = shuffleAndStack(cards);
            play = new Stack<>();
        }

        private Stack<Playable> shuffleAndStack(ArrayList<? extends Playable> cards) {
            Collections.shuffle(cards);
            Stack<Playable> stack = new Stack<>();
            for (Playable card: cards)
                stack.push(card);
            return stack;
        }

        public Playable draw() {
            return draw.pop();
        }

        public void play(Playable card) {
            play.push(card);
        }
    }
    private List<Player> players = new ArrayList<>();
    private int direction; // kierunek kolejki 1 lub -1
}