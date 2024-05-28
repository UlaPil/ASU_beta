package main.view;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;

import java.util.*;


public class Menu implements AsuScene {
    public enum But {
        EXIT,
        PLAY,
        HISTORY
    }
    private final Map<But, Node> Buttons = new HashMap<>();
    private final StackPane root = new StackPane();

    private final StackPane menuPanel = new StackPane();
    private final Scene scene = new Scene(root,WIDTH,HEIGHT);
    public Menu() {
        addTitle();
        addBg();
        addMenuPanel();
        addExit();
        scene.setFill(Color.TRANSPARENT);
        scene.getStylesheets().addAll(Objects.requireNonNull(this.getClass().getResource("/style.css")).toExternalForm());
    }
    private void addTitle() {
        MenuTitle title = new MenuTitle("ASU");
        title.setTranslateX(WIDTH/18);
        title.setTranslateY(HEIGHT/5);
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
        play.setTranslateX(WIDTH/3 + 20);
        play.setTranslateY(HEIGHT/3 - 10);
        play.setBgColor(Color.GREEN);
        play.setOnMouseEntered(mouseDragEvent -> play.setCursor(Cursor.HAND));
        play.setOnMouseExited(mouseDragEvent -> play.setCursor(Cursor.DEFAULT));
        menuPanel.getChildren().addAll(play);
        Buttons.put(But.PLAY, play);

        MenuElement history = new MenuElement("HISTORY", 50);
        history.setTranslateX((double)3*WIDTH/4);
        history.setTranslateY((double)4*HEIGHT/5);
        history.setBgColor(Color.valueOf("#1891AA"));
        history.setOnMouseEntered(mouseDragEvent -> history.setCursor(Cursor.HAND));
        history.setOnMouseExited(mouseDragEvent -> history.setCursor(Cursor.DEFAULT));
        Buttons.put(But.HISTORY, history);
        menuPanel.getChildren().addAll(history);
        root.getChildren().addAll(menuPanel);
    }
    private void addExit() {
        int H = 20;
        int W = 3;
        Pane cross = new Pane();
        Rectangle r1 = new Rectangle(0,0,W, H);
        r1.setArcHeight(5);
        r1.setArcWidth(5);
        r1.setFill(Color.WHITE);
        r1.getTransforms().add(new Rotate(45, (double)W/2, (double)H/2));

        Rectangle r2 = new Rectangle(0,0,W, H);
        r2.setArcHeight(5);
        r2.setArcWidth(5);
        r2.setFill(Color.WHITE);
        r2.getTransforms().add(new Rotate(135, (double)W/2, (double)H/2));

        cross.getChildren().addAll(r1, r2);
        cross.setTranslateX(0.98*WIDTH);
        cross.setTranslateY(HEIGHT * 0.02);
        cross.setOnMouseEntered(mouseDragEvent -> cross.setCursor(Cursor.HAND));
        cross.setOnMouseExited(mouseDragEvent -> cross.setCursor(Cursor.DEFAULT));
        Buttons.put(But.EXIT, cross);
        root.getChildren().addAll(cross);
    }

    public Scene getScene() {
        return scene;
    }
    public void setEvent(But type, EventHandler<MouseEvent> eventHandler) {
        Buttons.get(type).setOnMouseClicked(eventHandler);
    }
}
