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

    //constructor
    public Usuario(String nombreUsuario, String contraseña) {
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
    }

    @Override
    public abstract boolean validarContraseña(String contraseña);

    @Override
    public abstract void recuperarContraseña();
    
}
