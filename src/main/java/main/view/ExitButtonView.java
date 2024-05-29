package main.view;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;

public class ExitButtonView {

    private final Pane cross;

    public ExitButtonView() {
        int H = 20;
        int W = 3;
        cross = new Pane();
        Rectangle r1 = new Rectangle(0,0,W, H);
        r1.setArcHeight(5);
        r1.setArcWidth(5);
        r1.setFill(Color.WHITE);
        r1.getTransforms().add(new Rotate(45, (double)W/2, (double)H/2));

        Rectangle r2 = new Rectangle(0,0,W, H);
        r2.setArcHeight(5);
        r2.setArcWidth(5);
        r2.setFill(Color.WHITE);
        r2.getTransforms().add(new Rotate(135, (double)W/2, (double)H/2));

        cross.getChildren().addAll(r1, r2);
        cross.setMaxHeight(H);
        cross.setMaxWidth(W);
    }

    public Pane getCross() {
        return cross;
    }
}
