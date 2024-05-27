package main.view;

import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import main.viewModel.DrawEvent;

import java.util.ArrayList;

public class GameView implements AsuScene {
    private static final double CARD_WIDTH = 80;
    Scene scene;
    private final StackPane root = new StackPane();
    private HBox cardContainer;

    public GameView() {
        scene = new Scene(root, WIDTH, HEIGHT);
        Rectangle rectangle = new Rectangle(WIDTH, HEIGHT);
        rectangle.setArcHeight(60.0);
        rectangle.setArcWidth(60.0);
        root.setClip(rectangle);
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
        button.setTranslateX(WIDTH/4);
        button.setTranslateY(- HEIGHT/6);
        button.setFitWidth(CARD_WIDTH);
        button.setPreserveRatio(true);
        button.setOnMouseClicked(new DrawEvent());
        button.setOnMouseEntered(mouseDragEvent -> button.setCursor(Cursor.HAND));
        button.setOnMouseExited(mouseDragEvent -> button.setCursor(Cursor.DEFAULT));
    }

    private void setTopCard() {

    }

    private void addPlayerHand() {
        cardContainer = new HBox();
        root.getChildren().addAll(cardContainer);
        cardContainer.setAlignment(Pos.CENTER);
        StackPane.setAlignment(cardContainer, Pos.CENTER);
        cardContainer.setMaxWidth(9*WIDTH/10);
        cardContainer.setMaxHeight(HEIGHT/4);
        cardContainer.setMinHeight(HEIGHT/4);
        cardContainer.setTranslateY(3*HEIGHT/10);
        cardContainer.setStyle("-fx-background-color: green;");
        cardContainer.widthProperty().addListener((obs, oldVal, newVal) -> adjustCardSpacing());
    }

    public void addCardToPlayerHand(CardDisplay card) {
        cardContainer.getChildren().add(card.getImageView());
        adjustCardSpacing();
    }

    private void adjustCardSpacing() {
        double containerWidth = cardContainer.getWidth();
        int numberOfCards = cardContainer.getChildren().size();
        if (numberOfCards == 0) return;
        double totalCardWidth = numberOfCards * CARD_WIDTH;
        double spacing = 0;
        if (totalCardWidth > containerWidth) {
            spacing = (containerWidth - CARD_WIDTH) / (numberOfCards - 1);
        } else {
            spacing = (containerWidth - totalCardWidth) / (numberOfCards - 1);
        }
        cardContainer.setSpacing(spacing);
    }
}
