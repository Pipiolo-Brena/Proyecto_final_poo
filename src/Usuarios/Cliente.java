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

import Extras.Hoteles;
import Extras.Observador;
import Pagos.GestorPagos;
import Pagos.MetodosPago;
import Vuelos.Vuelo;
import Usuarios.Datos.*;

/**
 * Clase que define a un cliente del sistema de vuelos y hoteles. Hereda de la clase Usuario los datos generales de un usuario
 * en el sistema, junto al nombre de usuario y la constraseña. Establece estructuras para almacenar los vuelos, movimientos y
 * tickets que el usuario vaya registrando en el sistema.
 * 
 * @author Equipo 5
 * @version 15.11.2024
 * 
 */
public class Cliente extends Usuario implements Observador {
    private List<String> notificaciones;
    
    private List<Vuelo> baseVuelos; // Vuelos reservados
    private List<Hoteles> baseHoteles; // Hoteles reservados
    private List<Ticket> ticketsGenerados; // Tickets generados
    private List<Movimiento> movimientos; // Historial de movimientos
    
    private GestorPagos gestorDePagos;
    private MetodosPago metodoSeleccionado;

    public Cliente(String nombreUsuario, String contraseña, String nombre, String apellido, String metodoDePago) {
        super(nombreUsuario, contraseña, nombre, apellido);
        this.baseVuelos = new ArrayList<>();
        this.baseHoteles = new ArrayList<>();
        this.ticketsGenerados = new ArrayList<>();   
        this.movimientos = new ArrayList<>();
        
        this.gestorDePagos = new GestorPagos();
        this.metodoSeleccionado = agregarMetodoPago(metodoDePago);
    }

    // Métodos de Observer para implementar el patrón de diseño Observer
    @Override
    public void actualizar(String mensaje) {
        notificaciones.add(mensaje);
    }

    public void mostrarNotificaciones() {
        System.out.println("Notificaciones:");
        for(String notificacion : notificaciones) {
            System.out.println("- " + notificacion);
        }
        notificaciones.clear();
    }

    // Getters y setters
    public void agregarVuelo(Vuelo vuelo){
        baseVuelos.add(vuelo);
    }
    public Vuelo getVuelo(int numeroVuelo) {
        return baseVuelos.get(numeroVuelo);
    }

    public void agregarHotel(Hoteles hotel) {
        baseHoteles.add(hotel);
    }
    public Hoteles getHotel(int numHotel) {
        return baseHoteles.get(numHotel);
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

    // Métodos adicionales
    public MetodosPago agregarMetodoPago(String nombreMetodo) {
        return gestorDePagos.registrarMetodoPago(nombreMetodo);
    }

    public void realizarPago(double monto) {
        if(metodoSeleccionado == null) {
            System.out.println("No se ha seleccionado ningún método de pago.");
            return;
        }

        metodoSeleccionado.setMonto(monto);
        if(metodoSeleccionado.validarPago()) {
            metodoSeleccionado.realizarPago(monto);
            System.out.println("Pago realizado exitosamente.");
        } else {
            System.out.println("El método de pago no es válido.");
        }
    }

    public void listaMetodosDePago() {
        gestorDePagos.metodosPagoDisponibles();
    }
  
    public void verVuelos() {
        for (Vuelo vuelo : baseVuelos) {
            System.out.println(vuelo);
        }
    }

    public void verTickets() {
        int i = 1;
        for (Ticket ticket : ticketsGenerados) {
            System.out.println("Ticket "+ i +".- ID: "+ ticket.getIdTicket() + "| Tipo de compra: " + ticket.getTipoServicio());
            i++;
        }
    }

    public void verHoteles() {
        for(Hoteles hotel : baseHoteles) {
            System.out.println(hotel);
        }
    }

    public void descargarTicket(int numTicket){
        if(ticketsGenerados.size() > numTicket && numTicket != 0) {
            Ticket ticket = getTicket(numTicket);

            File archivoDescarga = new File("Ticket_" + ticket.getIdTicket() + ".txt");
            try(BufferedWriter escritor = new BufferedWriter(new FileWriter(archivoDescarga))) {
                escritor.write(ticket.detallesCompletos());
            } catch(IOException e) {
                e.getMessage();
            }
        } else {
            System.out.println("Número de ticket en la lista inválido.");
        }
    }
}
