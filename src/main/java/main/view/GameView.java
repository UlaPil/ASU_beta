package main.view;

import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;
import main.model.Player;

import java.util.HashMap;
import java.util.Objects;

public class GameView implements AsuScene {
    private static final double CARD_WIDTH = 80;
    Scene scene;
    private final StackPane root = new StackPane();
    private HBox cardContainer;
    private ImageView topCard;
    private Pane cross;
    public HashMap<Player,BotHandView>
    public BotHandView bot1HandView;
    public BotHandView bot2HandView;
    public BotHandView bot3HandView;
    public EventFactory eventFactory;
    public Player mainPlayer;


    public GameView(CardDisplay card, EventFactory eventFactory, Player player) {
        scene = new Scene(root, WIDTH, HEIGHT);
        this.eventFactory = eventFactory;
        this.mainPlayer = player;
        scene.getStylesheets().addAll(Objects.requireNonNull(
                this.getClass().getResource("/style.css")).toExternalForm());
        topCard = card.getImageView();
        topCard.setTranslateY(HEIGHT/30);
        root.getChildren().addAll(topCard);
        setBackground();
        addExit();
        addDrawPileButton();
        addPlayerHand();
        addBotsHands();
        addText();
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
        ReversView card = new ReversView();
        ImageView button = card.getImageView();
        double width = button.getFitWidth();
        double height = button.getFitHeight();
        StackPane stackPane = new StackPane(button);
        root.getChildren().add(stackPane);
        stackPane.setTranslateX(WIDTH / 7);
        stackPane.setTranslateY(HEIGHT/30);
        stackPane.setMaxWidth(CARD_WIDTH);
        stackPane.setMaxHeight(height);
        stackPane.setOnMouseClicked(eventFactory.getDrawEvent(mainPlayer));
        stackPane.setOnMouseEntered(mouseDragEvent -> {
            stackPane.setCursor(Cursor.HAND);
            addHighlightEffect(stackPane, true);
        });
        stackPane.setOnMouseExited(mouseDragEvent -> {
            stackPane.setCursor(Cursor.DEFAULT);
            addHighlightEffect(stackPane, false);
        });
    }

    private void addHighlightEffect(StackPane cardView, boolean highlight) {
        if (highlight) {
            DropShadow dropShadow = new DropShadow();
            dropShadow.setRadius(20);
            dropShadow.setOffsetX(0);
            dropShadow.setOffsetY(0);
            dropShadow.setColor(Color.WHITE);
            cardView.setEffect(dropShadow);
        } else {
            cardView.setEffect(null);
        }
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
        cardContainer.setMaxWidth(6*WIDTH/10);
        cardContainer.setMaxHeight(135);
        cardContainer.setMinHeight(135);
        cardContainer.setTranslateY(4*HEIGHT/10);
        cardContainer.widthProperty().addListener((obs, oldVal, newVal) -> adjustCardSpacing());

    }

    public void addCardToPlayerHand(CardDisplay card) {
        ImageView cardView = card.getImageView();
        cardContainer.getChildren().add(cardView);
        cardView.setOnMouseClicked(eventFactory.getPlayEvent(card, mainPlayer));

        cardView.setOnMouseClicked(mouseEvent -> {
            removeCardFromPlayerHand(card);
            adjustCardSpacing();
        });
        cardView.setOnMouseEntered(mouseEvent -> {
            cardView.setCursor(Cursor.HAND);
            playBounceAnimation(cardView, -20);
        });
        cardView.setOnMouseExited(mouseEvent -> {
            cardView.setCursor(Cursor.DEFAULT);
            playBounceAnimation(cardView, 0);
        });
        adjustCardSpacing();
        sortCards();
    }

    private void playBounceAnimation(ImageView cardView, double toY) {
        TranslateTransition transition = new TranslateTransition(Duration.millis(200), cardView);
        transition.setToY(toY);
        transition.play();
    }
    public void removeCardFromRobotHand(Player player) {

    }
    public void removeCardFromPlayerHand(CardDisplay card) {
        cardContainer.getChildren().remove(card.getImageView());
        adjustCardSpacing();
    }

