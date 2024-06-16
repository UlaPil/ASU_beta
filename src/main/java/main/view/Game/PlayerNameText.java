package main.view.Game;

import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class PlayerNameText {
    Text text;
    public PlayerNameText(String s) {
        text = new Text(s);
        text.setFont(Font.font( 28));
//        text.setStyle("-fx-font-weight : bold"); ---> Gdy jego tura
        text.setFill(Color.WHITE);
        text.setEffect(new DropShadow(5, Color.WHITE));
    }

    public Text getText() {
        return text;
    }
}
