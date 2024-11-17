/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vuelos;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author PC
 */
public class Vuelo {
    private String aerolinea;
    private String numVuelo;
    private String origen;
    private String destino;
    private LocalDateTime fechaSalida;
    protected Double precio;
    protected int disponibilidad;
    protected int escalas;
    protected boolean vueloNacional;
    private boolean requiereVisa;
    private Map<String, Asiento> asientos; 


    //constructor
    public Vuelo(String aerolinea, String numVuelo, String origen, String destino, LocalDateTime fechaSalida, double precio, int disponibilidad) {
        this.aerolinea = aerolinea;
        this.numVuelo = numVuelo;
        this.origen = origen;
        this.destino = destino;
        this.fechaSalida = fechaSalida;
        this.precio = precio;
        this.disponibilidad = disponibilidad;
        this.escalas = 0;
        this.asientos = new HashMap<>();
        this.vueloNacional = false;
        this.requiereVisa=false;
    }

    public Vuelo(String aerolinea, String numVuelo, String origen, String destino, LocalDateTime fechaSalida, double precio, int disponibilidad, int escalas, boolean vueloNacional,boolean requiereVisa) {
        this.aerolinea = aerolinea;
        this.numVuelo = numVuelo;
        this.origen = origen;
        this.destino = destino;
        this.fechaSalida = fechaSalida;
        this.precio = precio;
        this.disponibilidad = disponibilidad;
        this.escalas = escalas;
        this.vueloNacional = vueloNacional;
        this.requiereVisa= requiereVisa;
        this.asientos = new HashMap<>();
    }

    //metodos
    public void mostrarDetalles(){
        System.out.println("Aerolinea: " + getAerolinea() + 
        "Numm. de vuelo:" + getNumVuelo() + 
        "Parte de: " + getOrigen() + 
        "Llega a: " + getDestino() + 
        "Escalas " + getEscalas() + 
        "Fecha de salida: " + getFechaSalida() + 
        "Precio: " + getPrecio());
    
    }

    public void agregarAsiento(String numero, boolean esVIP) {
        if (asientos.containsKey(numero)) {
            throw new IllegalArgumentException("El asiento ya existe.");
        }
        asientos.put(numero, new Asiento(numero, esVIP));
    }

    // Método para reservar un asiento
    public void reservarAsiento(String numero) {
        Asiento asiento = obtenerAsiento(numero);
        asiento.reservar();
        System.out.println("El asiento " + numero + " ha sido reservado.");
    }

    // Método para cancelar un asiento
    public void cancelarAsiento(String numero) {
        Asiento asiento = obtenerAsiento(numero);
        asiento.cancelar();
        System.out.println("La reserva del asiento " + numero + " ha sido cancelada.");
    }

    // Método para mostrar el estado de los asientos
    public void mostrarAsientos() {
        System.out.println("Estado de los asientos:");
        for (Asiento asiento : asientos.values()) {
            System.out.println(asiento);
        }
    }

    private Asiento obtenerAsiento(String numero) {
        if (!asientos.containsKey(numero)) {
            throw new IllegalArgumentException("El asiento no existe.");
        }
        return asientos.get(numero);
    }

    //setters getters
    public String getAerolinea() {
        return aerolinea;
    }
    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }

    public String getNumVuelo() {
        return numVuelo;
    }
    public void setNumVuelo(String numVuelo) {
        this.numVuelo = numVuelo;
    }

    public String getOrigen() {
        return origen;
    }
    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public LocalDateTime getFechaSalida() {
        return fechaSalida;
    }
    public void setFechaSalida(LocalDateTime fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getDisponibilidad() {
        return disponibilidad;
    }
    public void setDisponibilidad(int disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public int getEscalas() {
        return escalas;
    }
    public void setEscalas(int escalas) {
        this.escalas = escalas;
    }

    public boolean isVueloNacional() {
        return vueloNacional;
    }
    public void setVueloNacional(boolean vueloNacional) {
        this.vueloNacional = vueloNacional;
    }

    @Override
    public String toString() {
        return "Vuelo " + numVuelo + " de " + aerolinea;
    }


}
