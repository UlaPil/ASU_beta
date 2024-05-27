package main.view;

import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import main.viewModel.DrawEvent;

public class GameView implements AsuScene {
    Scene scene;
    private final Pane root = new Pane();

    public GameView() {
        scene = new Scene(root, WIDTH, HEIGHT);
    }

    @Override
    public Scene getScene() {
        setBackground();
        addDrawPileButton();
        setTopCard();
        addPlayerHand();
        return scene;
    }

    private void setBackground() {

    }

    private void addDrawPileButton() {
        Image card = new Image("/back-side.png");
        ImageView button = new ImageView();
        root.getChildren().addAll(button);
        button.setImage(card);
        button.setLayoutX(2*WIDTH/3);
        button.setLayoutY(HEIGHT/3);
        button.setFitHeight(100);
        button.setPreserveRatio(true);
        button.setOnMouseClicked(new DrawEvent());
        button.setOnMouseEntered(mouseDragEvent -> button.setCursor(Cursor.HAND));
        button.setOnMouseExited(mouseDragEvent -> button.setCursor(Cursor.DEFAULT));
    }

    private void setTopCard() {

    }

    private void addPlayerHand() {

    }
}
