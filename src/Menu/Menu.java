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

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        mostrarMenu();
    }

    private static void mostrarMenu() {
        int opcion = -1;

        do {
            System.out.println("Bienvenido al sistema de reservas");
            System.out.println("Seleccione una opción:");
            System.out.println("1. Iniciar sesión");
            System.out.println("2. Registrarse");
            System.out.println("3. Salir");

            try {
                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer después de nextInt()

                switch (opcion) {
                    case 1 -> GestionMenu.iniciarSesion(scanner);
                    case 2 -> GestionMenu.registrarse(scanner);
                    case 3 -> System.out.println("Gracias por usar el sistema. ¡Hasta luego!");
                    default -> System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("Entrada no válida. Intente de nuevo.");
                scanner.nextLine(); // Limpiar el buffer en caso de error
            }
        } while (opcion != 3);
    }
}
