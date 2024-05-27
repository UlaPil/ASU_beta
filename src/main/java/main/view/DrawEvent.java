package main.view;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class DrawEvent implements EventHandler<MouseEvent> {
    public DrawEvent() {

    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        System.out.println("Draw");
    }
}
