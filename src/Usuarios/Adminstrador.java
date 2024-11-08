/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuarios;

import java.util.ArrayList;
import java.util.List;

import Sistema.GestionReservas;
import Vuelos.Vuelo;

/**
 *
 * @author PC
 */
public class Adminstrador extends Usuario {
    private String nombre;
    private String apellido;
    private int numEmpleado;
    private List<Cliente> listaClientes;//registro clientes
    private List<Vuelo> baseVuelos; //vuelos disponibles
    
    //constructor
    public Administrador(String nombreUsuario, String contraseña, String nombre, String apellido, int numEmpleado) {
        super(nombreUsuario, contraseña);
        this.nombre = nombre;
        this.apellido = apellido;
        this.numEmpleado = numEmpleado;
        this.listaClientes = new ArrayList<>();
        
    }

    @Override
    public boolean validarContraseña(String contraseña) {
        return this.contraseña.equals(contraseña);
    }

    @Override
    public void recuperarContraseña() {
        
    }

    public void verVuelosDisponibles() {
        baseVuelos.mostrarVuelos();
    }

    public void agregarVuelos(Vuelo vuelo) {
        baseVuelos.registrarVuelo(vuelo);
    }

    public void eliminarVuelos(String numVuelo) {
        baseVuelos.eliminarVuelo(numVuelo);
    }

    public void verInformacionClientes() {
        
    }

    public void eliminarCliente(Cliente cliente) {
        listaClientes.remove(cliente);
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

    public int getNumEmpleado() {
        return numEmpleado;
    }


    public void setNumEmpleado(int numEmpleado) {
        this.numEmpleado = numEmpleado;
    }

}
