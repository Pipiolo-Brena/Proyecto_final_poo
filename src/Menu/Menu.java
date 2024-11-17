/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menu;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase que implementa el menú del sistema de aeroviajes.
 * 
 * @author Equipo 5
 * @version 2024.11.17
 */

public class Menu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("Bienvenido al Sistema de Reservas de Vuelos y Hoteles.");
            System.out.println("1.- Iniciar sesión");
            System.out.println("2.- Registrarse");
            System.out.println("3.- Salir");
            try {
                System.out.println("Seleccione una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine();
            } catch(InputMismatchException e) {
                System.out.println("Error: Entrada inválida. Por favor ingrese un número válido.");
                opcion = -1;
                scanner.nextLine();
            }
            switch (opcion) {
                case 1 -> GestionMenu.iniciarSesion();
                case 2 -> GestionMenu.registrarse();
                case 3 -> System.out.println("Gracias por usar el sistema.");
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }   
        } while(opcion != 3);
        scanner.close();
    }
}
