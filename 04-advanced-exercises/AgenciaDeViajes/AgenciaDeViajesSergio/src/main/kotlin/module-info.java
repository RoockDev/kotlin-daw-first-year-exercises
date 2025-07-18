module org.example.agenciadeviajessergio {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;
    requires java.sql;


    opens org.example.agenciadeviajessergio to javafx.fxml;
    exports org.example.agenciadeviajessergio;
}