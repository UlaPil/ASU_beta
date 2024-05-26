package main;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Stage;
import main.viewModel.MenuTitle;

public class Menu extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        StackPane root  = new StackPane();
        Pane title = new MenuTitle("ASU");
        root.getChildren().add(title);
        Image image = new Image("file:./main/java/main/bg.jpg");
        ImageView imageview = new ImageView(image);
        root.getChildren().add(imageview);


        Scene scene = new Scene(root, 1680, 1680);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
