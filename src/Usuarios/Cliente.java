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
    private List<Vuelo> baseVuelos; //vuelos suscritos
    private List<Ticket> ticketsGenerados; //ticket
    private MetodosPago formaDePago; //pagos Linea o efectivo
    private GestionReservas baseReservas;//reservas

    //constructor
    public Cliente(String numCliente,String nombreUsuario, String contraseña, String nombre, String apellido, MetodosPago formaDePago) {
        super(numCliente,nombre,apellido,nombreUsuario, contraseña);
        this.formaDePago=formaDePago;
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


    public void comprarVuelo(Vuelo vuelo) {
        
    }   

    //getters setters
    public String getNombreUsuario() {
        return nombreUsuario;
    }


    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

}
