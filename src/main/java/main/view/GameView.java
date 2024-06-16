package main.view;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import main.model.Player;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class GameView implements AsuScene {
    static final double CARD_WIDTH = 80;
    private final Scene scene;
    private PlayerHandDisplay playerHandDisplay;
    private final StackPane root = new StackPane();
    private ImageView topCard;
    private main.model.Color topColor;
    private Pane cross;
    private final TopCardColor topCardColor = new TopCardColor();
    private ImageView home;
    public HashMap<Player,BotHandView> botHands = new HashMap<>();
    public EventFactory eventFactory;
    public Player mainPlayer;
    public List<Player> playerList;


    public GameView(CardDisplay card, EventFactory eventFactory, List<Player> playerList) {
        scene = new Scene(root, WIDTH, HEIGHT);
        this.eventFactory = eventFactory;
        this.mainPlayer = playerList.get(0);
        this.playerList = playerList;

        scene.getStylesheets().addAll(Objects.requireNonNull(
                this.getClass().getResource("/style.css")).toExternalForm());
        topCard = card.getImageView();
        topColor = card.getCard().getColor();
        topCard.setTranslateY(HEIGHT/30);
        Rectangle topCardColorRectangle = topCardColor.getRectangle();
        topCardColor.setColor(topColor);
        topCardColorRectangle.setTranslateX(-65);
        topCardColorRectangle.setTranslateY(0);
        root.getChildren().addAll(topCard, topCardColorRectangle);
        setBackground();
        addExit();
        addDrawPileButton();
        addPlayerHand();
        addBotsHands();
        addText();
        addHomeButton();
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

    private void addHomeButton() {
        home = new HomeButton().get();
        home.setTranslateY(-0.465* HEIGHT);
        home.setTranslateX(-0.48*WIDTH);
        root.getChildren().add(home);
    }
    private void addDrawPileButton() {
        ReversView card = new ReversView();
        ImageView button = card.getImageView();
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

    public main.model.Color showColorPicker() {
        ColorPick colorPick = new ColorPick();
        colorPick.showAndWait();
        return colorPick.getSelectedColor();
    }

    public void setTopCard(CardDisplay card) {
        root.getChildren().remove(topCard);
        topCard = card.getImageView();

        root.getChildren().addAll(topCard);
    }

    public void setTopColor(main.model.Color color) {
        topColor = color;
        topCardColor.setColor(topColor);
    }

    private void addPlayerHand() {
        playerHandDisplay = new PlayerHandDisplay(eventFactory, mainPlayer);
        root.getChildren().addAll(playerHandDisplay.getCardContainer());
    }

    public void addCardToPlayerHand(CardDisplay card) {
        playerHandDisplay.addCardToPlayerHand(card);
    }


    public void removeCardFromRobotHand(Player player) {
        botHands.get(player).removeCard();
    }

    public void addCardToRobotHand(Player player) {botHands.get(player).addCard();}

    public void removeCardFromPlayerHand(CardDisplay card) {
        playerHandDisplay.removeCardFromPlayerHand(card);
    }

    private void addBotsHands() {
        for(int i = 1 ; i < playerList.size() ; i++) {
            botHands.put(playerList.get(i), new BotHandView());
        }
        for(int i = 1 ; i < playerList.size() ; i++) {
            HBox botHand = botHands.get(playerList.get(i)).getCardContainer();
            botHand.setMaxWidth(botHand.getWidth());
            botHand.setMaxHeight(botHand.getHeight());
            botHand.setRotate(120 + 30*i);
            root.getChildren().add(botHand);

        }
        botHands.get(playerList.get(1)).getCardContainer().setTranslateX(-WIDTH/3);
        botHands.get(playerList.get(1)).getCardContainer().setTranslateY(-HEIGHT/4);
        botHands.get(playerList.get(3)).getCardContainer().setTranslateX(WIDTH/3);
        botHands.get(playerList.get(3)).getCardContainer().setTranslateY(-HEIGHT/4);
        botHands.get(playerList.get(2)).getCardContainer().setTranslateY(-HEIGHT/3);
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
    public void defineHome(EventHandler<MouseEvent> event) {
        home.setOnMouseClicked(event);
    }
    public void reset() {
        playerHandDisplay.getCardContainer().getChildren().clear();
        for(int i = 1 ; i < playerList.size() ; i++) {
            botHands.get(playerList.get(i)).getCardContainer().getChildren().clear();
        }
    }
}
