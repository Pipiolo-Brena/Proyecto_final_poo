package Menu;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

import Empresa.Aerovuelos;
import Usuarios.*;

/**
 * Clase que define y gestiona las operaciones del menú del sistema.
 * 
 * @author Equipo 5
 * @version 2024.11.17
 */

public class GestionMenu {
    private static Scanner scanner = new Scanner(System.in);
    private static Aerovuelos compania = Aerovuelos.getInstancia( "Aeroviajes FI-UNAM",  "5543651234",  "Lunes-Sábado, 09:00-22:00 hrs"); // Ejemplo

    /** Opción 1 del menú */
    public static void iniciarSesion() {
        System.out.print("Ingrese su nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String contraseña = scanner.nextLine();
        if(compania.verificarUsuario(nombreUsuario, contraseña)) {
            Usuario usuario = compania.getUsuario(contraseña);
            if(usuario instanceof Cliente) {
                Cliente cliente = (Cliente) usuario;
                espacios();
                menuCliente(cliente);
            } else {
                Administrador administrador = (Administrador) usuario;
                espacios();
                menuAdministrador(administrador);
            }
        } else {
            System.out.println("Usuario o contraseña incorrectas.");
        }
    }

    /** Opción 2 del menú */
    public static void registrarse() {
        System.out.println("Registrarse como cliente o como administrador? (c/a)");
        char opcion = scanner.next().charAt(0);
        scanner.nextLine();

        switch (opcion) {
            case 'c', 'C' -> {
                String nombreUsuario = ingresarNombreUsuario();
                System.out.print("Ingrese su contraseña: ");
                String contraseña = scanner.nextLine();
                System.out.print("Ingrese su nombre: ");
                String nombre = scanner.nextLine();
                System.out.print("Ingrese su apellido: ");
                String apellido = scanner.nextLine();
                System.out.println("Métodos de pago disponible:\n\t1.- Tarjeta de crédito\n\t2.- Tarjeta de débito\n\t3.- Pago en OXXO\nIngrese una opción: ");
                int numMetodo = scanner.nextInt();
                scanner.nextLine();
                String formaDePago;
                switch (numMetodo) {
                    case 1 -> formaDePago = "TARJETA_CREDITO";
                    case 2 -> formaDePago = "TARJETA_DEBITO";
                    case 3 -> formaDePago = "OXXO";
                    default -> formaDePago = null;
                }

                compania.registrarUsuario("Cliente", nombreUsuario, contraseña, nombre, apellido, formaDePago);
                espacios();
                menuCliente((Cliente)compania.buscarCliente(nombreUsuario));
            }
            case 'a', 'A' -> {
                System.out.println("Ingresa la palabra clave de seguridad");
                String clave=scanner.nextLine();
                if (!("20VCM19".equals(clave))){
                    System.out.println("Clave incorrecta\n");
                    return;
                }
                String nombreUsuario = ingresarNombreUsuario();
                System.out.print("Ingrese su contraseña: ");
                String contraseña = scanner.nextLine();
                System.out.print("Ingrese su nombre: ");
                String nombre = scanner.nextLine();
                System.out.print("Ingrese su apellido: ");
                String apellido = scanner.nextLine();
                
                compania.registrarUsuario("Administrador", nombreUsuario, contraseña, nombre, apellido, null);
                espacios();
                menuAdministrador((Administrador)compania.buscarCliente(nombreUsuario));
            }
        }
    }

    private static String ingresarNombreUsuario() {
        String nombreUsuario = null;
        boolean valido = false;
        while(!valido) {
            System.out.print("Ingresa tu nombre de usuario: ");
            nombreUsuario = scanner.nextLine();
            if(compania.buscarCliente(nombreUsuario) != null) {
                System.out.println("El nombre de usuario ingresado ya existe. Intento con otro.");
            } else {
                valido = true;
            }
        }
        return nombreUsuario;
    }

    /** Método auxiliares */
    // ===================
    // Menú cliente
    // ===================
    private static void menuCliente(Cliente cliente) {
        int opcion = -1;
        do {
            System.out.println("1. Ver vuelos disponibles");
            System.out.println("2. Ver hoteles disponibles");
            System.out.println("3. Comprar vuelo");
            System.out.println("4. Comprar hotel");
            System.out.println("5. Comprar paquete de vuelo + hotel");

            System.out.println("6. Salir");
            try {
                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();
                espacios();
            } catch(InputMismatchException e) {
                System.out.println("Error: Entrada de datos inválida.");
                scanner.nextLine();
                espacios();
            }
            switch (opcion) {
                case 1 -> compania.verVuelos();
                case 2 -> compania.verHoteles();
                case 3 -> comprarVuelo(cliente);
                case 4 -> reservarHotel(cliente);
                case 5 -> comprarPaquete(cliente);
                case 6 -> System.out.println("Gracias por usar el sistema de reservas. ¡Hasta pronto!");
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while(opcion != 6);
    }

    private static void comprarVuelo(Cliente cliente) {
        compania.verVuelos();
        System.out.println("Ingrese el número de vuelo que desea comprar:");
        String numVuelo = scanner.nextLine();
        System.out.println("Ingrese el asiento que desea comprar:");
        String numeroAsiento = scanner.nextLine();
        compania.comprarVuelo(cliente, numVuelo, numeroAsiento);
    }

    private static void reservarHotel(Cliente cliente) {
        compania.verHoteles();
        System.out.println("Ingrese el nombre del hotel que desea comprar:");
        String nombreHotel = scanner.nextLine();
        compania.reservarHotel(cliente, nombreHotel);
    }

    private static void comprarPaquete(Cliente cliente) {
        compania.verVuelos();
        compania.verHoteles();
        System.out.println("Ingrese el número de vuelo que desea comprar como paquete:");
        String numVuelo = scanner.nextLine();
        System.out.println("Ingrese la ubicación del hotel que desea comprar como paquete:");
        String nombreHotel = scanner.nextLine();
        compania.comprarPaquete(cliente, numVuelo, nombreHotel);

    }

    // ===================
    // Menú administrador
    // ===================
    private static void menuAdministrador(Administrador administrador) {
        int opcion = -1;
        do {
            System.out.println("1. Gestionar vuelos");
            System.out.println("2. Gestionar hoteles");
            System.out.println("3. Gestionar clientes");
            System.out.println("4. Salir");
            try {
                System.out.print("Selecione una opción: ");
                opcion = scanner.nextInt();
                espacios();
            } catch(InputMismatchException e) {
                System.out.println("Error: Entrada de datos inválida.");
                scanner.nextLine();
                espacios();
            }
            switch(opcion) {
                case 1 -> menuGestionVuelos();
                case 2 -> menuGestionHoteles();
                case 3 -> menuGestionClientes();
                case 4 -> System.out.println("Saliendo del sistema como administrador.");
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while(opcion != 4);
    }

    private static void menuGestionVuelos() {
        int opcion = -1;
        do {
            System.out.println("1. Agregar vuelo");
            System.out.println("2. Eliminar vuelo");
            System.out.println("3. Ver vuelos");
            System.out.println("4. Salir");
            try {
                System.out.print("Selecione una opción: ");
                opcion = scanner.nextInt();
                espacios();
            } catch(InputMismatchException e) {
                System.out.println("Error: Entrada de datos inválida.");
                scanner.nextLine();
                espacios();
            }
            switch (opcion) {
                case 1 -> agregarVuelo();
                case 2 -> compania.eliminarVuelo();
                case 3 -> compania.verVuelos();
                case 4 -> System.out.println("Saliendo de la gestión de vuelos.");
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while(opcion != 4);
    }

    private static void agregarVuelo() {
        System.out.print("Ingrese la aerolínea: ");
        String aerolinea = scanner.nextLine();
        System.out.print("Ingrese el número de vuelo: ");
        String numVuelo = scanner.nextLine();
        System.out.print("Ingrese el origen: ");
        String origen = scanner.nextLine();
        System.out.print("Ingrese el destino: ");
        String destino = scanner.nextLine();
        System.out.print("Ingrese la fecha y hora de salida (formato yyyy-MM-dd HH:mm): ");
        String fechaSalidaStr = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime fechaSalida = LocalDateTime.parse(fechaSalidaStr, formatter);
        System.out.print("Ingrese el precio base del vuelo: ");
        double precio = scanner.nextDouble();
        System.out.print("Ingrese la cantidad de escalas: ");
        int escalas = scanner.nextInt();
        System.out.print("¿Es vuelo nacional? (true/false): ");
        boolean vueloNacional = scanner.nextBoolean();
        System.out.print("¿Requiere visa? (true/false): ");
        boolean requiereVisa = scanner.nextBoolean();

        compania.añadirVuelo((vueloNacional ? "Nacional" : "Internacional"), aerolinea, numVuelo, origen, destino, fechaSalida, precio, escalas, escalas, vueloNacional, requiereVisa);
    }

    private static void menuGestionHoteles() {
        int opcion = -1;
        do {
            System.out.println("1. Agregar hotel");
            System.out.println("2. Elminar hotel");
            System.out.println("3. Ver hoteles");
            System.out.println("4. Salir");
            try {
                System.out.print("Selecione una opción: ");
                opcion = scanner.nextInt();
                espacios();
            } catch(InputMismatchException e) {
                System.out.println("Error: Entrada de datos inválida.");
                scanner.nextLine();
                espacios();
            }
            switch (opcion) {
                case 1 -> agregarHotel();
                case 2 -> compania.eliminarHotel();
                case 3 -> compania.verHoteles();
                case 4 -> System.out.println("Saliendo de la gestión de hoteles.");
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while(opcion != 4);
    }

    private static void agregarHotel() {
        System.out.print("Ingrese el nombre del hotel: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la ubicación del hotel: ");
        String ubicacion = scanner.nextLine();
        System.out.print("Ingrese el precio por noche: ");
        double precio = scanner.nextDouble();
        System.out.print("Ingrese la cantidad de habitaciones disponibles: ");
        int habitacionesDisponibles = scanner.nextInt();

        compania.añadirHotel(nombre, ubicacion, precio, habitacionesDisponibles);
    }

    private static void menuGestionClientes() {
        int opcion = -1;
        do {
            System.out.println("1. Ver clientes registrados");
            System.out.println("2. Buscar cliente");
            System.out.println("3. Eliminar cliente");
            System.out.println("4. Salir");
            try {
                System.out.print("Selecione una opción: ");
                opcion = scanner.nextInt();
                
            } catch(InputMismatchException e) {
                System.out.println("Error: Entrada de datos inválida.");
                scanner.nextLine();
            }
            switch (opcion) {
                case 1 -> {
                    compania.verUsuarios();
                    espacios();
                }
                case 2 -> {
                    System.out.println("Ingrese el número de usuario del cliente:");
                    String numUsuario = scanner.nextLine();
                    compania.buscarCliente(numUsuario);
                    espacios();
                }
                case 3 -> {
                    System.out.println("Ingrese el número de usuario del cliente:");
                    String numUsuario = scanner.nextLine();
                    compania.eliminarCliente(numUsuario);
                    espacios();
                }
                case 4 -> System.out.println("Saliendo de la gestión de hoteles.");
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while(opcion != 4);
    }

    private static void espacios(){
        for(int i=0;i>5;i++){
            System.out.println("");
        }
    }
}

