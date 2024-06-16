package main.view.Game;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.stage.StageStyle;


public class Winner {

    public void show(Integer i) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setHeight(300);
        window.setWidth(370);

        Label label = new Label();
        label.setStyle("-fx-font-family: 'Arial'; -fx-font-size: 16px;");

        ImageView imageView;
        if (i == 0) {
            label.setText("Congratulations! You are the winner");
            imageView = new ImageView("winner.png");
        } else {
            label.setText("I'm sorry, the winner is Bot " + i);
            imageView = new ImageView("loser.png");
        }
        imageView.setFitHeight(150);
        imageView.setPreserveRatio(true);

        Button closeButton = new Button("OK");
        closeButton.setStyle("-fx-font-family: 'Arial'; -fx-font-size: 14px;");
        closeButton.setOnAction(e -> window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, imageView, closeButton);
        layout.setAlignment(Pos.CENTER);

        StackPane root = new StackPane(layout);
        Rectangle rectangle = new Rectangle(370, 300);
        rectangle.setArcHeight(60.0);
        rectangle.setArcWidth(60.0);
        root.setClip(rectangle);

        Scene scene = new Scene(root, 370, 300);
        scene.setFill(Color.TRANSPARENT);
        window.initStyle(StageStyle.TRANSPARENT);
        window.setScene(scene);
        window.showAndWait();
    }
}