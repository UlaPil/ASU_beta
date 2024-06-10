package main.model;

import main.viewModel.GameEndManager;
import main.viewModel.HandManager;
import main.viewModel.TopCardManager;

import java.util.ArrayList;
import java.util.List;

import static main.model.Symbol.*;

public class Game {
    private ArrayList<TopCardManager> cardObservers;
    private ArrayList<HandManager> handObservers;
    private ArrayList<GameEndManager> endObservers;
    private int gameDirection;
    private int blockCount;
    private int plus2Count;
    private GameEndManager gameEndManager;
    private ArrayList<Player> playerList;
    private ArrayList<Integer> blockList;

    private Board board;
    private static List<Playable> cards = GenerateCards.getCardsList();
    public Player currentPlayer;
    private int modulo;
    public int currentIndex;
    public boolean gameOver = false;

    public Game(String player) {
        cardObservers = new ArrayList<>();
        handObservers = new ArrayList<>();
        endObservers = new ArrayList<>();
        modulo = 4;     //na aktualne potrzeby
        currentIndex = 0;
        blockCount = 0;
        plus2Count = 0;
        board = new Board(cards);
        playerList = new ArrayList<>();
        blockList = new ArrayList<>();
        gameEndManager = new GameEndManager();
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
            for(int i=0 ; i<7 ; i++) {
                Playable card = board.drawFromPile();
                player.draw(card);
                for(HandManager observer : handObservers) {
                    observer.notify(card, player, true);

                }
            }
            for(TopCardManager observer : cardObservers) {
                observer.notify(board.getTopCard());
            }
        }
        currentPlayer = playerList.get(0);
    }

    private void playBot() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Object lock = new Object();
            System.out.println("currentPlayer: " + currentPlayer);
                Playable card = brain(currentPlayer);
                if (card != null) {
                    playCard(currentPlayer, card);
                } else {
                    drawCard(currentPlayer);
                }
            //}

    }

    public Playable brain(Player player) {
        int i = 0;
        while (i < player.getHandSize()) {
            if (player.getCard(i).isPlayable(board.getTopCard().getSymbol(), board.getTopCard().getColor())) {
                return player.getCard(i);
            }
            i++;
        }
        return null;
    }

    public void playCard(Player player, Playable card) {
        if(gameOver) return;
        if(card.isPlayable(board.getTopCard().getSymbol(),board.getTopCard().getColor()) && player==currentPlayer) {
            System.out.println(blockCount);
            System.out.println(plus2Count);
            //if (blockCount > 0 && card.getSymbol() != block) return;
            //if (plus2Count> 0 && card.getSymbol() != plusTwo) return;

            if (card.getSymbol() == block) blockCount++;
            if (card.getSymbol() == plusTwo) plus2Count++;
            player.playCard(card);
            board.playOnBoard(card);
            ifSpecial(card); // TODO: obsługa block, reverse i plus
            gameOver = currentPlayer.didIWin();
            if(gameOver) {
                gameEndManager.notify(currentIndex);
            }
            currentIndex += gameDirection;
            if (blockList.get((currentIndex+4)%4) > 0) {
                currentIndex += gameDirection;
                blockList.set((currentIndex+4)%4, blockList.get((currentIndex+4)%4) - 1);
            }
            currentIndex = (currentIndex+4)%4;
            currentPlayer = playerList.get(currentIndex);
            for(TopCardManager observer : cardObservers) {
                observer.notify(card);
            }
            for(HandManager observer : handObservers) {
                observer.notify(card, player, false);
            }
            if(player.equals(playerList.get(0))) {
                while(currentPlayer != getMainPlayer()) {
                    if (gameOver) break;
                    playBot();
                }
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
            if (blockList.get((currentIndex+4)%4) > 0) {
                currentIndex += gameDirection;
                blockList.set((currentIndex+4)%4, blockList.get((currentIndex+4)%4) - 1);
            }
            currentIndex = (currentIndex+4)%4;
            currentPlayer = playerList.get(currentIndex);
            for(HandManager observer : handObservers) {
                observer.notify(card, player, true);
            }
            if(player.equals(playerList.get(0))) {
                while(currentPlayer != getMainPlayer()) {
                    if (gameOver) break;
                    playBot();
                }
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
        return gameOver;
    }
    
    public void addCardObserver(TopCardManager observer) {
        cardObservers.add(observer);
    }

    public void deleteCardObserver(TopCardManager observer) {
        cardObservers.remove(observer);
    }
    public void addEndObserver(GameEndManager observer) {
        endObservers.add(observer);
    }
    public void deleteEndObserver(GameEndManager observer) {
        endObservers.remove(observer);
    }

    public void addHandObserver(HandManager observer) {
        System.out.println("added");
        handObservers.add(observer);
    }

    public void deleteHandObserver(HandManager observer) {
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
