/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Extras;

/**
 *
 * @author PC
 */
public class Hoteles {
    private String nombre;
    private String ubicacion;
    private Double precio;
    

    private int habitacionesDisponibles;//no se si este atributo sea viable o se hace con una lista  que omite

    public Hoteles(String nombre, String ubicacion, Double precio, int habitacionesDisponibles) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.precio = precio;
        this.habitacionesDisponibles = habitacionesDisponibles;
    }


    //Metodos de reserva
    public void reservarHabitacion() {
        if (habitacionesDisponibles > 0) {
            habitacionesDisponibles--;
        } else {
            System.out.println("No hay habitaciones disponibles.");
        }
    }


    //setters getters

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
