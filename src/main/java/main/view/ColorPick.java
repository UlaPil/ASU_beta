package main.view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Objects;

public class ColorPick extends Stage {
    private final GridPane gridPane = new GridPane();
    private final Scene scene;
    private main.model.Color selectedColor;

    public ColorPick() {
        Button redButton = createColorButton("red", "-fx-background-color: #E83428; -fx-font-weight: bold; -fx-text-fill: #E83428;", main.model.Color.red);
        Button blueButton = createColorButton("blue", "-fx-background-color: #007BC7; -fx-font-weight: bold; -fx-text-fill: #007BC7;", main.model.Color.blue);
        Button greenButton = createColorButton("green", "-fx-background-color: #23AC38; -fx-font-weight: bold; -fx-text-fill: #23AC38;", main.model.Color.green);
        Button yellowButton = createColorButton("yellow", "-fx-background-color: #FFF100; -fx-font-weight: bold; -fx-text-fill: #FFF100;", main.model.Color.yellow);

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

        scene = new Scene(gridPane, 300, 300);
        scene.getStylesheets().addAll(Objects.requireNonNull(this.getClass().getResource("/style.css")).toExternalForm());
        this.setScene(scene);
        this.initStyle(StageStyle.UNDECORATED);
        this.initStyle(StageStyle.TRANSPARENT);
        setBackground();
    }

    private void setBackground() {
        Rectangle rectangle = new Rectangle(300, 300);
        rectangle.setArcHeight(60.0);
        rectangle.setArcWidth(60.0);
        gridPane.setClip(rectangle);
        gridPane.setId("colorPicker");
        scene.setFill(Color.TRANSPARENT);
    }

    private Button createColorButton(String colorName, String style, main.model.Color color) {
        Button button = new Button(colorName);
        button.setStyle(style + " -fx-cursor: hand;");
        button.setOnAction(event -> {
            selectedColor = color;
            ((Stage) button.getScene().getWindow()).close();
        });
        return button;
    }

    public main.model.Color getSelectedColor() {
        return selectedColor;
    }
}
