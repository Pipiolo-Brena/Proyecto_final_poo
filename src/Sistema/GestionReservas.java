/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistema;

import Usuarios.Cliente;
import Vuelos.Vuelo;
import Extras.Hoteles;
import Extras.Paquetes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Gestiona las reservas realizadas por los clientes.
 * 
 * @author Equipo 5
 * @version 2024.11.17
 */

public class GestionReservas {
    private List<Reserva> reservas;

    public GestionReservas() {
        this.reservas = new ArrayList<>();
    }

    /** Crea una nueva reserva de vuelo para el cliente. */
    public void crearReservaVuelo(Cliente cliente, Vuelo vuelo, int numAsiento) {
        if(vuelo.getDisponibilidad() > 0) {
            Reserva reserva = new Reserva(cliente, vuelo);
            reservas.add(reserva);
            vuelo.reservarAsiento(String.valueOf(numAsiento));
            // cliente.agregarReserva(reserva);
            System.out.println("Reserva de vuelo creada existosamente.");
        } else {
            System.out.println("No hay asientos disponibles en este vuelo.");
        }
    }

    /** Crea una nueva reserva de hotel para el cliente. */
    public void crearReseraHotel(Cliente cliente, Hoteles hotel, LocalDate fechaInicio, LocalDate fechaFin) {
        if(hotel.getHabitacionesDisponibles() > 0) {
            Reserva reserva = new Reserva(cliente, hotel, fechaInicio);
            reservas.add(reserva);
            hotel.reservarHabitacion();
            // cliente.agregarReserva(reserva);
            System.out.println("Reserva de hotel creado exitosamente.");
        } else {
            System.out.println("No hay habitaciones disponibles en este hotel.");
        }
    }

    /** Crea una nueva reserva de paquete para el cliente. */
    public void crearReservaPaquete(Cliente cliente, Vuelo vuelo, Hoteles hotel, LocalDate fechaInicio, LocalDate fechaFin, int numAsiento) {
        if(vuelo.getDisponibilidad() > 0 && hotel.getHabitacionesDisponibles() > 0) {
            Paquetes paquetes = new Paquetes(vuelo, hotel);
            Reserva reserva = new Reserva(cliente, paquetes, fechaInicio);
            reservas.add(reserva);
            vuelo.reservarAsiento(String.valueOf(numAsiento));
            hotel.reservarHabitacion();
            // cliente.agregarReserva(reserva);
            System.out.println("Reserva de paquete creada exitosamente.");
        } else {
            System.out.println("No hay disponiblidad en el vuelo o hotel para este paquete.");
        }
    }

    /** Cancela la reservación dependiendo del tipo de reserva. */
    public void cancelarReserva(Cliente cliente, Reserva reserva) {
        reservas.remove(reserva);
        if(reserva.getTipoReserva().equals("Vuelo")) {
            reserva.getVuelo().cancelarAsiento(null);
        } else if(reserva.getTipoReserva().equals("Hotel")) {
            reserva.getHotel(); // liberarHabitacion
        } else if(reserva.getTipoReserva().equals("Paquete")) {
            reserva.getPaquete(); // liberarPaquete
        }
        System.out.println("Reserva cancelada.");
    }
    
    /** Retorna la lista de reservaciones que tiene un cliente. */
    public List<Reserva> obtenerReservasCliente(Cliente cliente) {
        List<Reserva> reservasCliente = new ArrayList<>();
        for (Reserva reserva : reservas) {
            if (reserva.getIdCliente().equals(cliente.getNombreUsuario())) {
                reservasCliente.add(reserva);
            }
        }
        return reservasCliente;
    }
}
