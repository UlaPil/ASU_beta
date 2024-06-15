package main.view;

import javafx.animation.TranslateTransition;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import main.model.Playable;
import main.model.Player;

import static main.view.AsuScene.HEIGHT;
import static main.view.AsuScene.WIDTH;
import static main.view.GameView.CARD_WIDTH;

import java.util.HashMap;


public class PlayerHandDisplay {
    private Player mainPlayer;
    private HBox cardContainer;
    private EventFactory eventFactory;
    private HashMap<ImageView, Playable> cardMap = new HashMap<>();
    public PlayerHandDisplay(EventFactory eventFactory, Player mainPlayer) {
        this.mainPlayer = mainPlayer;
        this.eventFactory = eventFactory;
        cardContainer = new HBox();
        cardContainer.setAlignment(Pos.CENTER);
        StackPane.setAlignment(cardContainer, Pos.CENTER);
        cardContainer.setId("hand");
        cardContainer.setMaxWidth(6*WIDTH/10);
        cardContainer.setMaxHeight(135);
        cardContainer.setMinHeight(135);
        cardContainer.setTranslateY(4*HEIGHT/10);
        cardContainer.widthProperty().addListener((obs, oldVal, newVal) -> adjustCardSpacing());
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
    private void playBounceAnimation(ImageView cardView, double toY) {
        TranslateTransition transition = new TranslateTransition(Duration.millis(200), cardView);
        transition.setToY(toY);
        transition.play();
    }
    public void addCardToPlayerHand(CardDisplay card) {
        ImageView cardView = card.getImageView();
        cardContainer.getChildren().add(cardView);
        cardView.setOnMouseClicked(eventFactory.getPlayEvent(mainPlayer,card));
        cardMap.put(cardView, card.getCard());
        cardView.setOnMouseEntered(mouseEvent -> {
            cardView.setCursor(Cursor.HAND);
            playBounceAnimation(cardView, -20);
        });
        cardView.setOnMouseExited(mouseEvent -> {
            cardView.setCursor(Cursor.DEFAULT);
            playBounceAnimation(cardView, 0);
        });
        adjustCardSpacing();
    }

    public HBox getCardContainer() {
        return cardContainer;
    }
    public void removeCardFromPlayerHand(CardDisplay card) {
        for(int i = 0 ; i < cardContainer.getChildren().size() ; i++) {
            if(cardContainer.getChildren().get(i) instanceof ImageView v) {
                if(cardMap.get(v).equals(card.getCard())) {
                    cardContainer.getChildren().remove(i);
                    break;
                }
            }
        }
        adjustCardSpacing();
    }
}
