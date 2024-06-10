package main.view;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Winner {

    public static void show(int i) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Game Result");
        alert.setHeaderText(null);

        if (i == 0) {
            alert.setContentText("Congratulations! You are the winner");
        } else {
            alert.setContentText("I'm sorry, the winner is Bot" + i);
        }

        alert.showAndWait();
    }
}