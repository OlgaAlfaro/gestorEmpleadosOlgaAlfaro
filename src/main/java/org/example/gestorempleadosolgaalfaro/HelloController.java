package org.example.gestorempleadosolgaalfaro;

import Modelo.Trabajador;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.SQLException;
import java.util.Scanner;

public class HelloController {
    @FXML
    private TextField txtFieldNombre;
    @FXML
    private ComboBox<String> cmbBoxPuesto;
    @FXML
    private TextField txtFieldSalario;


    @FXML
    protected void onInsertar() throws SQLException {
        String nombre = txtFieldNombre.getText();
        String puesto = cmbBoxPuesto.getValue();
        Integer salario = Integer.valueOf(txtFieldSalario.getText());
        if(nombre == null || puesto == null || salario == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Todos los campos deben estar rellenados");
        }
        else{
            Trabajador trabajador = new Trabajador(nombre, puesto, salario);
            trabajador.insertarTrabajador(trabajador);
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("HECHO");
            alerta.setHeaderText("Mensaje");
            alerta.setContentText("Empleado " + nombre + " introducido en la base de datos satisfactoriamente.");
            alerta.showAndWait();
        }

    }

    @FXML
    protected void onCargarDatos() throws SQLException {

        try (FileReader fr = new FileReader("trabajadores.txt")){
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            while(linea!=null){
                Trabajador trabajador = parsearLinea(linea);
                trabajador.insertarTrabajador(trabajador);
                linea = br.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected static Trabajador parsearLinea(String linea) throws SQLException {
        String[] tokens = linea.split(";");
        int sueldo = Integer.parseInt(tokens[2]);
        Trabajador trabajador = new Trabajador(tokens[0], tokens[1], sueldo);
        return trabajador;
    }
}