package Sistema;

import java.time.LocalDate;
import java.util.Random;

import Usuarios.Cliente;
import Vuelos.Vuelo;



public class Reserva {
    
    private String idCliente;
    private String idVuelo;
    private String idHotel;
    private String idPaquete;
    private String tipoReserva; //"Vuelo", "Hotel" o "Paquete"
    private LocalDate fechaReserva;
    private double costoTotal;

    // Constructor para una reserva de vuelo
    public Reserva(Cliente cliente, Vuelo vuelo) {
        this.idCliente = generarId();
        this.idVuelo = generarId();
        this.tipoReserva = "Vuelo";
        this.fechaReserva = LocalDate.now();;
        this.costoTotal = vuelo;
    }

    // Constructor para una reserva de hotel
    public Reserva(LocalDate fechaReserva, double costoHotel, boolean esHotel) {
        this.idCliente = generarId();
        this.idHotel = generarId();
        this.tipoReserva = "Hotel";
        this.fechaReserva = fechaReserva;
        this.costoTotal = costoHotel;
    }

    // Constructor para una reserva de paquete (hotel + vuelo)
    public Reserva(LocalDate fechaReserva, double costoVuelo, double costoHotel) {
        this.idCliente = generarId();
        this.idVuelo = generarId();
        this.idHotel = generarId();
        this.idPaquete = generarId();
        this.tipoReserva = "Paquete";
        this.fechaReserva = fechaReserva;
        this.costoTotal = costoVuelo + costoHotel;
    }

    // Método para generar un ID de 4 dígitos
    private String generarId() {
        Random rand = new Random();
        int id = rand.nextInt(9000) + 1000; // Genera un número entre 1000 y 9999
        return String.valueOf(id);
    }

    // Getters y Setters para los atributos
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

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    // Método para mostrar los detalles de la reserva
    public void mostrarDetalles() {
        System.out.println("ID Cliente: " + idCliente);
        System.out.println("Fecha de Reserva: " + fechaReserva);
        System.out.println("Tipo de Reserva: " + tipoReserva);
        if (tipoReserva.equals("Vuelo")) {
            System.out.println("ID Vuelo: " + idVuelo);
        } else if (tipoReserva.equals("Hotel")) {
            System.out.println("ID Hotel: " + idHotel);
        } else if (tipoReserva.equals("Paquete")) {
            System.out.println("ID Vuelo: " + idVuelo);
            System.out.println("ID Hotel: " + idHotel);
            System.out.println("ID Paquete: " + idPaquete);
        }
        System.out.println("Costo Total: $" + costoTotal);
    }
}
