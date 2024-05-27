package main.view;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

public class GameView implements AsuScene{
    private final StackPane root = new StackPane();

    @Override
    public Scene getScene() {
        setBackground();
        addDrawPile();
        addTopCard();
        addPlayerHand();
        return new Scene(root, WIDTH, HEIGHT);
    }

    private void setBackground() {

    }

    private void addDrawPile() {

    }

    private void addTopCard() {

    }

    private void addPlayerHand() {

    }
}
