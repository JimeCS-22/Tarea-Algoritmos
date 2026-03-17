module ucr.algoritmos.demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens ucr.algoritmos.demo to javafx.fxml;
    exports ucr.algoritmos.demo;
}