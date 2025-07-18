module org.example.legosergio {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;
    requires java.sql;


    opens org.example.legosergio to javafx.fxml;
    exports org.example.legosergio;
}