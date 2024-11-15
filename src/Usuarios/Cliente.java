/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuarios;
import java.util.ArrayList;
import java.util.List;
import Pagos.MetodosPago;
import Pagos.PagosEfectivo;
import Pagos.PagosLinea;
import Sistema.GestionReservas;
import Vuelos.Vuelo;
import Usuarios.Datos.Movimiento;
import Usuarios.Datos.Ticket;

/**
 *
 * @author
 */
public class Cliente extends Usuario {
    private final String EFECTIVO="efectivo";
    private List<Vuelo> baseVuelos; //vuelos suscritos
    private List<Ticket> ticketsGenerados; //ticket
    private List<Movimiento> movimientos;
    private MetodosPago formaDePago; //pagos Linea o efectivo
    private GestionReservas baseReservas;//reservas

    //constructor
    public Cliente(String numCliente,String nombreUsuario, String contraseña, String nombre, String apellido, String formaDePago) {
        super(numCliente,nombre,apellido,nombreUsuario, contraseña);
        this.formaDePago=setFormaDePago(formaDePago);
        this.ticketsGenerados = new ArrayList<>();   
    }

    public void AgregaVuelo(Vuelo vuelo){
        baseVuelos.add(vuelo);
    }

    public MetodosPago setFormaDePago(String formaDePago) {
        MetodosPago metodo;
        if(formaDePago==EFECTIVO){
            metodo = new PagosEfectivo();
        }else{
            metodo= new PagosLinea();
        }
        return metodo;
    }

    public Vuelo getVuelo(int numeroVuelo) {
        return baseVuelos.get(numeroVuelo);
    }

    public void AgregaTicket(Ticket vuelo){
        ticketsGenerados.add(vuelo);
    }

    public Ticket getTicket(int numeroVuelo) {
        return ticketsGenerados.get(numeroVuelo);
    }

    public void AgregarMovimiento(Movimiento vuelo){
        movimientos.add(vuelo);
    }

    public void verMovimientos() {
        for (Movimiento movimiento : movimientos) {
            System.out.println(movimiento);
        }
    }

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
        Ticket ticket= getTicket(0);
    }

    @Override
    public boolean validarContraseña(String contraseña) {
        return this.contraseña.equals(contraseña);
    }

    @Override
    public void recuperarContraseña() {
        
    }
}
