package main;

import javafx.application.Application;
import javafx.stage.*;
import main.view.SceneController;

public class Play extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        SceneController sceneController = new SceneController(stage);
        sceneController.init();
    }
}
