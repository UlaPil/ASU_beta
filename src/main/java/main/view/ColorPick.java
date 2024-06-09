package main.view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Objects;

public class ColorPick extends Application {
    //StackPane root = new StackPane();
    GridPane gridPane = new GridPane();
    Scene scene;
    @Override
    public void start(Stage primaryStage) {
        Button redButton = createColorButton("Red", "-fx-background-color: red; -fx-font-weight: bold; -fx-text-fill: red;");
        Button blueButton = createColorButton("Blue", "-fx-background-color: blue; -fx-font-weight: bold; -fx-text-fill: blue;");
        Button greenButton = createColorButton("Green", "-fx-background-color: green; -fx-font-weight: bold; -fx-text-fill: green;");
        Button yellowButton = createColorButton("Yellow", "-fx-background-color: yellow; -fx-font-weight: bold; -fx-text-fill: yellow;");

        //gridPane = new GridPane();
        int buttonSize = 150;
        redButton.setPrefSize(buttonSize, buttonSize);
        blueButton.setPrefSize(buttonSize, buttonSize);
        greenButton.setPrefSize(buttonSize, buttonSize);
        yellowButton.setPrefSize(buttonSize, buttonSize);
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        gridPane.add(redButton, 0, 0);
        gridPane.add(blueButton, 1, 0);
        gridPane.add(greenButton, 0, 1);
        gridPane.add(yellowButton, 1, 1);

        Rectangle roundedRect = new Rectangle(300, 300);
        roundedRect.setArcWidth(20);
        roundedRect.setArcHeight(20);

        //root.getChildren().add(gridPane);
        scene = new Scene(gridPane, 300, 300);
        scene.getStylesheets().addAll(Objects.requireNonNull(this.getClass().getResource("/style.css")).toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        setBackground();
        primaryStage.show();
    }

    private void setBackground() {
        Rectangle rectangle = new Rectangle(300, 300);
        rectangle.setArcHeight(60.0);
        rectangle.setArcWidth(60.0);
        gridPane.setClip(rectangle);
        gridPane.setId("colorPicker");
        scene.setFill(Color.TRANSPARENT);
    }

    private Button createColorButton(String colorName, String style) {
        Button button = new Button(colorName);
        button.setStyle(style + " -fx-cursor: hand;");
        button.setOnAction(event -> {
            System.out.println(colorName);
            ((Stage) button.getScene().getWindow()).close();
        });
        return button;
    }

    public static void main(String[] args) {
        launch(args);
    }
}