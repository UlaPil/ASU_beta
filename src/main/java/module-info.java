module ASU.beta {
    requires javafx.graphics;
    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;

    opens main to javafx.fxml;
    exports main;
}