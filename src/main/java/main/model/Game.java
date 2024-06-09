package main.model;

import main.viewModel.PlayerHandManager;
import main.viewModel.TopCardManager;

import java.util.ArrayList;
import java.util.List;

import static main.model.Color.*;
import static main.model.Symbol.*;

public class Game {
    private ArrayList<TopCardManager> cardObservers;
    private ArrayList<PlayerHandManager> handObservers;
    private int gameDirection;
    private String nextPlayerStatus;
    private ArrayList<Player> playerList;
    private ArrayList<Integer> blockList;
    private Board board;
    private static List<Playable> cards = GenerateCards.getCardsList();
    public Player currentPlayer;
    private int modulo;
    public int currentIndex;
    public boolean draw;

    public Game(String player) {
        // docelowo: modulo=players.length();
        cardObservers = new ArrayList<>();
        handObservers = new ArrayList<>();
        modulo = 4;     //na aktualne potrzeby
        currentIndex = 0;
        draw = false;
        board = new Board(cards);
        playerList = new ArrayList<>();
        blockList = new ArrayList<>();
        playerList.add(new RealPlayer(player));
        playerList.add(new RealPlayer("Bot1"));
        playerList.add(new RealPlayer("Bot2"));
        playerList.add(new RealPlayer("Bot3"));
        for (int i = 0; i < modulo; i++) blockList.add(0);
        gameDirection = 1;
        nextPlayerStatus = "";
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
            try {
                Playable card = brain(currentPlayer);
                if (card != null) {
                    board.playOnBoard(card);
                } else {
                    card = board.drawFromPile();
                    // dodac karte do reki bota 
                }
            } catch (NoMoreCardsInDeck e) {
                System.out.println("Game over. No more cards :(");
            }
            // grają boty i notifikują view jesli cos się zmieni 
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

    public void oddObserver(PlayerHandManager observer) {
        handObservers.add(observer);
    }

    public void deleteObserver(PlayerHandManager observer) {
        handObservers.remove(observer);
    }

    public Playable brain(Player player) throws NoMoreCardsInDeck {
        int i = 1;
        while (true) {
            if (player.getCard(i).isPlayable(board.getTopCard().getSymbol(), board.getTopCard().getColor())) {
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
                for(PlayerHandManager observer : handObservers) {
                    observer.updateDelete(card);
                }
            }
            for(TopCardManager obserwer : cardObservers) {
                obserwer.update(card);
            }
            return true;
        }
        return false;
    }

    public void setTopCard(Color color) {
        board.setTopColor(color);
    }
    public Playable getTopCard() {
        return board.getTopCard();
    }


    public boolean drawCard(Player player) throws NoMoreCardsInDeck {
        try {
            Playable card = board.drawFromPile();
            player.draw(card);
            if(player.equals(playerList.get(0))) {
                for(PlayerHandManager observer : handObservers) {
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
