module org.example.gestorempleadosolgaalfaro {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.gestorempleadosolgaalfaro to javafx.fxml;
    exports org.example.gestorempleadosolgaalfaro;
}