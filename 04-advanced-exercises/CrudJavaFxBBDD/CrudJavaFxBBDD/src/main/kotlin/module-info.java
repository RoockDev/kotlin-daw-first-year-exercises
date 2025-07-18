module org.example.crudjavafxbbdd {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;
    requires jdk.jdi;
    requires java.sql;


    opens org.example.crudjavafxbbdd to javafx.fxml;
    exports org.example.crudjavafxbbdd;
}