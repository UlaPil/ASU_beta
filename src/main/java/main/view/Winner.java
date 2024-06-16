package main.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.stage.StageStyle;

public class Winner {

    public void show(Integer i) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.initStyle(StageStyle.UNDECORATED);
        window.setHeight(300);
        window.setWidth(370);
        Label label = new Label();
        label.setStyle("-fx-font-family: 'Arial'; -fx-font-size: 16px;");
        ImageView imageView;
        if (i == 0) {
            label.setText("Congratulations! You are the winner");
            imageView = new ImageView("winner.png");
        } else {
            label.setText("I'm sorry, the winner is Bot " + i.toString());
            imageView = new ImageView("loser.jpg");
        }
        imageView.setFitHeight(150);
        imageView.setPreserveRatio(true);
        Button closeButton = new Button("OK");
        closeButton.setStyle("-fx-font-family: 'Arial'; -fx-font-size: 14px;");
        closeButton.setOnAction(e -> window.close());
        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, imageView, closeButton);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle(
                "-fx-background-color: white; " +
                "-fx-background-radius: 20px; " +
                "-fx-padding: 20px;"
        );
        Scene scene = new Scene(layout, 300, 370);
        window.setScene(scene);
        window.showAndWait();
    }



//    public static class DummyApp extends Application {
//        @Override
//        public void start(Stage primaryStage) {
//            Winner.show(0);
//            primaryStage.close();
//        }
//    }

}