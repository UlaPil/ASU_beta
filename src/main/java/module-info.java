module ASU.beta {
    requires javafx.graphics;
    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens main to javafx.fxml;
    exports main;
    exports main.view;
    exports main.model;
    opens main.view to javafx.fxml;
}