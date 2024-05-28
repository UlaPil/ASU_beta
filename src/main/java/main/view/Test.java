package main.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.model.*;

public class Test extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        CardDisplay card2 = new CardDisplay(new Card(Symbol.five, Color.red));
        GameView menu = new GameView(card2);
        primaryStage.setTitle("ASU");
        Pane root = new Pane();
        primaryStage.setScene(menu.getScene());

//        ImageView imageView = new ImageView("/cards/b_0.png" );
//        root.getChildren().addAll(imageView);
        primaryStage.show();

        CardDisplay card1 = new CardDisplay(new Card(Symbol.five, Color.red));
        CardDisplay card3 = new CardDisplay(new Card(Symbol.three, Color.blue));
        CardDisplay card4 = new CardDisplay(new Card(Symbol.two, Color.yellow));
        CardDisplay card5 = new CardDisplay(new Card(Symbol.eight, Color.red));
        CardDisplay card6 = new CardDisplay(new Card(Symbol.five, Color.blue));
        CardDisplay card7 = new CardDisplay(new Card(Symbol.nine, Color.red));

        menu.addCardToPlayerHand(card1);
        menu.addCardToPlayerHand(card3);
        menu.addCardToPlayerHand(card4);
        menu.addCardToPlayerHand(card5);
        menu.addCardToPlayerHand(card6);
        menu.addCardToPlayerHand(card7);
    }
}
