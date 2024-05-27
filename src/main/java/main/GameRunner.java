package main;

import java.util.Random;
import java.util.Scanner;

import main.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GameRunner {
    private Game game;
//    private ArrayList<Player> playerList;
//    public Board board;
//    private static List<Playable> cards = new ArrayList<>();
//    public Player currentPlayer;
//    private int modulo;
//    private int currentIndex;
//    private boolean draw;
//    static {
//        for(Integer i=0 ; i<10 ; i++) {
//            Playable card = new Card(i.toString(),"red");
//            cards.add(card);
//            cards.add(card);
//        }
//        for(Integer i=0 ; i<10 ; i++) {
//            Playable card = new Card (i.toString(),"blue");
//            cards.add(card);
//            cards.add(card);
//        }
//        for(Integer i=0 ; i<10 ; i++) {
//            Playable card = new Card (i.toString(),"yellow");
//            cards.add(card);
//            cards.add(card);
//        }
//        for(Integer i=0 ; i<10 ; i++) {
//            Playable card = new Card (i.toString(),"green");
//            cards.add(card);
//            cards.add(card);
//        }
//        for(int i=0 ; i<2 ; i++) {
//            Playable reversecard = new ReverseCard("red");
//            cards.add(reversecard);
//            Playable blockcard = new BlockCard("red");
//            cards.add(blockcard);
//        }
//        for(int i=0 ; i<2 ; i++) {
//            Playable reversecard = new ReverseCard("blue");
//            cards.add(reversecard);
//            Playable blockcard = new BlockCard("blue");
//            cards.add(blockcard);
//        }
//        for(int i=0 ; i<2 ; i++) {
//            Playable reversecard = new ReverseCard("yellow");
//            cards.add(reversecard);
//            Playable blockcard = new BlockCard("yellow");
//            cards.add(blockcard);
//        }
//        for(int i=0 ; i<2 ; i++) {
//            Playable reversecard = new ReverseCard("green");
//            cards.add(reversecard);
//            Playable blockcard = new BlockCard("green");
//            cards.add(blockcard);
//        }
//        for(int i=0 ; i<4 ; i++) {
//            Playable changecolorcard = new ChangeColorCard();
//            cards.add(changecolorcard);
//        }
//    }{
//        for(Integer i=0 ; i<10 ; i++) {
//            Playable card = new Card (i.toString(),"red");
//            cards.add(card);
//            cards.add(card);
//        }
//        for(Integer i=0 ; i<10 ; i++) {
//            Playable card = new Card (i.toString(),"blue");
//            cards.add(card);
//            cards.add(card);
//        }
//        for(Integer i=0 ; i<10 ; i++) {
//            Playable card = new Card (i.toString(),"yellow");
//            cards.add(card);
//            cards.add(card);
//        }
//        for(Integer i=0 ; i<10 ; i++) {
//            Playable card = new Card (i.toString(),"green");
//            cards.add(card);
//            cards.add(card);
//        }
//        for(int i=0 ; i<2 ; i++) {
//            Playable reversecard = new ReverseCard("red");
//            cards.add(reversecard);
//            Playable blockcard = new BlockCard("red");
//            cards.add(blockcard);
//        }
//        for(int i=0 ; i<2 ; i++) {
//            Playable reversecard = new ReverseCard("blue");
//            cards.add(reversecard);
//            Playable blockcard = new BlockCard("blue");
//            cards.add(blockcard);
//        }
//        for(int i=0 ; i<2 ; i++) {
//            Playable reversecard = new ReverseCard("yellow");
//            cards.add(reversecard);
//            Playable blockcard = new BlockCard("yellow");
//            cards.add(blockcard);
//        }
//        for(int i=0 ; i<2 ; i++) {
//            Playable reversecard = new ReverseCard("green");
//            cards.add(reversecard);
//            Playable blockcard = new BlockCard("green");
//            cards.add(blockcard);
//        }
//        for(int i=0 ; i<4 ; i++) {
//            Playable changecolorcard = new ChangeColorCard();
//            cards.add(changecolorcard);
//        }
//    }

    public GameRunner(String ... players) {
        // docelowo: modulo=players.length();
//        modulo = 4;     //na aktualne potrzeby
//        currentIndex = 0;
//        draw = false;
//        board = new Board(cards);
//        playerList = new ArrayList<>();
//        playerList.add(new RealPlayer(players[0], board));
//        playerList.add(new AutomaticPlayer("Bot1", board));
//        playerList.add(new AutomaticPlayer("Bot2", board));
//        playerList.add(new AutomaticPlayer("Bot3", board));
        game = new Game();


    }

//    private void startGame() throws NoMoreCardsInDeck {
//        for (Player player: game.getPlayerList()) {
//            player.draw(7);
//        }
//        game.currentPlayer = game.getPlayerList().get(0);
//    }
//
//    public boolean gameOver() {
//        for (Player player: game.getPlayerList()) {
//            if (player.didIWin()) return true;
//        }
//        return false;
//    }

    public static void main(String[] args) {
        boolean dumpFlag = false;
        System.out.print("Welcome to ASU game! Enter your name: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Hello " + name + "! Let's play!");
        GameRunner play = new GameRunner(name);
        System.out.println("The first top card is: ");
        System.out.println(play.game.getBoard().getTopCard());
        try {
            play.game.startGame();
        } catch (NoMoreCardsInDeck e) {
            System.out.println("Sorry... something went wrong :(");
            throw new RuntimeException(e);
        }
        while(!play.game.gameOver()) {
            try {
                if (play.game.currentPlayer.equals(play.game.getPlayerList().get(0))) {
                    System.out.println("Now it's your turn. ");
                    System.out.println("Which card would you like to play? ");
                    System.out.println(play.game.currentPlayer); // wypisuje karty w ręce
                    System.out.print("Enter number from above to chose a card or 0 to draw a card from the pile: ");
                    String choice;
                    int nuberOfTries = 0;
                    while (true) {
                        nuberOfTries++;
                        if (nuberOfTries == 10) {
                            System.out.println("Sorry to many tries. Next time try to make correct choice in less then 10 tries.");
                            return;
                        }
                        if (scanner.hasNext()) {
                            choice = scanner.next();
                            try {
                                int number = Integer.parseInt(choice);
                                if (number == 0) {
                                    play.game.currentPlayer.draw(1);
                                    break;
                                }
                                try {
                                    if (play.game.currentPlayer.playCard(number)) {
                                        if (play.game.getBoard().getTopCard().getSymbol().equals("block")) {
                                            dumpFlag = true;
                                        }
                                        if (play.game.getBoard().getTopCard().getSymbol().equals("changeColor")) {
                                            System.out.print("Chose a color: ");
                                            String newColor = scanner.next();
                                            play.game.getBoard().setTopColor(newColor);
                                        }
                                        break;
                                    }
                                    else {
                                        System.out.print("You can't play this card. Try again: ");
                                    }
                                } catch (IncorrectInput e) {
                                    System.out.print("Wrong number. There's not such card in your hand. Try again: ");
                                }
                            } catch(NumberFormatException e) {
                                System.out.print("That's not a number. Enter number from above to chose a card or 0 to draw a card from the pile: ");
                            }
                        }
                    }
                    System.out.println("You've finished your move. Now the top card is: ");
                    System.out.println(play.game.getBoard().getTopCard());
                } else {
                    System.out.println("Now it's " + play.game.currentPlayer.getName() + "'s turn...");
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        continue;
                    }
                    try {
                        if (play.game.currentPlayer.playCard(0)) {
                            if (play.game.getBoard().getTopCard().getSymbol().equals("block")) dumpFlag = true;
                            if (play.game.getBoard().getTopCard().getSymbol().equals("changeColor")) {
                                String[] colors = {"red", "green", "blue", "yellow"};
                                Random random = new Random();
                                int randomIndex = random.nextInt(colors.length);
                                String newColor = colors[randomIndex];
                                play.game.getBoard().setTopColor(newColor);
                            }
                        }
                    } catch (IncorrectInput e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(play.game.currentPlayer.getName() + " has finished his move. Now the top card is: ");
                    System.out.println(play.game.getBoard().getTopCard());
                }
                if (dumpFlag) {
                    play.game.currentIndex += play.game.getGameDirection();
                    dumpFlag = false;
                }
                play.game.currentIndex += play.game.getGameDirection();
                if (play.game.currentIndex < 0) play.game.currentIndex += play.game.getModulo();
                play.game.currentIndex = play.game.currentIndex % play.game.getModulo();
                play.game.currentPlayer = play.game.getPlayerList().get(play.game.currentIndex);
            } catch (NoMoreCardsInDeck n) {
                play.game.draw=true;
                break;
            }
        }
        if(play.game.draw) System.out.println("It is a draw! There is no winner.");
        else {
            for (Player player : play.game.getPlayerList()) {
                if (player.didIWin()) {
                    if(player == play.game.getPlayerList().get(0)) System.out.println("Congratulations! You're the winner!");
                    else System.out.println("Not this time :(  The winner is " + player.getName() + ".");
                    break;
                }
            }
        }
        scanner.close();
    }
}
