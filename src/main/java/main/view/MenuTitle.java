package main.view;

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
        text.setFont(Font.font("roboto", 80));
        text.setStyle("-fx-font-weight : bold");
        text.setFill(Color.ANTIQUEWHITE);
        text.setEffect(new DropShadow(50, Color.CRIMSON));
        getChildren().addAll(text);
    }
    public double getTitleWidth() {
        return text.getLayoutBounds().getWidth();
    }
    public double getTitleHeight() {
        return text.getLayoutBounds().getHeight();
    }
}
