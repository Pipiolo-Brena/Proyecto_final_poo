package Sistema;

import Usuarios.Cliente;
import Usuarios.Datos.Movimiento;
import Usuarios.Datos.Ticket;
import Extras.Hoteles;
import Vuelos.Vuelo;
import Extras.Paquetes;

import java.time.LocalDateTime;

/**
 * Clase encargada de gestionar la compra de vuelos, hoteles y paquetes, generando movimientos y tickets.
 * 
 * @author Equipo 5
 * @version 2024.11.17
 */

public class GestionCompras {
    private static int contadorTickets = 1;


    public static void comprarVuelo(Cliente cliente, Vuelo vuelo) {
        if(vuelo.getDisponibilidad() > 0) {
            vuelo.reservarAsiento(null);
            cliente.realizarPago(vuelo.getPrecio());
            cliente.agregarVuelo(vuelo);

            Ticket ticket = new Ticket(contadorTickets++, cliente, vuelo.getNumVuelo(), LocalDateTime.now(), vuelo.getNumVuelo());
            cliente.agregarTicket(ticket);

            Movimiento movimiento = new Movimiento(vuelo.getPrecio(), "Compra de vuelo");
            cliente.agregarMovimiento(movimiento);

            System.out.println(" El vuelo ha sido comprado existosamente.");
        } else {
            System.out.println(" El vuelo no tiene asientos disponibles.");
        }
    }

    public static void comprarHotel(Cliente cliente, Hoteles hotel) {
        if(hotel.getHabitacionesDisponibles() > 0) {
            hotel.reservarHabitacion();

            Movimiento movimiento = new Movimiento(hotel.getPrecio(), "Compra de Hotel: "+ hotel.getNombre());
            cliente.agregarMovimiento(movimiento);
            
            System.out.println("El hotel ha sido comprado exitosamente.");
        } else {
            System.out.println("El hotel no tiene habitaciones disponibles.");
        }
    }

    public static void comprarPaquete(Cliente cliente, Paquetes paquete) {
        Vuelo vuelo = paquete.getVuelo();
        Hoteles hotel = paquete.getHotel();

        if (vuelo.getDisponibilidad() > 0 && hotel.getHabitacionesDisponibles() > 0) {
            vuelo.reservarAsiento(null);
            hotel.reservarHabitacion();
            cliente.realizarPago(paquete.getPrecioTotal());

            
            Ticket ticket = new Ticket(contadorTickets++, cliente, vuelo.getNumVuelo(), LocalDateTime.now(), vuelo.getDestino());
            cliente.agregarTicket(ticket);

            Movimiento movimiento = new Movimiento(paquete.getPrecioTotal(), "Compra de Paquete (Vuelo + Hotel)");
            cliente.agregarMovimiento(movimiento);

            System.out.println("El paquete ha sido comprado exitosamente.");
        } else {
            System.out.println("El paquete no está disponible (verifica vuelo o hotel).");
        }
    }
}
