package main.model;

import main.viewModel.HandManager;
import main.viewModel.TopCardManager;

import java.util.ArrayList;
import java.util.List;

import static main.model.Symbol.*;

public class Game {
    private ArrayList<TopCardManager> cardObservers;
    private ArrayList<HandManager> handObservers;
    private int gameDirection;
    private int blockCount;
    private int plus2Count;
    private ArrayList<Player> playerList;
    private ArrayList<Integer> blockList;
    private Board board;
    private static List<Playable> cards = GenerateCards.getCardsList();
    public Player currentPlayer;
    private int modulo;
    public int currentIndex;

    public Game(String player) {
        cardObservers = new ArrayList<>();
        handObservers = new ArrayList<>();
        modulo = 4;     //na aktualne potrzeby
        currentIndex = 0;
        blockCount = 0;
        plus2Count = 0;
        board = new Board(cards);
        playerList = new ArrayList<>();
        blockList = new ArrayList<>();
        playerList.add(new RealPlayer(player));
        playerList.add(new RealPlayer("Bot1"));
        playerList.add(new RealPlayer("Bot2"));
        playerList.add(new RealPlayer("Bot3"));
        for (int i = 0; i < modulo; i++) blockList.add(0);
        gameDirection = 1;
    }

    public Player getMainPlayer() {
        return playerList.get(0);
    }

    public void startGame() throws NoMoreCardsInDeck {
        for (Player player: playerList) {
            for(int i=0 ; i<7 ; i++) player.draw(board.drawFromPile());
        }
        currentPlayer = playerList.get(0);
    }

    private void playBots() {
        while(currentPlayer != getMainPlayer()) {
            Playable card = brain(currentPlayer);
            if (card != null) {
                playCard(currentPlayer, card);
            } else {
                drawCard(currentPlayer);
            }
        }
    }

    public Playable brain(Player player) {
        int i = 1;
        while (true) {
            if (player.getCard(i).isPlayable(board.getTopCard().getSymbol(), board.getTopCard().getColor())) {
                return player.getCard(i);
            }
            if(i >= player.getHandSize()) break;
            i++;
        }
        return null;
    }

    public void playCard(Player player, Playable card) {
        if(card.isPlayable(board.getTopCard().getSymbol(),board.getTopCard().getColor()) && player==currentPlayer) {
            player.playCard(card);
            board.playOnBoard(card);
            ifSpecial(card); // TODO: obsługa block, reverse i plus
            currentIndex += gameDirection;
            if (blockList.get(currentIndex) > 0) {
                currentIndex += gameDirection;
                blockList.set(currentIndex, blockList.get(currentIndex) - 1);
            }
            currentIndex = currentIndex%4;
            currentPlayer = playerList.get(currentIndex);
            for(TopCardManager observer : cardObservers) {
                observer.notify(card);
            }
            for(HandManager observer : handObservers) {
                observer.notify(card, player, false);
            }
            if(player.equals(playerList.get(0))) {
                playBots();
            }
        }
    }

    public void drawCard(Player player) {
        if (player != currentPlayer) return;
        if (blockCount > 0) {
            blockList.set(currentIndex, blockList.get(currentIndex) + blockCount);
            blockCount = 0;
            return;
        }
        if (plus2Count > 0) {
            int temp = plus2Count;
            plus2Count = 0;
            for (int i = 0; i < temp; i++) drawCard(player);
            blockCount = 0;
            return;
        }
        try {
            Playable card = board.drawFromPile();
            player.draw(card);
            currentIndex += gameDirection;
            if (blockList.get(currentIndex) > 0) {
                currentIndex += gameDirection;
                blockList.set(currentIndex, blockList.get(currentIndex) - 1);
            }
            currentIndex = currentIndex%4;
            currentPlayer = playerList.get(currentIndex);
            for(HandManager observer : handObservers) {
                observer.notify(card, player, true);
            }
            if(player.equals(playerList.get(0))) {
                playBots();
            }
        } catch (NoMoreCardsInDeck e) {
            System.out.println("Game over. No more cards :(");
        }
    }

    public void ifSpecial(Playable card) {
        if(card.getSymbol() == block) {
            blockCount++;
        }
        if(card.getSymbol() == reverse) {
            reverseGameDirection();
        }
        if(card.getSymbol() == plusTwo) {
            plus2Count++;
        }
        if(card.getSymbol() == changeColor && currentPlayer != getMainPlayer()) {
            // TODO: bot musi wybrac kolor i zmienić kolor top karty
        }
    }

    public boolean gameOver() {
        for (Player player: playerList) {
            if (player.didIWin()) return true;
        }
        return false;
    }
    
    public void addObserver(TopCardManager observer) {
        cardObservers.add(observer);
    }

    public void deleteObserver(TopCardManager observer) {
        cardObservers.remove(observer);
    }

    public void oddObserver(HandManager observer) {
        handObservers.add(observer);
    }

    public void deleteObserver(HandManager observer) {
        handObservers.remove(observer);
    }

    public void setTopCard(Color color) {
        board.setTopColor(color);
    }
    public Playable getTopCard() {
        return board.getTopCard();
    }


    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void reverseGameDirection() {
        gameDirection = -1 * gameDirection;
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

    public int getModulo() {
        return modulo;
    }
}
