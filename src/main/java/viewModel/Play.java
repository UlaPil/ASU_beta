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
    static {
        // inicjalizacja 64 kart
    }

    public Play(String ... players) {
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
            if (play.currentPlayer.equals(play.playerList.get(0))) {
                System.out.println("Now it's your turn. ");
                System.out.println("Which card would you like to play? ");
                System.out.println(play.currentPlayer); // wypisuje karty w ręce
                System.out.print("Enter number or \"draw\" to draw a card from the pile: ");
                String choice = scanner.nextLine();
                // TODO: wykonać ruch gracza (on chyba nie ma metody i trzeba to zrobić manualnie)
                System.out.println("You've finished your move. Now the top card is: ");
                System.out.println(play.board.getTopCard());
            } else {
                System.out.println("Now it's " + play.currentPlayer.getName() + "'s turn...");
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    continue;
                }
                // TODO: wykonać ruch bota (on chyba ma do tego metode)
                System.out.println(play.currentPlayer.getName() + " has finished his move. Now the top card is: ");
                System.out.println(play.board.getTopCard());
            }
            // TODO: ustawić current player na kolejnego z arraylisty playerów

            // TODO: UWAGA!!! ustalilismy że w play obsługujemy wyjatek ktory rzuva draw noMoreCards
            //  wiec trzeba ko obsłużyć kończąc whila i wypisujac remis
        }
        // TODO: wypisać kto wygrał

        scanner.close();
    }
}
