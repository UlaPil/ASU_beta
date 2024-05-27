package main.view;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.util.*;


public class Menu implements AsuScene {
    private final StackPane root = new StackPane();
    private final StackPane menuPanel = new StackPane();
    private final List<Pair<String, Runnable>> menuElements = Arrays.asList(
            new Pair<String, Runnable>("Single Player", () -> {}),
            new Pair<String, Runnable>("Match History", () -> {})
    );

    private void addTitle() {
        MenuTitle title = new MenuTitle("ASU");
        title.setTranslateX(WIDTH/20);
        title.setTranslateY(120);
        root.getChildren().addAll(title);
    }
    private void addBg() {
        root.setId("bg");
        Rectangle rectangle = new Rectangle(WIDTH, HEIGHT);
        rectangle.setArcHeight(60.0);
        rectangle.setArcWidth(60.0);
        root.setClip(rectangle);
    }
    private void addMenuPanel() {
        for(Pair<String, Runnable> x : menuElements) {
            MenuElement a = new MenuElement(x.getKey());
            a.setAction(x.getValue());
            menuPanel.getChildren().addAll(a);
        }
        menuPanel.setTranslateX((double)WIDTH/2);
        menuPanel.setTranslateY((double)HEIGHT/2);
        root.getChildren().addAll(menuPanel);
    }
    public Scene getScene() {
        addTitle();
        addBg();
        addMenuPanel();

        Scene scene = new Scene(root, WIDTH, HEIGHT);
        scene.setFill(Color.TRANSPARENT);
        scene.getStylesheets().addAll(this.getClass().getResource("/style.css").toExternalForm());
        return scene;

    }

}
