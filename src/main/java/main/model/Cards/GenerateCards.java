package main.model.Cards;

import java.util.ArrayList;
import java.util.List;

import static main.model.Cards.Color.*;
import static main.model.Cards.Color.green;
import static main.model.Cards.Symbol.one;

public class GenerateCards {
    private GenerateCards() {}
    public static List<Playable> getCardsList() {
        List<Playable> cards = new ArrayList<>();
        Playable cardR = new Card(one.getSymbolOfNumber(0), red);
        cards.add(cardR);
        Playable cardB = new Card(one.getSymbolOfNumber(0), blue);
        cards.add(cardB);
        Playable cardY = new Card(one.getSymbolOfNumber(0), yellow);
        cards.add(cardY);
        Playable cardG = new Card(one.getSymbolOfNumber(0), green);
        cards.add(cardG);
        for (int i = 0; i < 2;  i++) {
            for (int j = 1; j < 10; j++) {
                for(Color x : Color.values()) {
                    if(x == wild) continue;
                    Playable card = new Card(one.getSymbolOfNumber(j), x);
                    cards.add(card);
                }
            }
        }
        for (int i = 0; i < 2; i++) {
            for (Color x : Color.values()) {
                if(x == wild) continue;
                Playable reverseCard = new ReverseCard(x);
                Playable blockCard = new BlockCard(x);
                Playable plusTwoCard = new PlusTwoCard(x);
                cards.addAll(List.of(reverseCard, blockCard, plusTwoCard));
            }
        }
        for (int i = 0; i < 4; i++) {
            Playable changeColorCard = new ChangeColorCard();
            cards.add(changeColorCard);
            Playable plusFourCard = new PlusFourCard();
            cards.add(plusFourCard);
        }
        return cards;
    }
}
