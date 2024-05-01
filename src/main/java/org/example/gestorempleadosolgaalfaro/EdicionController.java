package org.example.gestorempleadosolgaalfaro;

import javafx.fxml.FXML;
import javafx.scene.control.*;

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

    protected void mostrar(String nom){
        String url = "jdbc:mysql://localhost:3306/bdgestorEmpleados";
        String user = "root";
        String pass = "root";

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
        }
        catch(SQLException e){
            throw new IllegalStateException("Error al conectar la BD");
        }
    }


}
