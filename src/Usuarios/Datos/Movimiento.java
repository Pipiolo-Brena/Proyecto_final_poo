/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuarios.Datos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author PC
 */

public class Movimiento {
    private DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy 'a las' hh:mm:ss a");  // Define el formato que tendrá el atributo, el cuál mostrará la fecha del movimiento.
    private LocalDateTime fecha;    // Atributo que almacena la fecha y hora en la que se realizó el movimiento.
    private double cantidad;    // Atributo que almacena la cantidad de dinero involucrada en el movimiento.
    private String tipo;    // Atributo que almacena el tipo de movimiento ("Depósito", "Retiro")
    

    public Movimiento(double cantidad, String tipo){
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.fecha = LocalDateTime.now();
    }


    public Movimiento(String tipo){
        this.tipo = tipo;
        this.fecha = LocalDateTime.now();
    }

    public Movimiento(double cantidad, String tipo,int dia, int mes, int año, int hora, int  minuto){
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.fecha = LocalDateTime.of(año, mes, dia, hora, minuto, 0);
    }

    public String toString() {
        return "Tipo: "+tipo+"\n"+ 
                "Cantidad: "+cantidad+"\t Fecha : "+fecha.format(formatoFecha);
    }
}
