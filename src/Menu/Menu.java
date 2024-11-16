/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menu;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import Empresa.Aerovuelos;
import Usuarios.Adminstrador;
import Usuarios.Cliente;

/**
 *
 * @author PC
 */
public class Menu {
    private Scanner scanner = new Scanner(System.in);
    //Implementacion de facade
    public Aerovuelos Compania= Aerovuelos.getInstancia( null,  null,  null);

    public void mostrarMenuPrincipal() {
        int opcion = -1;
        System.out.println("Bienvenido al Sistema de Reservas de Vuelos y Hoteles");
        System.out.println("1. Iniciar Sesión como Cliente");
        System.out.println("2. Iniciar Sesión como Administrador");
        System.out.println("3. Salir");
        try {
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
        } catch(InputMismatchException e) {
            System.out.println("Error: Entrada inválida. Por favor, ingrese un número.");
            scanner.nextLine();
        }
        switch (opcion) {
            case 1 -> iniciarSesionCliente();
            case 2 -> iniciarSesionAdministrador();
            case 3 -> System.out.println("Gracias por usar el sistema.");
            default -> System.out.println("Opción inválida.");
        }
    }

    private void iniciarSesionCliente() {
        try {
            System.out.print("Ingrese su nombre de usuario: ");
            String nombreUsuario = scanner.next();
            System.out.print("Ingrese su contraseña: ");
            String contraseña = scanner.next();
            Cliente cliente = new Cliente(nombreUsuario, contraseña, "Nombre", "Apellido"); //datos cliente
            if (cliente.validarContraseña(contraseña)) {
                mostrarMenuCliente(cliente);
            } else {
                System.out.println("Contraseña incorrecta.");
            }
        } catch(InputMistmatchException e) {
            System.out.println("Error: Entrada de datos inválida para iniciar sesión como cliente.");
            scanner.nextLine();
        }
    }

    private void iniciarSesionAdministrador() {
        try {
            Random numAleatorio = new Randon();
            System.out.print("Ingrese su nombre de usuario: ");
            String nombreUsuario = scanner.next();
            System.out.print("Ingrese su contraseña: ");
            String contraseña = scanner.next();
    
            int numEmpleado = 1000 + numAleatorio.nextInt(2001);
            Adminstrador admin = new Adminstrador(nombreUsuario, contraseña, "Nombre", "Apellido", numEmpleado); //datos administrador
            if (admin.validarContraseña(contraseña)) {
                mostrarMenuAdministrador(admin);
            } else {
                System.out.println("Contraseña incorrecta.");
            }
        } catch(InputMistmatchException e) {
            System.out.println("Error: Entrada de datos inválida para iniciar sesión como cliente.");
            scanner.nextLine();
        }
    }

    private void mostrarMenuCliente(Cliente cliente) {
        int opcion = -1;
        do {
            try {
                System.out.println("1. Ver Vuelos Disponibles");
                System.out.println("2. Ver Hoteles Disponibles");
                System.out.println("3. Ver paquetes");
                System.out.println("4. Comprar Vuelo");
                System.out.println("5. Comprar paquete de vuelo + hotel");
                System.out.println("6. Realizar pago en Oxxo");
                System.out.println("7. Realizar pago con tarjeta");
                System.out.println("8. Salir");
                opcion = scanner.nextInt();
    
                switch (opcion) {
                    case 1:
                        verVuelosDisponibles();
                        break;
                    case 2:
                        verHotelesDisponibles();
                        break;
                    case 3:
                        comprarVuelo();
                        break;
                    case 4:
                        reservarHotel();
                        break;
                    case 5:
                        comprarPaquete();
                        break;
                    case 6:
                        realizarPagoEnOxxo();
                        public boolean realizarPagoEnOxxo() {};
                        break;
                    case 7:
                        realizarPagoTarjeta();
                        break;
                    case 8:
                        System.out.println("Gracias por usar el sistema de reservas. ¡Hasta pronto!");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch(InputMismatchException e) {
                System.out.println("Error: Entrada de datos inválida para iniciar sesión como cliente.");
                scanner.nextLine();
            }
        } while (opcion != 8);
        
    }

    //métodos del menú
    private void verVuelosDisponibles() {
        //codigo para mostrar vuelos disponibles
        System.out.println("Mostrando vuelos disponibles...");
    }

    private void verHotelesDisponibles() {
        //codigo para mostrar hoteles disponibles
        System.out.println("Mostrando hoteles disponibles...");
    }

    private void comprarVuelo() {
        //cdigo para comprar un vuelo
        System.out.println("Compra de vuelo seleccionada.");
    }

    private void reservarHotel() {
        //codigo para reservar un hotel
        System.out.println("Reserva de hotel seleccionada.");
    }

    private void comprarPaquete() {
        //comprar un paquete vuelo + hotel
        System.out.println("Compra de paquete vuelo + hotel seleccionada.");
    }

    private void mostrarMenuAdministrador(Adminstrador admin) {
        System.out.println("1. Gestionar Vuelos");
        System.out.println("2. Gestionar Hoteles");
        System.out.println("3. Gestionar Clientes");
        System.out.println("4. Ver Reportes");
        System.out.println("5. Salir");
        
    }
    
}
