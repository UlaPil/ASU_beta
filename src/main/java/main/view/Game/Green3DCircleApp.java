package main.view.Game;

import javafx.animation.Transition;
import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Green3DCircleApp extends Application {

    private Circle circle;
    private RadialGradient gradient;

    @Override
    public void start(Stage primaryStage) {
        // Tworzenie koła
        circle = new Circle(50);
        gradient = create3DGradient(0.5);
        circle.setFill(gradient);

        // Ustawienie pozycji koła
        circle.setCenterX(150);
        circle.setCenterY(150);

        // Tworzenie tekstu i ustawienie go na środku koła
        Text text = new Text("ASU");
        text.setFont(new Font(35));
        text.setStyle("-fx-font-weight : bold");
        text.setFill(Color.WHITE);
        text.setEffect(new DropShadow(5, Color.WHITE));
        text.setX(circle.getCenterX() - text.getLayoutBounds().getWidth() / 2);
        text.setY(circle.getCenterY() + text.getLayoutBounds().getHeight() / 4);

        // Ustawienie efektu cienia, aby koło wyglądało bardziej 3D
        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(10);
        dropShadow.setOffsetX(5);
        dropShadow.setOffsetY(5);
        dropShadow.setColor(Color.rgb(0, 0, 0, 0.5));
        circle.setEffect(dropShadow);

        // Ustawienie zdarzenia na zmianę kursora po najechaniu myszką
        circle.setOnMouseEntered(event -> {
            circle.setCursor(Cursor.HAND);
            enhanceGradient();
        });
        circle.setOnMouseExited(event -> {
            circle.setCursor(Cursor.DEFAULT);
            resetGradient();
        });

        // Dodanie koła i tekstu do panelu
        Pane root = new Pane();
        root.getChildren().addAll(circle, text);

        // Tworzenie sceny i ustawienie jej na scenie
        Scene scene = new Scene(root, 300, 300);
        primaryStage.setTitle("Green 3D Circle Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Metoda tworząca gradient 3D dla koła z podanym promieniem
    private RadialGradient create3DGradient(double radius) {
        return new RadialGradient(
                0, 0.1,
                0.5, 0.5,
                radius,
                true,
                CycleMethod.NO_CYCLE,
                new Stop(0, Color.LIGHTGREEN),
                new Stop(1, Color.DARKGREEN)
        );
    }

    // Metoda zwiększająca intensywność gradientu
    private void enhanceGradient() {
        GradientTransition gradientTransition = new GradientTransition(Duration.millis(200), 0.5, 0.7);
        gradientTransition.play();
    }

    // Metoda przywracająca pierwotny gradient
    private void resetGradient() {
        GradientTransition gradientTransition = new GradientTransition(Duration.millis(200), 0.7, 0.5);
        gradientTransition.play();
    }

    // Klasa animująca przejście gradientu
    private class GradientTransition extends Transition {
        private final double startRadius;
        private final double endRadius;

        public GradientTransition(Duration duration, double startRadius, double endRadius) {
            setCycleDuration(duration);
            this.startRadius = startRadius;
            this.endRadius = endRadius;
        }

        @Override
        protected void interpolate(double frac) {
            double radius = startRadius + (endRadius - startRadius) * frac;
            gradient = create3DGradient(radius);
            circle.setFill(gradient);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
