package main.view;

import javafx.scene.Node;
import javafx.scene.image.ImageView;
import main.model.Card;
import main.model.Playable;
public class CardDisplay {
    ImageView imageView;
    Playable card;
    CardDisplay(String url, Playable card) {
        imageView = new ImageView(url);
        this.card = card;
    }
    public ImageView getImageView() {
        return imageView;
    }
    public Playable getCard() {
        return card;
    }
}
