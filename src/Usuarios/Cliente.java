/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuarios;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Sistema.GestionReservas;
import Vuelos.Vuelo;
import Usuarios.Datos.*;
import Pagos.*;

/**
 * Clase que define a un cliente del sistema de vuelos y hoteles. Hereda de la clase Usuario los datos generales de un usuario
 * en el sistema, junto al nombre de usuario y la constraseña. Establece estructuras para almacenar los vuelos, movimientos y
 * tickets que el usuario vaya registrando en el sistema.
 * 
 * @author Equipo 5
 * @version 15.11.2024
 * 
 */
public class Cliente extends Usuario {
    private final String EFECTIVO = "efectivo";

    private List<Vuelo> baseVuelos; // vuelos suscritos
    private List<Ticket> ticketsGenerados; // tickets
    private List<Movimiento> movimientos;
    private MetodosPago formaDePago; // pagos en línea o en efectivo
    @SuppressWarnings("unused")
    private GestionReservas baseReservas; // reservas

    /**
     * Constructor de clase que inicializa todos los atributos.
     * 
     * @param nombreUsuario
     * @param contraseña
     * @param numUsuario
     * @param nombre
     * @param apellido
     * @param metodoDePago
     */
    public Cliente(String nombreUsuario, String contraseña, String numUsuario, String nombre, String apellido, String metodoDePago) {
        super(nombreUsuario, contraseña, numUsuario, nombre, apellido);
        setFormaDePago(metodoDePago);
        this.ticketsGenerados = new ArrayList<>();   
        this.baseReservas = new GestionReservas();
    }

    // Getters y setters
    public void agregarVuelo(Vuelo vuelo){
        baseVuelos.add(vuelo);
    }
    public Vuelo getVuelo(int numeroVuelo) {
        return baseVuelos.get(numeroVuelo);
    }
  
    public void agregarTicket(Ticket vuelo){
        ticketsGenerados.add(vuelo);
    }
    public Ticket getTicket(int numeroVuelo) {
        return ticketsGenerados.get(numeroVuelo);
    }

    public void agregarMovimiento(Movimiento movimiento){
        movimientos.add(movimiento);
    }
    public void verMovimientos() {
        for (Movimiento movimiento : movimientos) {
            System.out.println(movimiento);
        }
    }

    public void setFormaDePago(String metodoDePago) {
        if(metodoDePago == EFECTIVO){
            this.formaDePago = new PagosEfectivo();
        }else{
            this.formaDePago = new PagosLinea();
        }
    }
    public MetodosPago getMetodoDePago() {
        return formaDePago;
    }

    // Métodos adicionales
    public void verVuelos() {
        for (Vuelo vuelo : baseVuelos) {
            System.out.println(vuelo);
        }
    }

    public void verTickets() {
        for (Ticket ticket : ticketsGenerados) {
            System.out.println(ticket);
        }
    }

    public void descargarTicket(){
        Ticket ticket = getTicket(0);

        File descarga = new File("Descarga Ticket");
        try(BufferedWriter escritor = new BufferedWriter(new FileWriter(descarga, true))) {
            escritor.write(ticket.toString());
        } catch(IOException e) {
            e.getMessage();
        }
    }

    @Override
    public void recuperarContraseña() {
        // agregar la lógica correspondiente
    }
}
