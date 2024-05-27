package main.view;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.util.*;


public class Menu {
    private static final int WIDTH = 1280;
    private static final int HEIGHT = 720;
    private final StackPane root = new StackPane();
    private final VBox menuPanel = new VBox();
    private final List<Pair<String, Runnable>> menuElements = Arrays.asList(
            new Pair<String, Runnable>("Single Player", () -> {}),
            new Pair<String, Runnable>("Match History", () -> {})
    );

    private void addTitle() {
        MenuTitle title = new MenuTitle("ASU");
        title.setTranslateX(100);
        title.setTranslateY(100);
        root.getChildren().addAll(title);
    }
    private void addBg() {
        BackgroundImage bg = new BackgroundImage(new Image("/bg.jpg",WIDTH, HEIGHT,false,true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        root.setBackground(new Background(bg));
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
    public Scene getMenu() {
        addTitle();
        addBg();
        addMenuPanel();
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        return scene;

    }

}
