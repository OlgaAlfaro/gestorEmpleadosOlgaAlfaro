package org.example.gestorempleadosolgaalfaro;

import Modelo.Trabajador;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {
    @FXML
    private TextField txtFieldNombre;
    @FXML
    private ComboBox<String> cmbBoxPuesto;
    @FXML
    private TextField txtFieldSalario;


    @FXML
    protected void onHelloButtonClick() {
        String nombre = txtFieldNombre.getText();
        String puesto = cmbBoxPuesto.getValue();
        Integer salario = Integer.valueOf(txtFieldSalario.getText());
        Trabajador trabajador = new Trabajador(nombre, puesto, salario);
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("HECHO");
        alerta.setHeaderText("Mensaje");
        alerta.setContentText("Empleado " + nombre + " introducido en la base de datos satisfactoriamente.");
        alerta.showAndWait();
    }
}