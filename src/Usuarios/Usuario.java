/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuarios;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Random;

/**
 * Clase abstracta que implementa la interfaz GestorDeAcceso y define atributos y método para
 * un usuario cualquiera en el sistema.
 * 
 * @author Equipo 5
 * @version 2024.11.15
 */
public abstract class Usuario implements GestorDeAcceso, Serializable {
    private static final long serialVersionUID = 1L;
    protected String nombreUsuario;
    protected String contraseña;
    private String nombre;
    private String apellido;
    private String token;

    public Usuario(String nombreUsuario, String contraseña, String nombre, String apellido) {
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    // Getters y setters para el resto de atributos
    public String getContraseña() {
        return contraseña;
    }
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

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

    private String hashContraseña(String contraseña) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(contraseña.getBytes());
            return Base64.getEncoder().encodeToString(hashedBytes); // Convierte el hash en Base64
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error al crear el hash de la contraseña", e);
        }
    }

    private int generarCodigoVerificacion() {
        Random random = new Random();
        int codigo = 100000 + random.nextInt(900000); // Genera un número entre 100000 y 999999
        return codigo;
    }

    public void enviarCodigo(String correoUsuario) {
        int codigo = generarCodigoVerificacion();
        this.token =String.valueOf(codigo);
        System.out.println("Enviando código de verificación " + token + " al correo: " + correoUsuario);
    } // Modifiqué este método para implementar generarCodigoVerificacion()

    // Los métodos abstractos se definen en las clases concretas
    @Override
    public boolean validarContraseña(String contraseña) {
        return this.contraseña.equals(contraseña);
    }

    public boolean verificarCodigo(String codigoIngresado) {
        if (token.equals(codigoIngresado)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void recuperarContraseña(String nuevaContraseña){
        this.contraseña = nuevaContraseña;
    }   

    @Override

    public String toString() {
        return contraseña;
    }
}
