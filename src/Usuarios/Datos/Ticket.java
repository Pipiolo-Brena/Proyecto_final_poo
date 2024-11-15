/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuarios.Datos;

import java.time.LocalDateTime;


import Usuarios.Cliente;

/**
 *
 * @author PC
 */
public class Ticket {
    private int idTicket;
    private Cliente cliente;
    private String numVuelo;
    private LocalDateTime fechaCompra;
    private String lugar;

    //constructor
    public Ticket(int idTicket, Cliente cliente, String numVuelo, LocalDateTime fechaCompra, String lugar) {
        this.idTicket = idTicket;
        this.cliente = cliente;
        this.numVuelo = numVuelo;
        this.fechaCompra = fechaCompra;
        this.lugar=lugar;
    }

    //setters getters
    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNumVuelo() {
        return numVuelo;
    }

    public void setNumVuelo(String numVuelo) {
        this.numVuelo = numVuelo;
    }

    public LocalDateTime getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDateTime fechaCompra) {
        this.fechaCompra = fechaCompra;
    }


    @Override
    public String toString() {
        return "Ticket ID: " + idTicket + ", Cliente: " + cliente.getNombreUsuario() + ", Vuelo: " + numVuelo;
    }

    
}
