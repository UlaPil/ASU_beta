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
        play.setMaxWidth(play.getBgWidth());
        play.setMaxHeight(play.getBgHeight());
        play.setTranslateX(-WIDTH/12);
        play.setTranslateY(-HEIGHT/8);
        play.setBgColor(Color.valueOf("#23AC38"));
        play.setOnMouseEntered(mouseDragEvent -> play.setCursor(Cursor.HAND));
        play.setOnMouseExited(mouseDragEvent -> play.setCursor(Cursor.DEFAULT));
        menuPanel.getChildren().addAll(play);
        Buttons.put(But.PLAY, play);

        MenuElement history = new MenuElement("HISTORY", 50);
        history.setMaxWidth(play.getBgWidth());
        history.setMaxHeight(play.getBgHeight());
        history.setTranslateX(WIDTH/3 + 10);
        history.setTranslateY(5*HEIGHT/12 - 5);
        history.setBgColor(Color.valueOf("#1891AA"));
        history.setOnMouseEntered(mouseDragEvent -> history.setCursor(Cursor.HAND));
        history.setOnMouseExited(mouseDragEvent -> history.setCursor(Cursor.DEFAULT));
        Buttons.put(But.HISTORY, history);
        menuPanel.getChildren().addAll(history);
        root.getChildren().addAll(menuPanel);
    }
    private void addExit() {
        ExitButtonView cross = new ExitButtonView();
        Pane crossButton = cross.getCross();
        crossButton.setMaxWidth(crossButton.getWidth());
        crossButton.setMaxHeight(crossButton.getHeight());
        crossButton.setTranslateX((WIDTH/2)*0.96);
        crossButton.setTranslateY((-HEIGHT/2)*0.96);
        crossButton.setOnMouseEntered(mouseDragEvent -> crossButton.setCursor(Cursor.HAND));
        crossButton.setOnMouseExited(mouseDragEvent -> crossButton.setCursor(Cursor.DEFAULT));
        Buttons.put(But.EXIT, crossButton);
        root.getChildren().addAll(crossButton);
    }

    public Scene getScene() {
        return scene;
    }
    public void setEvent(But type, EventHandler<MouseEvent> eventHandler) {
        Buttons.get(type).setOnMouseClicked(eventHandler);
    }
}
