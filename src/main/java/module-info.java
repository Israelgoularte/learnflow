module LearnFlow {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires java.sql;
    requires java.desktop;
    requires itextpdf;

    opens app to javafx.fxml;

    exports app;
}
