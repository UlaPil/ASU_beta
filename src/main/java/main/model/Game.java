package main.model;

import main.viewModel.HandObserver;
import main.viewModel.TopCardObserver;

import java.util.ArrayList;
import java.util.List;

import static main.model.Color.*;
import static main.model.Symbol.*;

public class Game {
    private ArrayList<TopCardObserver> cardObservers;
    private ArrayList<HandObserver> handObservers;
    private int gameDirection;
    private String nextPlayerStatus;
    private ArrayList<Player> playerList;
    private Board board;
    private static List<Playable> cards = new ArrayList<>();
    public Player currentPlayer;
    private int modulo;
    public int currentIndex;
    public boolean draw;
    static {
        for(Integer i=0 ; i<10 ; i++) {
            Playable card = new Card(one.getSymbolOfNumber(i), red);
            cards.add(card);
            cards.add(card);
        }
        for(Integer i=0 ; i<10 ; i++) {
            Playable card = new Card (one.getSymbolOfNumber(i), blue);
            cards.add(card);
            cards.add(card);
        }
        for(Integer i=0 ; i<10 ; i++) {
            Playable card = new Card (one.getSymbolOfNumber(i), yellow);
            cards.add(card);
            cards.add(card);
        }
        for(Integer i=0 ; i<10 ; i++) {
            Playable card = new Card (one.getSymbolOfNumber(i), green);
            cards.add(card);
            cards.add(card);
        }
        for(int i=0 ; i<2 ; i++) {
            Playable reversecard = new ReverseCard(red);
            cards.add(reversecard);
            Playable blockcard = new BlockCard(red);
            cards.add(blockcard);
        }
        for(int i=0 ; i<2 ; i++) {
            Playable reversecard = new ReverseCard(blue);
            cards.add(reversecard);
            Playable blockcard = new BlockCard(blue);
            cards.add(blockcard);
        }
        for(int i=0 ; i<2 ; i++) {
            Playable reversecard = new ReverseCard(yellow);
            cards.add(reversecard);
            Playable blockcard = new BlockCard(yellow);
            cards.add(blockcard);
        }
        for(int i=0 ; i<2 ; i++) {
            Playable reversecard = new ReverseCard(green);
            cards.add(reversecard);
            Playable blockcard = new BlockCard(green);
            cards.add(blockcard);
        }
        for(int i=0 ; i<4 ; i++) {
            Playable changecolorcard = new ChangeColorCard();
            cards.add(changecolorcard);
        }
    }
    static {
        for(Integer i=0 ; i<10 ; i++) {
            Playable card = new Card (one.getSymbolOfNumber(i),red);
            cards.add(card);
            cards.add(card);
        }
        for(Integer i=0 ; i<10 ; i++) {
            Playable card = new Card (one.getSymbolOfNumber(i), blue);
            cards.add(card);
            cards.add(card);
        }
        for(Integer i=0 ; i<10 ; i++) {
            Playable card = new Card (one.getSymbolOfNumber(i), yellow);
            cards.add(card);
            cards.add(card);
        }
        for(Integer i=0 ; i<10 ; i++) {
            Playable card = new Card (one.getSymbolOfNumber(i), green);
            cards.add(card);
            cards.add(card);
        }
        for(int i=0 ; i<2 ; i++) {
            Playable reversecard = new ReverseCard(red);
            cards.add(reversecard);
            Playable blockcard = new BlockCard(red);
            cards.add(blockcard);
        }
        for(int i=0 ; i<2 ; i++) {
            Playable reversecard = new ReverseCard(blue);
            cards.add(reversecard);
            Playable blockcard = new BlockCard(blue);
            cards.add(blockcard);
        }
        for(int i=0 ; i<2 ; i++) {
            Playable reversecard = new ReverseCard(yellow);
            cards.add(reversecard);
            Playable blockcard = new BlockCard(yellow);
            cards.add(blockcard);
        }
        for(int i=0 ; i<2 ; i++) {
            Playable reversecard = new ReverseCard(green);
            cards.add(reversecard);
            Playable blockcard = new BlockCard(green);
            cards.add(blockcard);
        }
        for(int i=0 ; i<4 ; i++) {
            Playable changecolorcard = new ChangeColorCard();
            cards.add(changecolorcard);
        }
    }
    public Game(String player) {
        // docelowo: modulo=players.length();
        cardObservers = new ArrayList<>();
        handObservers = new ArrayList<>();
        modulo = 4;     //na aktualne potrzeby
        currentIndex = 0;
        draw = false;
        board = new Board(cards);
        playerList = new ArrayList<>();
        playerList.add(new RealPlayer(player));
        playerList.add(new RealPlayer("Bot1"));
        playerList.add(new RealPlayer("Bot2"));
        playerList.add(new RealPlayer("Bot3"));
        gameDirection = 1;
        nextPlayerStatus = "";
    }
    public void startGame() throws NoMoreCardsInDeck {
        for (Player player: playerList) {
            for(int i=0 ; i<7 ; i++) player.draw(board.drawFromPile());
        }
        currentPlayer = playerList.get(0);
    }

