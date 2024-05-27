//package main.view;
//
//import javafx.application.Application;
//import javafx.scene.Scene;
//import javafx.scene.image.ImageView;
//import javafx.scene.layout.Pane;
//import javafx.stage.Stage;
//import javafx.stage.StageStyle;
//import main.model.Board;
//import main.model.Color;
//import main.model.Playable;
//import main.model.Symbol;
//
//public class Test extends Application {
//    public static void main(String[] args) {
//        launch(args);
//    }
//    @Override
//    public void start(Stage primaryStage) throws Exception {
//        GameView menu = new GameView();
//        primaryStage.setTitle("ASU");
//        Pane root = new Pane();
//        primaryStage.setScene(new Scene(root));
//
//        ImageView imageView = new ImageView("/cards/b_0.png" );
//        root.getChildren().addAll(imageView);
//        primaryStage.show();
//
//        CardDisplay card1 = new CardDisplay("/b_8.png", new Playable() {
//            @Override
//            public boolean isPlayable(String color, String symbol) {
//                return true;
//            }
//
//            @Override
//            public String getColor() {
//                return "2";
//            }
//
//            @Override
//            public String getSymbol() {
//                return "3";
//            }
//
//            @Override
//            public void onPlay(Board board) {
//
//            }
//        });
//        CardDisplay card2 =  new CardDisplay("/b_8.png", new Playable() {
//            @Override
//            public boolean isPlayable(Color color, Symbol symbol) {
//                return true;
//            }
//
//            @Override
//            public Color getColor() {
//                return "2";
//            }
//
//            @Override
//            public String getSymbol() {
//                return "3";
//            }
//
//            @Override
//            public void onPlay(Board board) {
//
//            }
//        });
//        menu.addCardToPlayerHand(card1);
//        menu.addCardToPlayerHand(card2);
//    }
//}
