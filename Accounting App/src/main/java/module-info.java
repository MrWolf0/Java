module com.accouting.accountingapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;
    requires java.sql;
    requires mysql.connector.j;
    requires jakarta.persistence;
    opens main to javafx.fxml;
    exports main;
    exports model;
    opens model to javafx.fxml;
    exports controllers;
    opens controllers to javafx.fxml;
}