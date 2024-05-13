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
        // inicjalizacja 64 kart
    }

    public Play(String ... players) {
            // docelowo: modulo=players.length();
        modulo = 4;     //na aktualne potrzeby
        currentIndex = 0;
        draw = false;
        board = new Board(cards);
        playerList = new ArrayList<>();
        Player player1 = new RealPlayer(players[0], board);
        Player player2 = new AutomaticPlayer("Bot1", board);
        Player player3 = new AutomaticPlayer("Bot2", board);
        Player player4 = new AutomaticPlayer("Bot3", board);
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
                    else play.currentPlayer.playCard(choice);
                    System.out.println("You've finished your move. Now the top card is: ");
                    System.out.println(play.board.getTopCard());
                } else {
                    System.out.println("Now it's " + play.currentPlayer.getName() + "'s turn...");
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        continue;
                    }
                    play.currentPlayer.playCard(0);
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
                    if(player==play.playerList.get(0)) System.out.println("Congratulations! You're the winner!");
                    else System.out.println("Not this time :(  The winner is " + player.getName() + ".");
                    break;
                }
            }
        }
        scanner.close();
    }
}
