package main;

import java.util.Random;
import java.util.Scanner;

import main.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static main.model.Color.*;
import static main.model.Symbol.*;

public class GameRunner {
    private Game game;

    public GameRunner(String ... players) {
        game = new Game();


    }
    public static void main(String[] args) {
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
                                    if(play.game.playCard(game.getPlayerList().get(game.currentIndex), game.);
                                    break;
                                }
                                try {
                                    if (play.game.currentPlayer.playCard(number)) {
                                        if (play.game.getBoard().getTopCard().getSymbol().equals(changeColor)) {
                                            System.out.print("Chose a color: ");
                                            String newColor = scanner.next();
                                            if(newColor == yellow.toString()) {
                                                play.game.getBoard().setTopColor(yellow);
                                            }
                                            if(newColor == blue.toString()) {
                                                play.game.getBoard().setTopColor(blue);
                                            }
                                            if(newColor == red.toString()) {
                                                play.game.getBoard().setTopColor(red);
                                            }
                                            if()
                                            play.game.getBoard().setTopColor(blue);
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
                            if (play.game.getBoard().getTopCard().getSymbol().equals(changeColor)) {
                                Color[] colors = {red, green, blue, yellow};
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
