package main;

import javafx.application.Application;
import javafx.stage.*;
import main.view.AppInit;
import main.view.AppInit;

public class Play extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        AppInit appInit = new AppInit(stage);
        appInit.init();
    }
}
