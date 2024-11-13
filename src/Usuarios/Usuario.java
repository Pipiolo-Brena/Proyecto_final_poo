/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuarios;
import Usuarios.GestorDeAcceso;

/**
 *
 * @author
 */
public abstract class Usuario implements GestorDeAcceso {
    protected String nombreUsuario;
    protected String contraseña;
    private String numCliente;
    private String nombre;
    private String apellido;

    //constructor
    public Usuario(String numCliente, String nombre, String apellido ,String nombreUsuario, String contraseña) {
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.numCliente= numCliente;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNumCliente() {
        return numCliente;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    @Override
    public abstract boolean validarContraseña(String contraseña);

    @Override
    public abstract void recuperarContraseña();
    
}
