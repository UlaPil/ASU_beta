package main.viewModel;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class DrawEvent implements EventHandler<MouseEvent> {


    @Override
    public void handle(MouseEvent mouseEvent) {
        System.out.println("Draw");
    }
}
