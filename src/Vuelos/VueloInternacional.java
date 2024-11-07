/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vuelos;

import java.time.LocalDateTime;

/**
 *
 * @author PC
 */
public class VueloInternacional extends Vuelo {
    private String destinoPais;
    private boolean requiereVisa;

    
    //constructor
    public VueloInternacional(String aerolinea, String numVuelo, String origen, String destinoPais, boolean requiereVisa, LocalDateTime fechaSalida, double precio, int disponibilidad, int escalas) {
        super(aerolinea, numVuelo, origen, fechaSalida, precio, disponibilidad, escalas, false);
        this.destinoPais = destinoPais;
        this.requiereVisa = requiereVisa;
    }

    //settres getters
    public String getDestinoPais() {
        return destinoPais;
    }

    public void setDestinoPais(String destinoPais) {
        this.destinoPais = destinoPais;
    }

    public boolean RequiereVisa() {
        return requiereVisa;
    }

    public void setRequiereVisa(boolean requiereVisa) {
        this.requiereVisa = requiereVisa;
    }

    @Override
    public String toString() {
        return super.toString() + " con destino a " + destinoPais + (requiereVisa ? " (requiere visa)" : "");
    }

}
