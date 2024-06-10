package main.view;
import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class Winner {

    public static void show(Integer i) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Game Result");
        alert.getDialogPane().setStyle("-fx-font-family: 'Arial';");
        alert.setHeaderText(null);

        if (i == 0) {
            alert.setContentText("Congratulations! You are the winner");
        } else {
            alert.setContentText("I'm sorry, the winner is Bot " + i.toString());
        }

        alert.showAndWait();
    }

//    public static class DummyApp extends Application {
//        @Override
//        public void start(Stage primaryStage) {
//            Winner.show(1);
//            primaryStage.close();
//        }
//    }

}