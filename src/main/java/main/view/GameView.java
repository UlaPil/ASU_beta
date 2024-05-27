package main.view;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

public class GameView {
    private static final int WIDTH = 1280;
    private static final int HEIGHT = 720;
    private final StackPane root = new StackPane();

    public Scene getGameView() {

        return new Scene(root, WIDTH, HEIGHT);
    }
}
