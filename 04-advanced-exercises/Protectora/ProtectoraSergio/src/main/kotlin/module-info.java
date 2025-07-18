module org.example.protectorasergio {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;
    requires java.sql;


    opens org.example.protectorasergio to javafx.fxml;
    exports org.example.protectorasergio;
}