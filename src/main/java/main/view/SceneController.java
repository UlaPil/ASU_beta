package main.view;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.HashMap;
import java.util.Map;


public class SceneController {
    public enum SceneName {
        MENU,
        PLAY,
        HISTORY
    }
    private final Map<SceneName, AsuScene> Scenes = new HashMap<>();
    Stage stage;
    public SceneController(Stage stage) {
        this.stage = stage;
        Scenes.put(SceneName.MENU, new Menu());
        initializeScenes();
    }
    private void initializeScenes() {
        //Menu
        Menu scene = (Menu)Scenes.get(SceneName.MENU);
        scene.setEvent(Menu.But.EXIT, getCloser());
        //scene.setEvent(Menu.But.PLAY, getSceneChanger(SceneName.PLAY));
        //scene.setEvent(Menu.But.PLAY, getSceneChanger(SceneName.PLAY);
    }

    public void init() {
        stage.setScene(Scenes.get(SceneName.MENU).getScene());
        stage.setResizable(false);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();

    }
    public EventHandler<MouseEvent> getSceneChanger(SceneName name ) {
        return e -> stage.setScene(Scenes.get(name).getScene());
    }
    public EventHandler<MouseEvent> getCloser() {
        return e -> stage.close();
    }

}