    private void adjustCardSpacing() {
        double containerWidth = cardContainer.getWidth() * 0.95;
        int numberOfCards = cardContainer.getChildren().size();
        if (numberOfCards == 0) return;

        double spacing = 15;
        double totalCardWidth = numberOfCards * CARD_WIDTH + (numberOfCards - 1) * spacing;
        if (totalCardWidth > containerWidth) {
            spacing = (containerWidth - numberOfCards * CARD_WIDTH) / (numberOfCards - 1);
        }
        cardContainer.setSpacing(spacing);
        double startX = (containerWidth - totalCardWidth + spacing) / 2;

        for (int i = 0; i < numberOfCards; i++) {
            ImageView card = (ImageView) cardContainer.getChildren().get(i);
            card.setLayoutX(startX + i * (CARD_WIDTH + spacing));
        }
    }

    public void sortCards() {
        // TODO
    }

    private void addBotsHands() {
        bot1HandView = new BotHandView();
        bot2HandView = new BotHandView();
        bot3HandView = new BotHandView();
        HBox bot1Hand = bot1HandView.getCardContainer();
        HBox bot2Hand = bot2HandView.getCardContainer();
        HBox bot3Hand = bot3HandView.getCardContainer();
        bot1Hand.setMaxWidth(bot1Hand.getWidth());
        bot1Hand.setMaxHeight(bot1Hand.getHeight());
        bot2Hand.setMaxWidth(bot2Hand.getWidth());
        bot2Hand.setMaxHeight(bot2Hand.getHeight());
        bot3Hand.setMaxWidth(bot3Hand.getWidth());
        bot3Hand.setMaxHeight(bot3Hand.getHeight());
        root.getChildren().addAll(bot1Hand, bot2Hand, bot3Hand);
        bot1Hand.setRotate(150);
        bot2Hand.setRotate(180);
        bot3Hand.setRotate(210);
        bot1Hand.setTranslateX(-WIDTH/3);
        bot1Hand.setTranslateY(-HEIGHT/4);
        bot3Hand.setTranslateX(WIDTH/3);
        bot3Hand.setTranslateY(-HEIGHT/4);
        bot2Hand.setTranslateY(-HEIGHT/3);
    }

    private void addText() {
        Text bot1 = new PlayerNameText("Bot 1").getText();
        Text bot2 = new PlayerNameText("Bot 2").getText();
        Text bot3 = new PlayerNameText("Bot 3").getText();
        Text player = new PlayerNameText("Player").getText();
        bot1.setRotate(-30);
        bot3.setRotate(30);
        bot1.setTranslateX(-2*WIDTH/5 + 40);
        bot1.setTranslateY(-HEIGHT/3 - 10);
        bot2.setTranslateY((-HEIGHT/2)*0.9);
        bot3.setTranslateX(2*WIDTH/5 - 40);
        bot3.setTranslateY(-HEIGHT/3 - 10);
        player.setTranslateY(7*HEIGHT/24 - 15);
        player.setTranslateX(-WIDTH/4);
        root.getChildren().addAll(bot1, bot2, bot3, player);

    }

    private void addExit() {
        ExitButtonView cross = new ExitButtonView();
        Pane crossButton = cross.getCross();
        crossButton.setMaxWidth(crossButton.getWidth());
        crossButton.setMaxHeight(crossButton.getHeight());
        crossButton.setTranslateX((WIDTH/2)*0.96);
        crossButton.setTranslateY((-HEIGHT/2)*0.96);
        this.cross = crossButton;
        root.getChildren().addAll(crossButton);
    }

    public void defineExit(EventHandler<MouseEvent> event) {
        cross.setOnMouseClicked(event);
        cross.setOnMouseEntered(mouseDragEvent -> cross.setCursor(Cursor.HAND));
        cross.setOnMouseExited(mouseDragEvent -> cross.setCursor(Cursor.DEFAULT));
    }
}
