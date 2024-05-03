package org.example.gestorempleadosolgaalfaro;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.sql.*;

public class EdicionController {

    @FXML
    private Label lblIdTrabajador;
    @FXML
    private TextField txtFldNombre;
    @FXML
    private TextField txtFldPuesto;
    @FXML
    private TextField txtFldSal;
    private String nombre1;

    protected void mostrar(String nom){
        String url = "jdbc:mysql://localhost:3306/bdgestorEmpleados";
        String user = "root";
        String pass = "root";

        nombre1 = nom;

        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(url, user, pass);
            PreparedStatement pst = conexion.prepareStatement("select * from trabajador where nombre = ?");
            pst.setString(1, nom);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                lblIdTrabajador.setText(rs.getString("ID"));
                txtFldNombre.setText(rs.getString("Nombre"));
                txtFldPuesto.setText(rs.getString("Puesto"));
                txtFldSal.setText(rs.getString("Salario"));
            }
            conexion.close();
        }
        catch(SQLException e){
            throw new IllegalStateException("Error al conectar la BD");
        }
    }
    @FXML
    protected void onModificar(){
        String url = "jdbc:mysql://localhost:3306/bdgestorEmpleados";
        String user = "root";
        String pass = "root";

        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(url, user, pass);

            PreparedStatement st = conexion.prepareStatement("SELECT ID FROM trabajador WHERE NOMBRE = ?");
            st.setString(1, nombre1);
            ResultSet rs = st.executeQuery();
            int id = 0;
            while(rs.next()){
                id = rs.getInt("ID");
            }

            PreparedStatement pst = conexion.prepareStatement("SET sql_safe_updates=0;");
            pst.executeUpdate();

            PreparedStatement pst1 = conexion.prepareStatement("UPDATE TRABAJADOR SET NOMBRE = ?, PUESTO = ?, SALARIO = ? WHERE ID = ?");
            pst1.setString(1, txtFldNombre.getText());
            pst1.setString(2, txtFldPuesto.getText());
            pst1.setInt(3, Integer.parseInt(txtFldSal.getText()));
            pst1.setInt(4, id);
            pst1.executeUpdate();

            PreparedStatement pst2 = conexion.prepareStatement("SET sql_safe_updates=1;");
            pst2.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Trabajador actualizado con éxito");

        }
        catch(SQLException e){
            throw new IllegalStateException("Error al modificar trabajador");
        }
    }

    @FXML
    protected void onCancelar(ActionEvent event){
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

}
