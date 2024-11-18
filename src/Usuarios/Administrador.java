/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuarios;

/**
 *
 * @author PC
 */
public class Administrador extends Usuario {
    private static final long serialVersionUID = 1L;
    private String nombre;
    private String apellido;
    
    //constructor
    public Administrador(String nombreUsuario, String contraseña, String nombre, String apellido) {
        super(nombreUsuario,  contraseña,nombre, apellido);
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @Override
    public boolean validarContraseña(String contraseña) {
        return this.contraseña.equals(contraseña);
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
}
