package main.view.Game;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class ReversView {

    private final ImageView imageView;

    public ReversView() {
        Image card = new Image("/back-side.png");
        imageView = new ImageView();
        imageView.setImage(card);
        double cardWidth = 80;
        imageView.setFitWidth(cardWidth);
        imageView.setPreserveRatio(true);
        double width = imageView.getFitWidth();
        double height = imageView.getFitWidth() * imageView.getImage().getHeight() / imageView.getImage().getWidth();
        Rectangle rectangle = new Rectangle(width, height);
        rectangle.setArcHeight(15.0);
        rectangle.setArcWidth(15.0);
        imageView.setClip(rectangle);
    }

    public ImageView getImageView() {
        return imageView;
    }

}
