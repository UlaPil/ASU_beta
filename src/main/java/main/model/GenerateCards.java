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
                card.setHash(j);
                cards.add(card);
            }
            for (int i = 1; i < 10; i++) {
                Playable card = new Card(one.getSymbolOfNumber(i), blue);
                card.setHash(j);
                cards.add(card);

            }
            for (int i = 1; i < 10; i++) {
                Playable card = new Card(one.getSymbolOfNumber(i), yellow);
                card.setHash(j);
                cards.add(card);
            }
            for (int i = 1; i < 10; i++) {
                Playable card = new Card(one.getSymbolOfNumber(i), green);
                card.setHash(j);
                cards.add(card);
            }
        }
            /*for (int i = 0; i < 2; i++) {
                Playable reverseCard = new ReverseCard(red);
                reverseCard.setHash(j);
                cards.add(reverseCard);
                Playable blockCard = new BlockCard(red);
                blockCard.setHash(j);
                cards.add(blockCard);
                Playable plusTwoCard = new PlusTwoCard(red);
                plusTwoCard.setHash(j);
                cards.add(plusTwoCard);
            }
            for (int i = 0; i < 2; i++) {
                Playable reverseCard = new ReverseCard(blue);
                reverseCard.setHash(j);
                cards.add(reverseCard);
                Playable blockCard = new BlockCard(blue);
                blockCard.setHash(j);
                cards.add(blockCard);
                Playable plusTwoCard = new PlusTwoCard(blue);
                plusTwoCard.setHash(j);
                cards.add(plusTwoCard);
            }
            for (int i = 0; i < 2; i++) {
                Playable reverseCard = new ReverseCard(yellow);
                reverseCard.setHash(j);
                cards.add(reverseCard);
                Playable blockCard = new BlockCard(yellow);
                blockCard.setHash(j);
                cards.add(blockCard);
                Playable plusTwoCard = new PlusTwoCard(yellow);
                plusTwoCard.setHash(j);
                cards.add(plusTwoCard);
            }
            for (int i = 0; i < 2; i++) {
                Playable reverseCard = new ReverseCard(green);
                reverseCard.setHash(j);
                cards.add(reverseCard);
                Playable blockCard = new BlockCard(green);
                blockCard.setHash(j);
                cards.add(blockCard);
                Playable plusTwoCard = new PlusTwoCard(green);
                plusTwoCard.setHash(j);
                cards.add(plusTwoCard);
            }
            for (int i = 0; i < 2; i++) {
                Playable changeColorCard = new ChangeColorCard();
                changeColorCard.setHash(j);
                cards.add(changeColorCard);
                Playable plusFourCard = new PlusFourCard();
                plusFourCard.setHash(j);
                cards.add(plusFourCard);
            }
        }*/
        return cards;
    }
}
