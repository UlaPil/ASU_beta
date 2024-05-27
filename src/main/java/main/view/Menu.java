package main.view;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.util.*;


public class Menu implements AsuScene {

    private final StackPane root = new StackPane();
    private final StackPane menuPanel = new StackPane();
    private final Scene scene = new Scene(root,WIDTH,HEIGHT);
    private void addTitle() {
        MenuTitle title = new MenuTitle("ASU");
        title.setTranslateX((double)WIDTH/18);
        title.setTranslateY((double)HEIGHT/5);
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
        MenuElement play = new MenuElement("PLAY", 50);
        play.setTranslateX((double)WIDTH/3 + 20);
        play.setTranslateY((double)HEIGHT/3 - 10);
        play.setBgColor(Color.GREEN);
        menuPanel.getChildren().addAll(play);

        MenuElement history = new MenuElement("HISTORY", 50);
        history.setTranslateX((double)3*WIDTH/4);
        history.setTranslateY((double)4*HEIGHT/5);
        history.setBgColor(Color.valueOf("#1891AA"));
        menuPanel.getChildren().addAll(history);
        root.getChildren().addAll(menuPanel);
    }
    private void addExit() {
        int H = 20;
        int W = 3;
        Pane cross = new Pane();
        Rectangle r1 = new Rectangle(0,0,W, H);
        Rectangle r2 = new Rectangle(0,0,W, H);
        r1.setArcHeight(5);
        r1.setArcWidth(5);
        r2.setArcHeight(5);
        r2.setArcWidth(5);
        r2.setFill(Color.WHITE);
        r1.setFill(Color.WHITE);
        r1.getTransforms().add(new Rotate(45, (double)W/2, (double)H/2));
        r2.getTransforms().add(new Rotate(135, (double)W/2, (double)H/2));
        cross.getChildren().addAll(r1, r2);
        cross.setTranslateX((double)0.98*WIDTH);
        cross.setTranslateY((double)HEIGHT * 0.02);


        //cross.setOnMouseClicked(( ));
        root.getChildren().addAll(cross);
    }
    public Scene getScene() {
        addTitle();
        addBg();
        addMenuPanel();
        addExit();
        scene.setFill(Color.TRANSPARENT);

        scene.getStylesheets().addAll(Objects.requireNonNull(this.getClass().getResource("/style.css")).toExternalForm());
        return scene;

    }

}
