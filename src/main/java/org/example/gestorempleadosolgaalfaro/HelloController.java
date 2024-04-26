package org.example.gestorempleadosolgaalfaro;

import Modelo.Trabajador;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.SQLException;

public class HelloController {
    @FXML
    private TextField txtFieldNombre;
    @FXML
    private ComboBox<String> cmbBoxPuesto;
    @FXML
    private TextField txtFieldSalario;


    @FXML
    protected void onHelloButtonClick() throws SQLException {
        String nombre = txtFieldNombre.getText();
        String puesto = cmbBoxPuesto.getValue();
        Integer salario = Integer.valueOf(txtFieldSalario.getText());
        Trabajador trabajador = new Trabajador(nombre, puesto, salario);
        trabajador.insertarTrabajador(trabajador);
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("HECHO");
        alerta.setHeaderText("Mensaje");
        alerta.setContentText("Empleado " + nombre + " introducido en la base de datos satisfactoriamente.");
        alerta.showAndWait();
    }
}