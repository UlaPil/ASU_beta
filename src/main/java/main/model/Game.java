package main.model;

import javafx.application.Platform;
import main.viewModel.GameEndManager;
import main.viewModel.HandManager;
import main.viewModel.TopCardManager;

import java.util.*;

import static main.model.Color.*;
import static main.model.Symbol.*;

public class Game {
    private Timer timer = new Timer();
    private ArrayList<TopCardManager> cardObservers;
    private ArrayList<HandManager> handObservers;
    private ArrayList<GameEndManager> endObservers;
    private int gameDirection;
    private int blockCount;
    private int plus2Count;
    private int plus4Count;
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
        plus4Count = 0;
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
        Playable card = brain(currentPlayer);
        if (card != null) {
            playCard(currentPlayer, card);
        } else {
            drawCard(currentPlayer);
        }

    }

    public Playable brain(Player player) {
        int i = 0;
        if (plus2Count > 0) {
            while (i < player.getHandSize()) {
                if (player.getCard(i).getSymbol().equals(plusTwo)) {
                    return player.getCard(i);
                }
                i++;
            }
            return null;
        }
        if (plus4Count > 0) {
            while (i < player.getHandSize()) {
                if (player.getCard(i).getSymbol().equals(plusFour)) {
                    return player.getCard(i);
                }
                i++;
            }
            return null;
        }
        if (blockCount > 0) {
            while (i < player.getHandSize()) {
                if (player.getCard(i).getSymbol().equals(block)) {
                    return player.getCard(i);
                }
                i++;
            }
            return null;
        }
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
            if (blockCount > 0 && card.getSymbol() != block) {
                if(player.equals(playerList.get(0))) {
                    handleBotsTurn();
                }
                return;
            }
            if (plus2Count> 0 && card.getSymbol() != plusTwo) {
                if(player.equals(playerList.get(0))) {
                    handleBotsTurn();
                }
                return;
            }
            if (plus4Count> 0 && card.getSymbol() != plusFour) {
                if(player.equals(playerList.get(0))) {
                    handleBotsTurn();
                }
                return;
            }
            player.playCard(card);
            board.playOnBoard(card);
            ifSpecial(card);
            gameOver = currentPlayer.didIWin();
            if(gameOver) {
                gameEndManager.notify(currentIndex);
            }
            currentIndex += gameDirection;
            if (blockList.get((currentIndex+4)%4) > 0) {
                blockList.set((currentIndex+4)%4, blockList.get((currentIndex+4)%4) - 1);
                currentIndex += gameDirection;
            }
            currentIndex = (currentIndex+4)%4;
            currentPlayer = playerList.get(currentIndex);
            for(HandManager observer : handObservers) {
                observer.notify(card, player, false);
            }
            for(TopCardManager observer : cardObservers) {
                observer.notify(board.getTopCard());
            }
            if(player.equals(playerList.get(0))) {
                handleBotsTurn();
            }

        }
    }

    private void wait(Runnable function, int delay) {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(function);
            }
        }, delay);
    }

    private void handleBotsTurn() {
        if(currentPlayer != getMainPlayer()) {
            if (gameOver) return;
            wait(new Runnable() {
                @Override
                public void run() {
                    playBot();
                    if(currentPlayer != getMainPlayer())
                    {
                        if (gameOver) return;
                        Game.this.wait(this, 1800);
                    }
                }}, 1800);
        }
    }

    public void drawCard(Player player) {
        if(gameOver) return;
        if (player != currentPlayer) return;
        try {
            if (blockCount > 0) {
                blockList.set(currentIndex, blockList.get(currentIndex) + blockCount - 1);
                blockCount = 0;
            } else if (plus2Count > 0) {
                int temp = plus2Count;
                plus2Count = 0;
                for (int i = 0; i < temp; i++) {
                    Playable card = board.drawFromPile();
                    player.draw(card);
                    for(HandManager observer : handObservers) {
                        observer.notify(card, player, true);
                    }
                }
            } else if (plus4Count > 0) {
            int temp = plus4Count;
            plus4Count = 0;
            for (int i = 0; i < temp; i++) {
                Playable card = board.drawFromPile();
                player.draw(card);
                for(HandManager observer : handObservers) {
                    observer.notify(card, player, true);
                }
            }
        } else {
                Playable card = board.drawFromPile();
                player.draw(card);
                for(HandManager observer : handObservers) {
                    observer.notify(card, player, true);
                }
            }
            currentIndex += gameDirection;
            if (blockList.get((currentIndex+4)%4) > 0) {
                currentIndex += gameDirection;
                blockList.set((currentIndex+4)%4, blockList.get((currentIndex+4)%4) - 1);
            }
            currentIndex = (currentIndex+4)%4;
            currentPlayer = playerList.get(currentIndex);
            if(player.equals(playerList.get(0))) {
                handleBotsTurn();
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
            plus2Count+=2;
        }
        if(card.getSymbol() == plusFour) {
            plus2Count+=4;
        }
        if((card.getSymbol() == changeColor || card.getSymbol() == plusFour) && currentPlayer != getMainPlayer()) {
            Color color = botChooseColor();
            board.setTopColor(color);
        }
    }

    public Color botChooseColor() {
        int i = 0;
        HashMap<Color, Integer> map = new HashMap<>();
        map.put(blue, 0);
        map.put(red, 0);
        map.put(yellow, 0);
        map.put(green, 0);

        while (i < currentPlayer.getHandSize()) {
            switch (currentPlayer.getCard(i).getColor()) {
                case blue -> map.replace(blue, map.get(blue) + 1);
                case red -> map.replace(red, map.get(red) + 1);
                case green -> map.replace(green, map.get(green) + 1);
                case yellow -> map.replace(yellow, map.get(yellow) + 1);
                default -> {}
            }
            i++;
        }
        Color colorMaximum = blue;
        for(Color color :Color.values()) {
            if(color != wild && map.get(colorMaximum) < map.get(color)) colorMaximum = color;
        }
        return colorMaximum;
    }

    public boolean gameOver() {
        return gameOver;
    }
    
    public void addCardObserver(TopCardManager observer) {
        cardObservers.add(observer);
    }

    public void addHandObserver(HandManager observer) {
        handObservers.add(observer);
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

    public void reset() {
        for(Player player : playerList) {
            board.addToPile(player.getHand().getCards());
            player.clearHand();
        }
        board.reset();
        currentIndex = 0;
        blockCount = 0;
        plus2Count = 0;
        gameDirection = 1;
        gameOver = false;
        blockList.replaceAll(e -> 0);
    }
}
