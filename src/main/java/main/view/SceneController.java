package main.view;

import javafx.scene.Scene;
import javafx.stage.Stage;



public class SceneController {
    enum Scenes {
        MENU(new Menu().getScene());
        //GAME,
        //HISTORY;

        final Scene scene;
        private Scenes(Scene scene) {
            this.scene = scene;
        }
    }
    Stage stage;
    public SceneController(Stage stage) {
        this.stage = stage;
    }
    public Runnable getChangeScene(Scenes x) {
        return ()->stage.setScene(x.scene);
    }
}
