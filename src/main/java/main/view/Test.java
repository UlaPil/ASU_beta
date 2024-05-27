package main.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Test extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        GameView menu = new GameView();
        primaryStage.setTitle("ASU");
        Pane root = new Pane();
        primaryStage.setScene(new Scene(root));

        ImageView imageView = new ImageView("/cards/b_0.png" );
        root.getChildren().addAll(imageView);
        primaryStage.show();

    }
}
