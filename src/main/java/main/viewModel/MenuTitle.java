package main.viewModel;

import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class MenuTitle extends Pane {
    private Text text;
    public MenuTitle(String name) {
        StringBuilder s = new StringBuilder();
        for(char c : name.toCharArray()) {
            s.append(c).append(" ");
        }
        text = new Text(s.toString());
        text.setFont(Font.font("Verdana", 40));
        text.setStyle("-fx-font-weight : bold");
        text.setFill(Color.MAROON);
        text.setX(800);
        text.setY(50);
        text.setEffect(new DropShadow(50, Color.BLACK));
        getChildren().addAll(text);
    }
}
