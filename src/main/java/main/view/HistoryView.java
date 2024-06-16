package main.view;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Pair;
import main.model.History;
import main.viewModel.HistorySerializer;

import java.util.Objects;

public class HistoryView implements AsuScene {
    private final StackPane root = new StackPane();
    private final ScrollPane scrollPane = new ScrollPane();
    private final VBox content;
    private History history;
    private Pane cross;
    private final ImageView home = new HomeButton().get();
    private final Scene scene;

    public HistoryView() {
        scene = new Scene(root, WIDTH, HEIGHT);
        scene.getStylesheets().addAll(Objects.requireNonNull(
                this.getClass().getResource("/style.css")).toExternalForm());
        content = new VBox();
        setBg();
        addContent();
        addHome();
        addExit();
    }

    private void addContent() {
        scrollPane.setContent(content);
        scrollPane.setMaxWidth(WIDTH * 4/ 5);
        scrollPane.setMaxHeight(HEIGHT * 4/ 5);
        scrollPane.setId("scroll-pane");
        content.setId("content");

        history = HistorySerializer.getHistory();
        for (Pair<String, Boolean> data : history.getHistory()) {
            MenuElement element = new MenuElement(data.getKey() + "                    " + (data.getValue() ? "VICTORY" : "DEFEAT"), 30);
            element.setBgColor(data.getValue() ? Color.LIMEGREEN : Color.DARKRED);
            element.setBgWidth(4 * WIDTH / 5 - 20);
            element.setBgHeight(HEIGHT / 9);
            content.getChildren().add(element);
        }

        root.getChildren().add(scrollPane);
        StackPane.setAlignment(scrollPane, Pos.CENTER);
    }

    private void setBg() {
//        root.setId("bg");
        root.setStyle("-fx-background-color: #34353B;");
        Rectangle rectangle = new Rectangle(WIDTH, HEIGHT);
        rectangle.setArcHeight(60.0);
        rectangle.setArcWidth(60.0);
        root.setClip(rectangle);
        scene.setFill(Color.TRANSPARENT);
    }

    private void addHome() {
        home.setTranslateY(-0.465 * HEIGHT);
        home.setTranslateX(-0.48 * WIDTH);
        root.getChildren().add(home);
    }

    private void addExit() {
        ExitButtonView cross = new ExitButtonView();
        Pane crossButton = cross.getCross();
        crossButton.setMaxWidth(crossButton.getWidth());
        crossButton.setMaxHeight(crossButton.getHeight());
        crossButton.setTranslateX((WIDTH / 2) * 0.96);
        crossButton.setTranslateY((-HEIGHT / 2) * 0.96);
        this.cross = crossButton;
        root.getChildren().addAll(crossButton);
    }

    public void defineHome(EventHandler<MouseEvent> event) {
        home.setOnMouseClicked(event);
    }

    public void defineExit(EventHandler<MouseEvent> event) {
        cross.setOnMouseClicked(event);
        cross.setOnMouseEntered(mouseDragEvent -> cross.setCursor(Cursor.HAND));
        cross.setOnMouseExited(mouseDragEvent -> cross.setCursor(Cursor.DEFAULT));
    }

    @Override
    public Scene getScene() {
        return scene;
    }

    public void update() {
        content.getChildren().clear();
        history = HistorySerializer.getHistory();
        for (Pair<String, Boolean> data : history.getHistory()) {
            MenuElement element = new MenuElement(data.getKey() + "                    " + (data.getValue() ? "VICTORY" : "DEFEAT"), 50);
            element.setBgColor(data.getValue() ? Color.LIMEGREEN : Color.DARKRED);
            element.setBgWidth(4 * WIDTH / 5);
            element.setBgHeight(HEIGHT / 9);
            content.getChildren().add(element);
        }
    }
}
