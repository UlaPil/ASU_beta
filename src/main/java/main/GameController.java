package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.Cursor;
import javafx.scene.image.ImageView;

public class GameController {

    @FXML
    public ImageView myImageView;

    @FXML
    public void ASU(ActionEvent e) {
        System.out.println("ASU");
    }

    @FXML
    public void Draw(MouseEvent actionEvent) {
        System.out.println("Draw");
    }

    @FXML
    public void MouseEnter(MouseEvent mouseEvent) {
        myImageView.setCursor(Cursor.HAND);
    }

    @FXML
    public void MouseExit(DragEvent dragEvent) {
        myImageView.setCursor(Cursor.DEFAULT);
    }
}
