package main.view;

import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import static main.model.Color.*;

public class TopCardColor {
    private Rectangle rectangle;

    public TopCardColor() {
        rectangle = new Rectangle(30, 30);
        rectangle.setArcWidth(8);
        rectangle.setArcHeight(8);
        rectangle.setStroke(Color.WHITE);
        rectangle.setStrokeWidth(3);
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setColor(main.model.Color colorType) {
        if (colorType.equals(red)) {
            rectangle.setFill(Color.valueOf("#E83428"));
        } else if (colorType.equals(blue)) {
            rectangle.setFill(Color.valueOf("#007BC7"));
        } else if (colorType.equals(green)) {
            rectangle.setFill(Color.valueOf("#23AC38"));
        } else if (colorType.equals(yellow)) {
            rectangle.setFill(Color.valueOf("#FFF100"));
        }
    }
}
