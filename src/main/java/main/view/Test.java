package main.view;

import javafx.application.Application;
import javafx.stage.Stage;

public class Test extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        Menu menu = new Menu();
        primaryStage.setScene(menu.getMenu());
        primaryStage.show();
    }
}
