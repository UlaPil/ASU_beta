package main.model;

import java.util.ArrayList;
import java.util.List;

public class Game {
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
            Playable card = new Card(i.toString(),"red");
            cards.add(card);
            cards.add(card);
        }
        for(Integer i=0 ; i<10 ; i++) {
            Playable card = new Card (i.toString(),"blue");
            cards.add(card);
            cards.add(card);
        }
        for(Integer i=0 ; i<10 ; i++) {
            Playable card = new Card (i.toString(),"yellow");
            cards.add(card);
            cards.add(card);
        }
        for(Integer i=0 ; i<10 ; i++) {
            Playable card = new Card (i.toString(),"green");
            cards.add(card);
            cards.add(card);
        }
        for(int i=0 ; i<2 ; i++) {
            Playable reversecard = new ReverseCard("red");
            cards.add(reversecard);
            Playable blockcard = new BlockCard("red");
            cards.add(blockcard);
        }
        for(int i=0 ; i<2 ; i++) {
            Playable reversecard = new ReverseCard("blue");
            cards.add(reversecard);
            Playable blockcard = new BlockCard("blue");
            cards.add(blockcard);
        }
        for(int i=0 ; i<2 ; i++) {
            Playable reversecard = new ReverseCard("yellow");
            cards.add(reversecard);
            Playable blockcard = new BlockCard("yellow");
            cards.add(blockcard);
        }
        for(int i=0 ; i<2 ; i++) {
            Playable reversecard = new ReverseCard("green");
            cards.add(reversecard);
            Playable blockcard = new BlockCard("green");
            cards.add(blockcard);
        }
        for(int i=0 ; i<4 ; i++) {
            Playable changecolorcard = new ChangeColorCard();
            cards.add(changecolorcard);
        }
    }{
        for(Integer i=0 ; i<10 ; i++) {
            Playable card = new Card (i.toString(),"red");
            cards.add(card);
            cards.add(card);
        }
        for(Integer i=0 ; i<10 ; i++) {
            Playable card = new Card (i.toString(),"blue");
            cards.add(card);
            cards.add(card);
        }
        for(Integer i=0 ; i<10 ; i++) {
            Playable card = new Card (i.toString(),"yellow");
            cards.add(card);
            cards.add(card);
        }
        for(Integer i=0 ; i<10 ; i++) {
            Playable card = new Card (i.toString(),"green");
            cards.add(card);
            cards.add(card);
        }
        for(int i=0 ; i<2 ; i++) {
            Playable reversecard = new ReverseCard("red");
            cards.add(reversecard);
            Playable blockcard = new BlockCard("red");
            cards.add(blockcard);
        }
        for(int i=0 ; i<2 ; i++) {
            Playable reversecard = new ReverseCard("blue");
            cards.add(reversecard);
            Playable blockcard = new BlockCard("blue");
            cards.add(blockcard);
        }
        for(int i=0 ; i<2 ; i++) {
            Playable reversecard = new ReverseCard("yellow");
            cards.add(reversecard);
            Playable blockcard = new BlockCard("yellow");
            cards.add(blockcard);
        }
        for(int i=0 ; i<2 ; i++) {
            Playable reversecard = new ReverseCard("green");
            cards.add(reversecard);
            Playable blockcard = new BlockCard("green");
            cards.add(blockcard);
        }
        for(int i=0 ; i<4 ; i++) {
            Playable changecolorcard = new ChangeColorCard();
            cards.add(changecolorcard);
        }
    }
    public Game(String ... players) {
        // docelowo: modulo=players.length();
        modulo = 4;     //na aktualne potrzeby
        currentIndex = 0;
        draw = false;
        board = new Board(cards);
        playerList = new ArrayList<>();
        playerList.add(new RealPlayer(players[0], board));
        playerList.add(new AutomaticPlayer("Bot1", board));
        playerList.add(new AutomaticPlayer("Bot2", board));
        playerList.add(new AutomaticPlayer("Bot3", board));
        gameDirection = 1;
        nextPlayerStatus = "";
    }
    private void startGame() throws NoMoreCardsInDeck {
        for (Player player: playerList) {
            player.draw(7);
        }
        currentPlayer = playerList.get(0);
    }

    public boolean gameOver() {
        for (Player player: playerList) {
            if (player.didIWin()) return true;
        }
        return false;
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
