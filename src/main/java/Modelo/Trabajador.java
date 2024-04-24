package Modelo;

import java.time.LocalDate;

public class Trabajador {
    private String nombre;
    private String puesto;
    private int salario;
    private LocalDate fechaAlta;

    public Trabajador(String nombre, String puesto, int salario) {
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
        this.fechaAlta = LocalDate.now();
    }
}
