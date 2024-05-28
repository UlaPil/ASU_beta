package main.view;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;

import java.util.Objects;

public class GameView implements AsuScene {
    private static final double CARD_WIDTH = 80;
    Scene scene;
    private final StackPane root = new StackPane();
    private HBox cardContainer;
    private ImageView topCard;
    private Pane cross;

    public GameView(CardDisplay card) {
        scene = new Scene(root, WIDTH, HEIGHT);
        scene.getStylesheets().addAll(Objects.requireNonNull(this.getClass().getResource("/style.css")).toExternalForm());
        topCard = card.getImageView();
        topCard.setTranslateY(- HEIGHT/8);
        topCard.setStyle("-fx-radius: 25;");
        root.getChildren().addAll(topCard);
        setBackground();
        addExit();
        addDrawPileButton();
        addPlayerHand();

    }

    @Override
    public Scene getScene() {
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
        button.setTranslateY(- HEIGHT/8);
        button.setFitWidth(CARD_WIDTH);
        button.setPreserveRatio(true);
        button.setOnMouseClicked(new DrawEvent());
        button.setOnMouseEntered(mouseDragEvent -> button.setCursor(Cursor.HAND));
        button.setOnMouseExited(mouseDragEvent -> button.setCursor(Cursor.DEFAULT));
    }

    public void setTopCard(CardDisplay card) {
        topCard = card.getImageView();
    }

    private void addPlayerHand() {
        cardContainer = new HBox();
        root.getChildren().addAll(cardContainer);
        cardContainer.setAlignment(Pos.CENTER);
        StackPane.setAlignment(cardContainer, Pos.CENTER);
        cardContainer.setId("hand");
        cardContainer.setMaxWidth(9*WIDTH/10);
        cardContainer.setMaxHeight(125);
        cardContainer.setMinHeight(125);
//        cardContainer.setOpacity(0.5);
        cardContainer.setTranslateY(4*HEIGHT/10);
        cardContainer.widthProperty().addListener((obs, oldVal, newVal) -> adjustCardSpacing());

    }

    public void addCardToPlayerHand(CardDisplay card) {
        ImageView cardView = card.getImageView();
        cardContainer.getChildren().add(cardView);
        cardView.setOnMouseClicked(new PlayEvent());
        cardView.setOnMouseEntered(mouseDragEvent -> cardView.setCursor(Cursor.HAND));
        cardView.setOnMouseExited(mouseDragEvent -> cardView.setCursor(Cursor.DEFAULT));
        adjustCardSpacing();
    }

    public void removeCardFromPlayerHand(CardDisplay card) {
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

    private void addExit() {
        int H = 20;
        int W = 3;
        Pane cross = new Pane();
        Rectangle r1 = new Rectangle(0,0,W, H);
        r1.setArcHeight(5);
        r1.setArcWidth(5);
        r1.setFill(Color.WHITE);
        r1.getTransforms().add(new Rotate(45, (double)W/2, (double)H/2));

        Rectangle r2 = new Rectangle(0,0,W, H);
        r2.setArcHeight(5);
        r2.setArcWidth(5);
        r2.setFill(Color.WHITE);
        r2.getTransforms().add(new Rotate(135, (double)W/2, (double)H/2));

        cross.getChildren().addAll(r1, r2);
        cross.setTranslateX(0.98*WIDTH);
        cross.setTranslateY(HEIGHT * 0.02);
        this.cross = cross;

        root.getChildren().addAll(cross);
    }
   public void defineExit(EventHandler<MouseEvent> event) {
        cross.setOnMouseClicked(event);
        cross.setOnMouseEntered(mouseDragEvent -> cross.setCursor(Cursor.HAND));
        cross.setOnMouseExited(mouseDragEvent -> cross.setCursor(Cursor.DEFAULT));
    }
}
