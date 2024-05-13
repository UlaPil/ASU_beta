package viewModel;
import java.util.Scanner;

import core.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Play {
    private ArrayList<Player> playerList;
    public Board board;
    private static List<Playable> cards = new ArrayList<>();
    public Player currentPlayer;
    private int modulo;
    private int currentIndex;
    private boolean draw;
    static {
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
        }
        for(int i=0 ; i<2 ; i++) {
            Playable reversecard = new ReverseCard("blue");
            cards.add(reversecard);
        }
        for(int i=0 ; i<2 ; i++) {
            Playable reversecard = new ReverseCard("yellow");
            cards.add(reversecard);
        }
        for(int i=0 ; i<2 ; i++) {
            Playable reversecard = new ReverseCard("green");
            cards.add(reversecard);
        }
    }

    public Play(String ... players) {
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

    public static void main(String[] args) {
        System.out.print("Welcome to ASU game! Enter your name: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Hello " + name + "! Let's play!");
        Play play = new Play(name);
        System.out.println("The first top card is: ");
        System.out.println(play.board.getTopCard());
        try {
            play.startGame();
        } catch (NoMoreCardsInDeck e) {
            System.out.println("Sorry... something went wrong :(");
            throw new RuntimeException(e);
        }
        while(!play.gameOver()) {
            try {
                if (play.currentPlayer.equals(play.playerList.get(0))) {
                    System.out.println("Now it's your turn. ");
                    System.out.println("Which card would you like to play? ");
                    System.out.println(play.currentPlayer); // wypisuje karty w ręce
                    System.out.print("Enter number from above to chose a card or 0 to draw a card from the pile: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("That's not a number. Enter number from above to chose a card or 0 to draw a card from the pile: ");
                    }
                    int choice = scanner.nextInt();
                    if (choice == 0) play.currentPlayer.draw(1);
                    else {
                        int nuberOfTries = 0;
                        while (true) {
                            nuberOfTries++;
                            if (nuberOfTries == 10) {
                                System.out.println("Sorry to many tries. Next time try to make correct choice in less then 10 tries.");
                                return;
                            }
                            try {
                                if (play.currentPlayer.playCard(choice)) break;
                                else {
                                    System.out.println("You can't play this card. Try again: ");
                                    choice = scanner.nextInt();
                                }
                            } catch (IncorrectInput e) {
                                System.out.println("Wrong number. There's not such card in your hand. Try again: ");
                                choice = scanner.nextInt();
                            }
                        }
                    }
                    System.out.println("You've finished your move. Now the top card is: ");
                    System.out.println(play.board.getTopCard());
                } else {
                    System.out.println("Now it's " + play.currentPlayer.getName() + "'s turn...");
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        continue;
                    }
                    try {
                        play.currentPlayer.playCard(0);
                    } catch (IncorrectInput e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(play.currentPlayer.getName() + " has finished his move. Now the top card is: ");
                    System.out.println(play.board.getTopCard());
                }
                play.currentIndex += play.board.getGameDirection();
                if (play.currentIndex < 0) play.currentIndex += play.modulo;
                play.currentIndex = play.currentIndex % play.modulo;
                play.currentPlayer = play.playerList.get(play.currentIndex);
            } catch (NoMoreCardsInDeck n) {
                play.draw=true;
                break;
            }
        }
        if(play.draw) System.out.println("It is a draw! There is no winner.");
        else {
            for (Player player : play.playerList) {
                if (player.didIWin()) {
                    if(player == play.playerList.get(0)) System.out.println("Congratulations! You're the winner!");
                    else System.out.println("Not this time :(  The winner is " + player.getName() + ".");
                    break;
                }
            }
        }
        scanner.close();
    }
}
