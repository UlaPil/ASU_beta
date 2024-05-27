package main.view;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Test extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        Menu menu = new Menu();
            primaryStage.setTitle("ASU");
        primaryStage.setScene(menu.getScene());
        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();

    }
}
