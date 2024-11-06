/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistema;

import java.time.LocalDateTime;
import java.util.List;

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
    private List<Ticket> ticketsGenerados; //ticket

    //constructor
    public Ticket(int idTicket, Cliente cliente, String numVuelo, LocalDateTime fechaCompra) {
        this.idTicket = idTicket;
        this.cliente = cliente;
        this.numVuelo = numVuelo;
        this.fechaCompra = fechaCompra;
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

    public List<Ticket> getTicketsGenerados() {
        return ticketsGenerados;
    }

    public void setTicketsGenerados(List<Ticket> ticketsGenerados) {
        this.ticketsGenerados = ticketsGenerados;
    }


    @Override
    public String toString() {
        return "Ticket ID: " + idTicket + ", Cliente: " + cliente.getNombreUsuario() + ", Vuelo: " + numVuelo;
    }

    
}
