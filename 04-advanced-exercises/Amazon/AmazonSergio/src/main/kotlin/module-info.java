module org.example.amazonsergio {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;


    opens org.example.amazonsergio to javafx.fxml;
    exports org.example.amazonsergio;
}