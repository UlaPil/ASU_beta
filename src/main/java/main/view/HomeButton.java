package main.view;

import javafx.scene.Cursor;
import javafx.scene.image.ImageView;

public class HomeButton {
        private ImageView home;
    public HomeButton() {
        home = new ImageView("/home.png");
        home.setFitHeight(20);
        home.setFitWidth(20);
        home.setOnMouseEntered(mouseDragEvent -> home.setCursor(Cursor.HAND));
        home.setOnMouseExited(mouseDragEvent -> home.setCursor(Cursor.DEFAULT));
    }
    public ImageView get() {
        return home;
    }

}
