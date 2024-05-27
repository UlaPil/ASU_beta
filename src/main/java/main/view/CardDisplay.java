package main.view;

import javafx.scene.Node;
import javafx.scene.image.ImageView;
import main.model.Card;
import main.model.Playable;
public class CardDisplay {
    ImageView imageView;
    Playable card;
    CardDisplay(Playable card) {
       card.getColor();
    }
    public ImageView getImageView() {
        return imageView;
    }
    public Playable getCard() {
        return card;
    }
}
