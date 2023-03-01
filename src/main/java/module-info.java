module com.example.estacionamiento {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.estacionamiento to javafx.fxml;
    exports com.example.estacionamiento;
    exports com.example.estacionamiento.controllers;
    opens com.example.estacionamiento.controllers to javafx.fxml;
}