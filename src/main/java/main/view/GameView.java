package main.view;

import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Objects;

public class GameView implements AsuScene {
    private static final double CARD_WIDTH = 80;
    Scene scene;
    private final StackPane root = new StackPane();
    private HBox cardContainer;

    public GameView() {
        scene = new Scene(root, WIDTH, HEIGHT);
        scene.getStylesheets().addAll(Objects.requireNonNull(this.getClass().getResource("/style.css")).toExternalForm());
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
        Rectangle rectangle = new Rectangle(WIDTH, HEIGHT);
        rectangle.setArcHeight(60.0);
        rectangle.setArcWidth(60.0);
        root.setClip(rectangle);
        root.setId("gameBg");
        scene.setFill(Color.TRANSPARENT);
    }

    private void addDrawPileButton() {
        Image card = new Image("/back-side.png");
        ImageView button = new ImageView();
        root.getChildren().addAll(button);
        button.setImage(card);
        button.setTranslateX(35*WIDTH/100);
        button.setTranslateY(- HEIGHT/5);
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
        cardContainer.setMaxHeight(125);
        cardContainer.setMinHeight(125);
        cardContainer.setTranslateY(3*HEIGHT/10);
        cardContainer.widthProperty().addListener((obs, oldVal, newVal) -> adjustCardSpacing());
    }

    public void addCardToPlayerHand(CardDisplay card) {
        cardContainer.getChildren().add(card.getImageView());
        adjustCardSpacing();
    }

    public void removeCardFromPlayerHans(CardDisplay card) {
        cardContainer.getChildren().remove(card);
    }

    private void adjustCardSpacing() {
        double containerWidth = cardContainer.getWidth();
        int numberOfCards = cardContainer.getChildren().size();
        if (numberOfCards == 0) return;

        double spacing = 20;
        double totalCardWidth = numberOfCards * CARD_WIDTH + (numberOfCards - 1) * spacing;
        if (totalCardWidth > containerWidth) {
            spacing = (containerWidth - CARD_WIDTH) / (numberOfCards - 1);
        }
        cardContainer.setSpacing(spacing);
        double startX = (containerWidth - totalCardWidth + spacing) / 2;

        for (int i = 0; i < numberOfCards; i++) {
            ImageView card = (ImageView) cardContainer.getChildren().get(i);
            card.setLayoutX(startX + i * (CARD_WIDTH + spacing));
        }
    }
}
