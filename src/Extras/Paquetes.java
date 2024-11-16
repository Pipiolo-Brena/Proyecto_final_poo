/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Extras;

/**
 *
 * @author PC
 */

import Vuelos.Vuelo;

public class Paquetes {
    private Vuelo vuelo;
    private Hoteles hotel;
    private double precioTotal;

    public Paquetes(Vuelo vuelo, Hoteles hotel) {
        this.vuelo = vuelo;
        this.hotel = hotel;
        this.precioTotal = vuelo.getPrecio() + hotel.getPrecio();
    }

    public void mostrarDetalles() {
        System.out.println("Paquete: Vuelo + Hotel");
        vuelo.mostrarDetalles();
        System.out.println("Hotel: " + hotel.getNombre() + " - Precio: " + hotel.getPrecio());
        System.out.println("Precio Total: " + precioTotal);
    }
}

