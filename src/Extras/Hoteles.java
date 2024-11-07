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
    private int habitacionesDisponibles;//no se si este atributo sea viable o se hace con una lista  que omite

    public Hoteles(String nombre, String ubicacion, int habitacionesDisponibles) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.habitacionesDisponibles = habitacionesDisponibles;
    }


    //Metodos de reserva

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
