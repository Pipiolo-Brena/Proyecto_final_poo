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
    
    //constructor
    public Adminstrador(String nombreUsuario, String contraseña, String nombre, String apellido, int numEmpleado) {
        super(nombreUsuario, contraseña);
        this.nombre = nombre;
        this.apellido = apellido;
        this.numEmpleado = numEmpleado;
    }

    @Override
    public boolean validarContraseña(String contraseña) {
        return this.contraseña.equals(contraseña);
    }

    @Override
    public void recuperarContraseña() {
        
    }

    public void verInformacionClientes() {
        
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
