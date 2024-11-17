/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuarios.Datos;

import java.time.LocalDateTime;
import java.util.Random;

import Usuarios.Cliente;

/**
 * Clase que implementa los tickets de compra que se generan con cada compra.
 * 
 * @author Equipo 5
 * @version 2024.11.17
 */
public class Ticket {
    private int idTicket;
    private Cliente cliente;
    private String tipoServicio; // "Vuelo", "Hotel", "Paquete"
    private String detalleServicio; // Detalles del servicio
    private LocalDateTime fechaCompra;
    private double precio;

    /** Contructor de clase */
    public Ticket(Cliente cliente, String tipoServicio, String detalleServicio, LocalDateTime fechaCompra, double precio) {
        this.idTicket = generarId();
        this.cliente = cliente;
        this.tipoServicio = tipoServicio;
        this.detalleServicio = detalleServicio;
        this.precio = precio;
    }

    private int generarId() {
        Random random = new Random();
        return 100_000_000 + random.nextInt(900_000_000);
    }

    // Getters
    public int getIdTicket() {
        return idTicket;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public String getDetalleServicio() {
        return detalleServicio;
    }
   
    
    public double getPrecio() {
        return precio;
    }

    public String detallesCompletos() {
        return "==== TICKET DE COMPRA ====\n" +
                "ID del Ticket: " + idTicket + "\n" +
                "Cliente: " + cliente.getNombre() + " " + cliente.getApellido() +
                "Tipo de servicio: " + tipoServicio + "\n" +
                "Detalles del servicio:\n" + detalleServicio + "\n" +
                "Fecha de compra" + fechaCompra + "\n" +
                "Total de compra: $" + precio + "\n" +
                "==========================\n";
    }

    @Override
    public String toString() {
        return "Ticket ID: " + idTicket + ", Servicio: " + tipoServicio + ", Detalle: " + detalleServicio;
    }
}
