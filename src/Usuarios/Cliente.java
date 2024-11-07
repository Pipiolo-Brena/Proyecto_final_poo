/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuarios;
import java.util.ArrayList;
import java.util.List;
import Pagos.MetodosPago;
import Sistema.GestionReservas;
import Sistema.Ticket;
import Vuelos.Vuelo;

/**
 *
 * @author
 */
public class Cliente extends Usuario {
    private String nombre;
    private String apellido;
    private List<Vuelo> baseVuelos; //vuelos disponibles
    private List<Ticket> ticketsGenerados; //ticket
    private MetodosPago formaDePago; //pagos Linea o efectivo
    private GestionReservas baseReservas;//reservas

    //constructor
    public Cliente(String nombreUsuario, String contraseña, String nombre, String apellido, GestionReservas baseReservas) {
        super(nombreUsuario, contraseña);
        this.nombre = nombre;
        this.apellido = apellido;
        this.vuelosComprados = new ArrayList<>();
        this.ticketsGenerados = new ArrayList<>();
        
    }

    

    @Override
    public boolean validarContraseña(String contraseña) {
        return this.contraseña.equals(contraseña);
    }

    @Override
    public void recuperarContraseña() {
        
    }

    public void descargarTicket() {
        
    }

    public void verVuelosDisponibles() {
        baseVuelos.mostrarVuelos();
    }

    public void comprarVuelo(Vuelo vuelo) {
        
    }

    @Override
    public String toString() {
        return "Cliente: " + nombre + " " + apellido;
    }
    

    //getters setters
    public String getNombreUsuario() {
        return nombreUsuario;
    }


    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }


    public void setApellido(String apellido) {
        this.apellido = apellido;
    }


}
