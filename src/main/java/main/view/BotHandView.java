package main.view;

import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

public class BotHandView {
    private final HBox cardContainer;

    public BotHandView() {
        cardContainer = new HBox();
        cardContainer.setMaxHeight(130);
        cardContainer.setMaxWidth(200);
    }

    public void addCard() {
        ReversView card = new ReversView();
        ImageView cardView = card.getImageView();
        cardView.setTranslateY(40); 
        cardContainer.getChildren().add(cardView);
        adjustCardSpacing();
        playBounceAnimation(cardView, 0, () -> {});
    }

    private void playBounceAnimation(Node cardView, double toY, Runnable onFinished) {
        TranslateTransition transition = new TranslateTransition(Duration.millis(300), cardView);
        transition.setToY(toY);
        transition.setOnFinished(event -> onFinished.run());
        transition.play();
    }

    public void removeCard() {
        if (cardContainer.getChildren().isEmpty()) {
            return;
        }
        Node cardView = cardContainer.getChildren().get(0);
        playBounceAnimation(cardView, -40, () -> {
            cardContainer.getChildren().remove(cardView);
            adjustCardSpacing();
        });
    }

    public HBox getCardContainer() {
        return cardContainer;
    }

    private void adjustCardSpacing() {
        double containerWidth = 200;
        int numberOfCards = cardContainer.getChildren().size();
        if (numberOfCards == 0) return;
        double cardWidth = 80;
        double spacing = -50;
        double totalCardWidth = numberOfCards * cardWidth + (numberOfCards - 1) * spacing;
        if (totalCardWidth > containerWidth) {
            spacing = (containerWidth - numberOfCards * cardWidth) / (numberOfCards - 1);
        }
        cardContainer.setSpacing(spacing);
        double startX = (containerWidth - totalCardWidth + spacing) / 2;

        for (int i = 0; i < numberOfCards; i++) {
            ImageView card = (ImageView) cardContainer.getChildren().get(i);
            card.setLayoutX(startX + i * (cardWidth + spacing));
        }
    }
}
