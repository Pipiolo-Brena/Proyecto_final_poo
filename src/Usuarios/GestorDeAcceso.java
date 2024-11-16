/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Usuarios;

/**
 * Interfaz que establece métodos para garantizar la seguridad al iniciar sesión en el sistema.
 * 
 * @author Equipo 5
 * @version 2024.11.15
 */
public interface GestorDeAcceso {

    /**
     * Método abstracto que comprueba si la contraseña ingresada es correcta.
     * 
     * @param contraseña
     * @return true/false
     */
    boolean validarContraseña(String contraseña);

    /**
     * Método abstracto que permite recuperar la contraseña.
     */
    void recuperarContraseña();
}
