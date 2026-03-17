module ucr.algoritmos.demo {
    // 1. Librerías que tu proyecto necesita para funcionar
    requires javafx.controls;
    requires javafx.fxml;

    // 2. Permite que JavaFX lea tus clases (necesario para el Controller)
    opens ucr.algoritmos.demo to javafx.fxml;
    opens controller to javafx.fxml;
    opens model to javafx.fxml;

    // 3. Permite que otros módulos usen tu paquete principal
    exports ucr.algoritmos.demo;
}