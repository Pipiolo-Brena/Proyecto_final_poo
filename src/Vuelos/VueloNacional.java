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
public class VueloNacional extends Vuelo {
    private String destinoEstado;

    

    public VueloNacional(String aerolinea, String numVuelo, String origen, String destinoEstado, LocalDateTime fechaSalida, double precio, int disponibilidad, int escalas) {
        super(aerolinea, numVuelo, origen, fechaSalida, precio, disponibilidad, escalas, true);
        this.destinoEstado = destinoEstado;
    }

    @Override
    public String toString() {
        return super.toString() + " con destino a " + destinoEstado;
    }

    //setters getters
    public String getDestinoEstado() {
        return destinoEstado;
    }

    public void setDestinoEstado(String destinoEstado) {
        this.destinoEstado = destinoEstado;
    }
}