    public boolean gameOver() {
        for (Player player: playerList) {
            if (player.didIWin()) return true;
        }
        return false;
    }
    public void addObserver(TopCardObserver observer) {
        cardObservers.add(observer);
    }

    public void deleteObserver(TopCardObserver observer) {
        cardObservers.remove(observer);
    }

    public void oddObserver(HandObserver observer) {
        handObservers.add(observer);
    }

    public void deleteObserver(HandObserver observer) {
        handObservers.remove(observer);
    }

    public Playable brain(Player player) throws NoMoreCardsInDeck {
        int i = 1;
        while (true) {
            if (player.getCard(i).isPlayable(board.getTopCard().getSymbol(),board.getTopCard().getColor())) {
                //board.playOnBoard(player.getCard(i));
                return player.getCard(i);
            }
            if(i >= player.getHandSize()) break;
            i++;
        }
        player.draw(board.drawFromPile());
        return null;
    }

    public boolean playCard(Player player, Playable card) {
        if(card.isPlayable(board.getTopCard().getSymbol(),board.getTopCard().getColor())) {
            player.playCard(card);
            board.playOnBoard(card);
            ifSpecial(card);
            currentIndex += gameDirection;
            currentIndex = (currentIndex + 4) % 4;
            if(player.equals(playerList.get(0))) {
                for(HandObserver observer : handObservers) {
                    observer.updateDelete(card);
                }
            }
            for(TopCardObserver obserwer : cardObservers) {
                obserwer.update(card);
            }
            return true;
        }
        return false;
    }

    public void setTopCard(Color color) {
        board.setTopColor(color);
    }



    public boolean drawCard(Player player) throws NoMoreCardsInDeck {
        try {
            Playable card = board.drawFromPile();
            player.draw(card);
            if(player.equals(playerList.get(0))) {
                for(HandObserver observer : handObservers) {
                    observer.updateAdd(card);
                }
            }
            currentIndex += gameDirection;
            currentIndex = (currentIndex + 4) % 4;
            return true;
        } catch (NoMoreCardsInDeck e) {
            throw e;
        }
    }

    public void ifSpecial(Playable card) {
        if(card.getSymbol().isSpecial()) {
            if(card.getSymbol() == block) {
                currentIndex += gameDirection;
            }
        }
        if(card.getSymbol() == reverse) {
            reverseGameDirection();
        }
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void reverseGameDirection() {
        gameDirection = -1 * gameDirection;
    }

    public int getGameDirection() {
        return gameDirection;
    }

    public void setNextPlayerStatus(String status) {
        nextPlayerStatus = status;
    }

    public String getNextPlayerStatus() {
        return nextPlayerStatus;
    }

    public static List<Playable> getCards() {
        return cards;
    }

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    public Board getBoard() {
        return board;
    }

    public Object getCurrentIndex() {
        return currentIndex;
    }

    public int getModulo() {
        return modulo;
    }
}
