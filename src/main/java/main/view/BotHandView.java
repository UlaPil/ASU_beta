package main.view;

import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class BotHandView {
    private final HBox cardContainer;

    public BotHandView() {
        cardContainer = new HBox();
        cardContainer.setMaxHeight(130);
        cardContainer.setMaxWidth(250);
    }

    public void addCard() {
        ReversView card = new ReversView();
        cardContainer.getChildren().add(card.getImageView());
        adjustCardSpacing();
    }

    public void removeCard() {
        cardContainer.getChildren().remove(1);
        adjustCardSpacing();
    }

    public HBox getCardContainer() {
        return cardContainer;
    }

    private void adjustCardSpacing() {
        double containerWidth = cardContainer.getWidth() * 0.95;
        int numberOfCards = cardContainer.getChildren().size();
        if (numberOfCards == 0) return;
        double cardWidth = 80;
        double spacing = -60;
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
