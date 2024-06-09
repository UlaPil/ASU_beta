package main.model;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

import static main.model.Color.*;

public class TopColor extends Rectangle{
    private Rectangle rectangle;

    public TopColor(double width, double height) {
        rectangle = new Rectangle(width, height);
        rectangle.setArcWidth(20); // Zaokrąglone rogi
        rectangle.setArcHeight(20);
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setColor(Color colorType) {
        if (colorType.equals(red)) {
            rectangle.setFill(Color.RED);
        } else if (colorType.equals(blue)) {
            rectangle.setFill(Color.BLUE);
        } else if (colorType.equals(green)) {
            rectangle.setFill(Color.GREEN);
        } else if (colorType.equals(yellow)) {
            rectangle.setFill(Color.YELLOW);
        }
    }


}
