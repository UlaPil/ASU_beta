package main.view;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.model.Board;
import main.model.Playable;

public class Test extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        GameView menu = new GameView();
            primaryStage.setTitle("ASU");
        primaryStage.setScene(menu.getScene());
        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();

        CardDisplay card1 = new CardDisplay("/b_8.png", new Playable() {
            @Override
            public boolean isPlayable(String color, String symbol) {
                return true;
            }

            @Override
            public String getColor() {
                return "2";
            }

            @Override
            public String getSymbol() {
                return "3";
            }

            @Override
            public void onPlay(Board board) {

            }
        });
        CardDisplay card2 =  new CardDisplay("/b_8.png", new Playable() {
            @Override
            public boolean isPlayable(String color, String symbol) {
                return true;
            }

            @Override
            public String getColor() {
                return "2";
            }

            @Override
            public String getSymbol() {
                return "3";
            }

            @Override
            public void onPlay(Board board) {

            }
        });
        menu.addCardToPlayerHand(card1);
        menu.addCardToPlayerHand(card2);
    }
}
