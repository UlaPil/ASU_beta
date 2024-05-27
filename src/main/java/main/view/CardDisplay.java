package main.view;

import javafx.scene.Node;
import javafx.scene.image.ImageView;
import main.model.Card;
import main.model.Playable;

import java.io.InputStream;

public class CardDisplay {
    ImageView imageView;
    Playable card;
    public CardDisplay(Playable card) {
       StringBuilder builder = new StringBuilder("/");
       builder.append(card.getColor().toString().charAt(0)).append("_");
       String x;
       switch(card.getSymbol()) {
           case one -> x = "1";
           case two -> x = "2";
           case three -> x = "3";
           case four -> x = "4";
           case five -> x = "5";
           case six -> x = "6";
           case seven -> x = "7";
           case eight -> x = "8";
           case nine -> x = "9";
           default -> x = card.getSymbol().toString();
       }

       builder.append(x).append(".png");
       try {
           imageView = new ImageView(builder.toString());
       } catch(IllegalArgumentException e) {
           throw new RuntimeException(builder.toString() + "spowodowal wywalenie programu");
       }
       imageView.setFitWidth(80);
       imageView.setPreserveRatio(true);
    }
    public ImageView getImageView() {
        return imageView;
    }
    public Playable getCard() {
        return card;
    }
}
