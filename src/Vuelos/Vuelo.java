/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vuelos;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Representa un vuelo, incluyendo detalles como aerolínea, origen, destino,
 * fecha, precio y lista de asientos. 
 * 
 * @author Equipo 5
 * @version 2024.11.17
 */
public class Vuelo implements Serializable{
    private static final long serialVersionUID = 1L;
    private String aerolinea;
    private String numVuelo;
    private String origen;
    private String destino;
    private transient LocalDateTime fechaSalida;
    private Double precio;
    private double precioVip;
    private int escalas;
    private boolean vueloNacional;
    private boolean requiereVisa;
    private Map<String, Asiento> asientos; 


    /** Constructor para vuelos nacionales */
    public Vuelo(String aerolinea, String numVuelo, String origen, String destino, LocalDateTime fechaSalida, double precio) {
        this.aerolinea = aerolinea;
        this.numVuelo = numVuelo;
        this.origen = origen;
        this.destino = destino;
        this.fechaSalida = fechaSalida;
        this.precio = precio;
        this.precioVip = precio * 1.60;
        this.escalas = 0;
        this.vueloNacional = false;
        this.requiereVisa = false;
        this.asientos = new HashMap<>();

        for(int i = 1; i <= 30; i++) {
            boolean esVIP = i <= 10; // Los primeros 10 asientos son vip
            agregarAsiento("A" + i, esVIP);
        }
    }

    /** Constructor para vuelos internacionales */
    public Vuelo(String aerolinea, String numVuelo, String origen, String destino, LocalDateTime fechaSalida, double precio, int escalas, boolean vueloNacional, boolean requiereVisa) {
        this.aerolinea = aerolinea;
        this.numVuelo = numVuelo;
        this.origen = origen;
        this.destino = destino;
        this.fechaSalida = fechaSalida;
        this.precio = precio;
        this.precioVip = precio * 1.60;
        this.escalas = escalas;
        this.vueloNacional = vueloNacional;
        this.requiereVisa= requiereVisa;
        this.asientos = new HashMap<>();

        for(int i = 1; i <= 30; i++) {
            boolean esVIP = i <= 10; // Los primeros 10 asientos son vip
            agregarAsiento("A" + i, esVIP);
        }
    }

    // Métodos principales
    /** Muestra detalles del vuelo, incluyendo la disponibilidad de asientos. */
    public void mostrarDetalles(){
        System.out.println("Aerolinea: " + getAerolinea() + 
        "\nNum. de vuelo:" + getNumVuelo() + 
        "\nParte de: " + getOrigen() + 
        "\nLlega a: " + getDestino() + 
        "\nEscalas " + getEscalas() + 
        "\nFecha de salida: " + getFechaSalida() + 
        "\nPrecio: " + getPrecio() + 
        "\nAsientos disponibles: " + getDisponibilidad());
    }

    /** Calcula y develve la cantidad de asientos disponibles. */
    public int getDisponibilidad() {
        int disponibles = 0;
        for(Asiento asiento : asientos.values()) {
            if(!asiento.estaOcupado()) disponibles++;
        }
        return disponibles;
    }

    /** Agrega un asiento al vuelo. */
    public void agregarAsiento(String numero, boolean esVIP) {
        if (asientos.containsKey(numero)) {
            throw new IllegalArgumentException("El asiento ya existe.");
        }
        asientos.put(numero, new Asiento(numero, esVIP));
    }

    /** Reserva un asiento del vuelo. */
    public void reservarAsiento(String numero) {
        Asiento asiento = obtenerAsiento(numero);
        asiento.reservar();
        System.out.println("El asiento " + numero + " ha sido reservado.");
    }

    /** Cancela la reserva de un asiento. */
    public void cancelarAsiento(String numero) {
        Asiento asiento = obtenerAsiento(numero);
        asiento.cancelar();
        System.out.println("La reserva del asiento " + numero + " ha sido cancelada.");
    }

    /** Muestra el estado de todos los asientos. */
    public void mostrarAsientos() {
        System.out.println("Estado de los asientos:");
        for (Asiento asiento : asientos.values()) {
            System.out.println(asiento);
        }
    }

    public Asiento obtenerAsiento(String numero) {
        if (!asientos.containsKey(numero)) {
            throw new IllegalArgumentException("El asiento no existe.");
        }
        return asientos.get(numero);
    }

    // Gettes y setters
    /** Se declaran getters y setters para todos los atributos. */  
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

    public double getPrecioVip() {
        return precioVip;
    }
    public void setPrecioVip(double precioVip) {
        this.precioVip = precioVip;
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

    public boolean getRequiereVisa() {
        return requiereVisa;
    }
    public void setRequiereVisa(boolean requiereVisa) {
        this.requiereVisa = requiereVisa;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Vuelo " + numVuelo + " de " + aerolinea);
        sb.append("\nOrigen: " + origen);
        sb.append("\nDestino: " + destino);
        sb.append("\nFecha de salida: " + fechaSalida);
        sb.append("\nPrecio: " + precio);
        sb.append("\nEscalas: " + escalas);
        sb.append("\nVuelo nacional: " + (vueloNacional ? "Sí" : "No"));
        sb.append("\nRequiere visa: " + (requiereVisa ? "Sí" : "No"));
        sb.append("\nDisponibilidad de asientos: " + getDisponibilidad());
    
        // Agregar los asientos disponibles
        sb.append("\nAsientos disponibles: ");
        for (Asiento asiento : asientos.values()) {
            if (!asiento.estaOcupado()) {
                sb.append("\n" + asiento.getNumero() + (asiento.esVIP() ? " (VIP)" : ""));
            }
        }
    
        return sb.toString();
    }
}
