/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Extras;
import Vuelos.Vuelo;

/**
 * Representa un paquete de viajes que puede incluir un vuelo y un hotel.
 * 
 * @author Equipo 5
 * @version 2024.11.17
 */

public class Paquetes {
    private Vuelo vuelo;
    private Hoteles hotel;
    private double precioTotal;

    /** Constructor de la clase paquetes. */
    public Paquetes(Vuelo vuelo, Hoteles hotel) {
        this.vuelo = vuelo;
        this.hotel = hotel;
        this.precioTotal = getPrecioTotal();
    }

    /** Muestra los detalles del paquete. */
    public void mostrarDetalles() {
        System.out.println("Paquete: Vuelo + Hotel");
        System.out.println("Vuelo:");
        vuelo.mostrarDetalles();
        System.out.println("Hotel: " + hotel.getNombre() + " - Precio: " + hotel.getPrecio());
        System.out.println("Precio Total: " + precioTotal);
    }

    // Getters y setters
    /** Se definen getters y setters para todos los atributos. */
    public double getPrecioTotal() {
        return vuelo.getPrecio() + hotel.getPrecio();
    }

    public Vuelo getVuelo() {
        return vuelo;
    }
    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    public Hoteles getHotel() {
        return hotel;
    }
    public void setHotel(Hoteles hotel) {
        this.hotel = hotel;
    }
}
