package Sistema;

import java.time.LocalDate;
import java.util.Random;

import Usuarios.Cliente;
import Vuelos.Vuelo;
import Extras.Hoteles;
import Extras.Paquetes;

/**
 * Representa una reserva en el sistema.
 * 
 * @author Equipo 5
 * @version 2024.11.17
 */

public class Reserva {
    private String idVuelo; // identificador de vuelo
    private String idHotel; // identificador de hotel
    private String idPaquete; // identificador de paquete
    private String idCliente;
    private String tipoReserva; //"Vuelo", "Hotel" o "Paquete"
    private Vuelo vuelo;
    private Hoteles hotel;
    private Paquetes paquete;
    private LocalDate fechaReserva;
    private double costoTotal;

    /** Constructor para la reserva de un vuelo. */
    public Reserva(Cliente cliente, Vuelo vuelo) {
        this.idCliente = generarId();
        this.idVuelo= generarId();
        this.tipoReserva = "Vuelo";
        this.vuelo = vuelo;
        this.fechaReserva = LocalDate.now();
        this.costoTotal = vuelo.getPrecio();
    }

    /** Constructor para la reserva de un hotel. */
    public Reserva(Cliente cliente, Hoteles hotel, LocalDate fechaReserva) {
        this.idCliente = generarId();
        this.idHotel = generarId();
        this.tipoReserva = "Hotel";
        this.hotel = hotel;
        this.fechaReserva = fechaReserva;
        this.costoTotal = hotel.getPrecio();
    }

    /** Constructor para la reserva de un paquete (hotel + vuelo). */ 
    public Reserva(Cliente cliente, Paquetes paquete, LocalDate fechaReserva) {
        this.idCliente = generarId();
        this.idVuelo = generarId();
        this.idHotel = generarId();
        this.idPaquete = generarId();
        this.tipoReserva = "Paquete";
        this.paquete = paquete;
        this.fechaReserva = fechaReserva;
        this.costoTotal = paquete.getPrecioTotal();
    }

    /** Método para generar un ID de 4 dígitos. */ 
    private String generarId() {
        Random rand = new Random();
        int id = rand.nextInt(9000) + 1000; // Genera un número entre 1000 y 9999
        return String.valueOf(id);
    }

    // Getters
    /** Se definen getters para todos los atributos. */
    public String getIdCliente() {
        return idCliente;
    }

    public String getIdVuelo() {
        return idVuelo;
    }

    public String getIdHotel() {
        return idHotel;
    }

    public String getIdPaquete() {
        return idPaquete;
    }

    public String getTipoReserva() {
        return tipoReserva;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public Hoteles getHotel() {
        return hotel;
    }

    public Paquetes getPaquete() {
        return paquete;
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    /** Método para mostrar los detalles de la reserva. */
    public void mostrarDetalles() {
        System.out.println("ID Cliente: " + idCliente);
        System.out.println("Fecha de Reserva: " + fechaReserva);
        System.out.println("Tipo de Reserva: " + tipoReserva);
        switch (tipoReserva) {
            case "Vuelo":
                System.out.println("ID Vuelo: "+ idVuelo);
                System.out.println("Vuelo: "+ vuelo);
                break;
            case "Hotel":
                System.out.println("ID Hotel:"+ idHotel);
                System.out.println("Hotel: "+ hotel);
                break;
            case "Paquete":
                System.out.println("ID Paquete:"+ idPaquete);
                System.out.println("ID Vuelo: "+ idVuelo);
                System.out.println("ID Hotel:"+ idHotel);
                System.out.println("Paquete: "+ paquete);
                break;
            default:
                break;
        }
        System.out.println("Costo Total: $" + costoTotal);
    }
}
