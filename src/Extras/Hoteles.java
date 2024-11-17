/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Extras;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Representa un hotel con habitaciones disponibles para reserva.
 * 
 * @author Equipo 5
 * @version 2024.11.17
 */
public class Hoteles implements Serializable{
    private static final long serialVersionUID = 1L;
    private String nombre;
    private String ubicacion;
    private Double precio;
    private int habitacionesDisponibles;

    /** Constructor de la clase Hoteles. */
    public Hoteles(String nombre, String ubicacion, Double precio, int habitacionesDisponibles) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.precio = precio;
        this.habitacionesDisponibles = habitacionesDisponibles;
    }

    /** Reserva una habitación si hay disponibilidad. */
    public void reservarHabitacion() {
        if (habitacionesDisponibles > 0) {
            habitacionesDisponibles--;
        } else {
            System.out.println("No hay habitaciones disponibles.");
        }
    }

    /** Calcula el costo total de la estancia. */
    public double calcularCosto(LocalDate fechaInicio, LocalDate fechaFin) {
        long dias = ChronoUnit.DAYS.between(fechaInicio, fechaFin); // Calcula el costo por día.
        return dias * precio;
    }


    // Getters y setters
    /** Se definen getters y setters para todos los atributos. */
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Double getPrecio() {
        return precio;
    }
    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getHabitacionesDisponibles() {
        return habitacionesDisponibles;
    }
    public void setHabitacionesDisponibles(int habitacionesDisponibles) {
        this.habitacionesDisponibles = habitacionesDisponibles;
    }

    @Override
    public String toString() {
        return "Hoteles [nombre=" + nombre + ", ubicacion=" + ubicacion + ", habitacionesDisponibles="
                + habitacionesDisponibles + "]";
    }
}
