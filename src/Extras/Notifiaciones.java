/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Extras;

/**
 *
 * @author PC
 */
public class Notifiaciones {//Clase de Notificaciones usando Patrón de Diseño Singleton
    /*private static Notificaciones instancia;

    private Notificaciones() { }

    public static Notificaciones obtenerInstancia() {
        if (instancia == null) {
            instancia = new Notificaciones();
        }
        return instancia;
    }*/

    public void enviarEmail(String email, String mensaje) {
        System.out.println("Enviando correo a " + email + ": " + mensaje);
    }

    public void enviarSms(String telefono, String mensaje) {
        System.out.println("Enviando SMS a " + telefono + ": " + mensaje);
    }
}
