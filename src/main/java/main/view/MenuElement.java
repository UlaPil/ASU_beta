package main.view;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
public class MenuElement extends Pane{
    private final Rectangle bg;

    public MenuElement(String name, int size) {

        Text text = new Text(name);
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

        getChildren().addAll(bg, text);
    }

    public double getBgWidth() { return bg.getWidth(); }
    public double getBgHeight() { return bg.getHeight(); }

    public void setBgColor(Color color) {bg.setFill(color);}

}