package main.view;

import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import main.model.Color;
import main.model.Playable;

public class CardDisplay {
    ImageView imageView;
    Playable card;
    public CardDisplay(Playable card) {
       StringBuilder builder = new StringBuilder("/");
       builder.append(card.getColor().toString().charAt(0)).append("_");
       String x;
       switch(card.getSymbol()) {
           case zero -> x = "0";
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
           throw new RuntimeException(builder.toString() + " spowodowal wywalenie programu");
       }
       imageView.setFitWidth(80);
       imageView.setPreserveRatio(true);
       double width = imageView.getFitWidth();
       double height = imageView.getFitWidth() * imageView.getImage().getHeight() / imageView.getImage().getWidth();
       Rectangle rectangle = new Rectangle(width, height);
       rectangle.setArcHeight(15.0);
       rectangle.setArcWidth(15.0);
       imageView.setClip(rectangle);
       this.card = card;
    }
    public ImageView getImageView() {
        return imageView;
    }
    public Playable getCard() {
        return card;
    }
}
