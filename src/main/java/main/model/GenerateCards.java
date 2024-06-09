package main.model;

import java.util.ArrayList;
import java.util.List;

import static main.model.Color.*;
import static main.model.Color.green;
import static main.model.Symbol.one;

public class GenerateCards {
    private static List<Playable> cards = new ArrayList<>();
    public GenerateCards() {}
    public static List<Playable> getCardsList() {
        Playable cardR = new Card(one.getSymbolOfNumber(0), red);
        cards.add(cardR);
        Playable cardB = new Card(one.getSymbolOfNumber(0), blue);
        cards.add(cardB);
        Playable cardY = new Card(one.getSymbolOfNumber(0), yellow);
        cards.add(cardY);
        Playable cardG = new Card(one.getSymbolOfNumber(0), green);
        cards.add(cardG);
        for (int j = 0; j < 2;  j++) {
            for (int i = 1; i < 10; i++) {
                Playable card = new Card(one.getSymbolOfNumber(i), red);
                card.setHash();
                cards.add(card);
            }
            for (int i = 1; i < 10; i++) {
                Playable card = new Card(one.getSymbolOfNumber(i), blue);
                cards.add(card);
            }
            for (int i = 1; i < 10; i++) {
                Playable card = new Card(one.getSymbolOfNumber(i), yellow);
                cards.add(card);
            }
            for (int i = 1; i < 10; i++) {
                Playable card = new Card(one.getSymbolOfNumber(i), green);
                cards.add(card);
            }
            for (int i = 0; i < 2; i++) {
                Playable reverseCard = new ReverseCard(red);
                cards.add(reverseCard);
                Playable blockCard = new BlockCard(red);
                cards.add(blockCard);
                Playable plusTwoCard = new PlusTwoCard(red);
                cards.add(plusTwoCard);
            }
            for (int i = 0; i < 2; i++) {
                Playable reverseCard = new ReverseCard(blue);
                cards.add(reverseCard);
                Playable blockCard = new BlockCard(blue);
                cards.add(blockCard);
                Playable plusTwoCard = new PlusTwoCard(blue);
                cards.add(plusTwoCard);
            }
            for (int i = 0; i < 2; i++) {
                Playable reverseCard = new ReverseCard(yellow);
                cards.add(reverseCard);
                Playable blockCard = new BlockCard(yellow);
                cards.add(blockCard);
                Playable plusTwoCard = new PlusTwoCard(yellow);
                cards.add(plusTwoCard);
            }
            for (int i = 0; i < 2; i++) {
                Playable reverseCard = new ReverseCard(green);
                cards.add(reverseCard);
                Playable blockCard = new BlockCard(green);
                cards.add(blockCard);
                Playable plusTwoCard = new PlusTwoCard(green);
                cards.add(plusTwoCard);
            }
            for (int i = 0; i < 2; i++) {
                Playable changeColorCard = new ChangeColorCard();
                cards.add(changeColorCard);
                Playable plusFourCard = new PlusFourCard();
                cards.add(plusFourCard);
            }
        }
        return cards;
    }
}
