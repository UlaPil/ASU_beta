package main.view;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
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
    private Rectangle bg;

    public MenuElement(String name, int size) {

        text = new Text(name);
        text.setFont(Font.font(size));
        text.setFill(Color.WHITE);
        text.setStyle("-fx-font-weight : bold");
        text.setTranslateY(text.getLayoutBounds().getHeight() - 10);
        text.setTranslateX(20);
        text.setEffect(new DropShadow(20, Color.ANTIQUEWHITE));
        bg = new Rectangle(0,0 , text.getLayoutBounds().getWidth() + 50, text.getLayoutBounds().getHeight() + 10);
        bg.setArcHeight(50.0);
        bg.setArcWidth(50.0);
        bg.setStroke(Color.TRANSPARENT);

        getChildren().addAll(bg,text);
    }
    public void setAction(Runnable action) {
        setOnMouseClicked(e->action.run());
    }
    public void setBgColor(Color color) {bg.setFill(color);}

}