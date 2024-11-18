package Vuelos;

import java.io.Serializable;

/**
 * Representa un asiento de un vuelo.
 * 
 * @author Equipo 5
 * @version 2024.11.17
 */

public class Asiento implements Serializable {
    private static final long serialVersionUID = 1L;
    private String numero; // número del asiento
    private boolean esVIP; // indica si es VIP
    private boolean ocupado; // indica si está ocupado

    /**
     * Constructor para crear un asiento.
     * 
     * @param numero
     * @param esVIP
     */
    public Asiento(String numero, boolean esVIP) {
        this.numero = numero;
        this.esVIP = esVIP;
        this.ocupado = false;
    }

    // Getters
    /** Se declaran getters para todos los atributos. */ 
    public String getNumero() {
        return numero;
    }

    public boolean esVIP() {
        return esVIP;
    }

    public boolean estaOcupado() {
        return ocupado;
    }

    /** Reserva el asiento si está disponible. */
    public void reservar() {
        if(ocupado) {
            System.out.println("El asiento no está disponible para reservar.");
            return;
        }
        ocupado = true;
    }

    /** Cancela la reserva del asiento si está reservado. */
    public void cancelar() {
        if(!ocupado) {
            System.out.println("El asiento no está reservado, no se puede cancelar.");
            return;
        }
        ocupado = false;
    } // Eliminé liberar porque hacia lo mismo que cancelar

    @Override
    public String toString() {
        return "Asiento {" +
                "numero='" + numero + '\'' +
                ", esVIP=" + esVIP +
                ", ocupado=" + ocupado +
                '}';
    }
}
