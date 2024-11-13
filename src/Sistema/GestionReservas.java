/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistema;

import Usuarios.Cliente;
import Vuelos.Vuelo;

import java.util.ArrayList;
import java.util.List;

public class GestionReservas {
    private List<Reserva> reservas = new ArrayList<>();

    public void crearReserva(Cliente cliente, Vuelo vuelo) {
        if (vuelo.getDisponibilidad() > 0) {
            Reserva reserva = new Reserva(cliente, vuelo);
            reservas.add(reserva);
            vuelo.reservarAsiento();
            System.out.println("Reserva creada exitosamente.");
        } else {
            System.out.println("No hay asientos disponibles en este vuelo.");
        }
    }

    public void cancelarReserva(Reserva reserva) {
        reservas.remove(reserva);
        reserva.getVuelo().liberarAsiento();
        System.out.println("Reserva cancelada.");
    }
    
    public List<Reserva> obtenerReservasCliente(Cliente cliente) {
        List<Reserva> reservasCliente = new ArrayList<>();
        for (Reserva reserva : reservas) {
            if (reserva.getIdCliente().equals(cliente)) {
                reservasCliente.add(reserva);
            }
        }
        return reservasCliente;
    }
}

