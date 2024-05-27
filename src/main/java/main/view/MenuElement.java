package main.view;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class MenuElement extends Pane{
    private Text text;

    public MenuElement(String name) {
        Polygon bg = new Polygon();
        bg.setStroke(Color.WHITE);

        text = new Text(name);
        text.setTranslateX(5);
        text.setTranslateY(20);
        text.setFont(Font.font("Verdana",25));
        text.setFill(Color.BLACK);
        getChildren().addAll(bg,text);
    }
    public void setAction(Runnable action) {
        setOnMouseClicked(e->action.run());
    }
}