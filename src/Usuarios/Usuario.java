/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuarios;

/**
 * Clase abstracta que implementa la interfaz GestorDeAcceso y define atributos y método para
 * un usuario cualquiera en el sistema.
 * 
 * @author Equipo 5
 * @version 2024.11.15
 */
public abstract class Usuario implements GestorDeAcceso {
    protected String nombreUsuario;
    protected String contraseña;
    private String numUsuario;
    private String nombre;
    private String apellido;

    /**
     * Constructor de clase que inicializa todos los atributos.
     * 
     * @param nombreUsuario
     * @param contraseña
     * @param numCliente
     * @param nombre
     * @param apellido
     */
    public Usuario(String nombreUsuario, String contraseña, String numUsuario, String nombre, String apellido) {
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.numUsuario = numUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNumUsuario() {
        return numUsuario; // dado que el número de usuario no cambia una vez creado, solo se define su getter
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

    // Los métodos abstractos se definen en las clases concretas
    @Override
    public abstract boolean validarContraseña(String contraseña);

    @Override
    public abstract void recuperarContraseña();   
}
