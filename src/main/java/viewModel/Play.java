package viewModel;
import java.util.Scanner;

import core.*;

import java.util.ArrayList;
import java.util.List;

public class Play {
    private ArrayList<Player> playerList;
    public Board board;
    private static List<Playable> cards = new ArrayList<>();
    public Player currentPlayer;
    static {
        // inicjalizacja 64 kart
    }

    public Play(Player ... players) {
        board = new Board(cards);
        playerList = new ArrayList<>(List.of(players));
    }

    private void startGame() {
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
        System.out.println("Welcome to ASU game! Enter your name: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Hello " + name + "! Let's play!");
        Player player1 = new RealPlayer(name);
        Player player2 = new AutomaticPlayer();
        Player player3 = new AutomaticPlayer();
        Player player4 = new AutomaticPlayer();
        Play play = new Play(player1, player2, player3, player4);
        play.startGame();
        while(!play.gameOver()) {
            if (play.currentPlayer.equals(player1)) {
                System.out.println("Now it's your turn. ");
                System.out.println("Which card would you like to play? ");
                System.out.println(player1);
                
            }
            System.out.println("");
        }


        scanner.close();
    }
}
