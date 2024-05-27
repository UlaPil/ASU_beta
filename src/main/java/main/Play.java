package main;

import javafx.application.Application;
import javafx.scene.*;
import javafx.stage.*;
import javafx.fxml.*;
import main.view.SceneController;

import java.io.IOException;
import java.util.Objects;


public class Play extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        SceneController sceneController = new SceneController(stage);
    }
}
