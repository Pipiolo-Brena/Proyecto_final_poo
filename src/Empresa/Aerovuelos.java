package Empresa;

import Usuarios.*;
import Extras.*;
import Vuelos.Vuelo;
import Sistema.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException; // Se debería de implementar esta excepción?
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.List;


/**
 * @author Equipo 5
 * @version 2024.11.17
 * Clase para la implementación de Facade y Singleton
 */
@SuppressWarnings("unused")
public class Aerovuelos implements Sujeto {
    public List<Observador> observadores;

    /** Atributos de clase */
    private String nombre;
    private String telefono;
    private String horario;

    /** Atributos estáticos para manejar archivos */
    private static HashMap<String, Usuario> baseUsuarios;
    private static ArrayList<Vuelo> baseVuelos;
    private static ArrayList<Hoteles> baseHoteles;

    /** Atributos de tipo final para manejar el nombre de los archivos */
    private final String ARCHIVO_USUARIOS = "usuarios.dat";
    private final String ARCHIVO_VUELOS = "vuelos.dat";
    private final String ARCHIVO_HOTELES = "hoteles.dat";

    private static Aerovuelos instancia; // Instancia Singleton

    public Aerovuelos(String nombre, String telefono, String horario) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.horario = horario;
        this.observadores = new ArrayList<>();
        baseUsuarios = leerUsuarios(); // Objetos Usuarios
        baseVuelos = leerVuelos(); // Objetos Vuelo
        baseHoteles = leerHoteles(); // Objetos Hoteles

    }

    /** Implementación del patrón de diseño Singleton */
    public static Aerovuelos getInstancia(String nombre, String telefono, String horario) {
        if (instancia == null) {
            instancia = new Aerovuelos(nombre, telefono, horario);
        }
        return instancia;
    }

    // Métodos de Subject para implementar el patrón de diseño Observer
    @Override
    public void agregarObservador(Observador observador) {
        observadores.add(observador);
    }

    @Override
    public void eliminarObservador(Observador observador) {
        observadores.add(observador);
    }

    @Override
    public void notificarObservadores(String mensaje) {
        for(Observador observador : observadores) {
            observador.actualizar(mensaje);
        }
    }

    // ========================
    // Gestión de Usuarios
    // ========================

    public void registrarUsuario(String tipo, String nombreUsuario, String contraseña, String nombre, String apellido, String formaDePago,Scanner scanner) {
        Usuario usuario = null; // Inicializamos en null para evitar referencias no asignadas
        if ("Cliente".equalsIgnoreCase(tipo)) {
            usuario = new Cliente(nombreUsuario, contraseña, nombre, apellido, formaDePago,scanner);
            agregarObservador((Cliente) usuario);
        } else if ("Administrador".equalsIgnoreCase(tipo)) {
            usuario = new Administrador(nombreUsuario, contraseña, nombre, apellido);
        } else {
            System.out.println("Tipo de usuario no reconocido.");
            return; // Salimos si el tipo no es válido
        }
    
        baseUsuarios.put(nombreUsuario, usuario);
        guardarUsuarios(baseUsuarios); // Serializa la información actualizada
        System.out.println("Registro exitoso.\n");
    }
    

    public boolean verificarUsuario(String nombreUsuario, String contraseña) {
        Usuario usuario = baseUsuarios.get(nombreUsuario);
        if (usuario != null) {
            return usuario.validarContraseña(contraseña);
        }
        return false;
    }

    public Usuario buscarCliente(String llave) {
        if(baseUsuarios.get(llave) instanceof Cliente) {
            return baseUsuarios.get(llave);
        } else {
            return null;
        }
    }

    public void eliminarCliente(String llave) {
        if (!hayUsuarios()) {
            return;
        }
        baseUsuarios.remove(llave);
        eliminarObservador((Cliente)buscarCliente(llave));
        guardarUsuarios(baseUsuarios);
    }

    public void verUsuarios() {
        if (!hayUsuarios()) {
            System.out.println("No hay usuarios registrados");
            return;
        }
        System.out.println("Lista de clientes:");
        int i = 1;
        for (Map.Entry<String, Usuario> scanner : baseUsuarios.entrySet()) {
            String numCliente = scanner.getKey();
            Usuario usuario = scanner.getValue();
            
                System.out.println("Índice: " + i + "  Número de Cliente: " + numCliente + "  " + usuario);
                i++;
            
        }
    } // No se muestran los administradores registrados en el sistema.

    // Verifica si hay usuarios registrados
    public static boolean hayUsuarios() {
        return baseUsuarios != null && !baseUsuarios.isEmpty();
    }


    // ========================
    // Gestión de Vuelos
    // ========================
    
    public void añadirVuelo(String tipo, String aerolinea, String numVuelo, String origen, String destino, LocalDateTime fechaSalida, double precio, int disponibilidad, int escalas, boolean vueloNacional, boolean requiereVisa) {
        Vuelo vuelo;
        if("Internacional".equalsIgnoreCase(tipo)) {
            vuelo = new Vuelo(aerolinea, numVuelo, origen, destino, fechaSalida, precio);
        } else if("Nacional".equalsIgnoreCase(tipo)) {
            vuelo = new Vuelo(aerolinea, numVuelo, origen, destino, fechaSalida, precio, escalas, vueloNacional, requiereVisa);
        } else {
            System.out.println("Tipo de usuario no reconocido.");
            return;
        }
        baseVuelos.add(vuelo);
        guardarVuelos(baseVuelos);
        System.out.println("Vuelo añadido exitosamente.\n");
        notificarObservadores("Se ha añadido un nuevo vuelo: " + numVuelo);
    }

    /** Método para ver todos los vuelos en el sistema */
    public void verVuelos() {
        if (!hayVuelos()) {
            System.out.println("No hay vuelos disponibles");
            return;
        }
        System.out.println("Lista de vuelos disponibles:");
        int i = 1;
        for (Vuelo vuelo : baseVuelos) {
            System.out.println("Vuelo " + i + ": " + vuelo);
            i++;
        }
    }

    // Método para eliminar un vuelo
    public void eliminarVuelo(Scanner scanner) {
        if (!hayVuelos()) {
            System.out.println("No hay vuelos disponibles");
            return;
        }
        verVuelos();
        System.out.println("A partir del índice, ¿Qué vuelo se quiere eliminar?");
        int num = scanner.nextInt();

        if (num < 1 || num > baseVuelos.size()) {
            System.out.println("Índice no válido.");
            return;
        }
        notificarObservadores("Se ha eliminado el vuelo: " + baseVuelos.get(num - 1).getNumVuelo());
        baseVuelos.remove(num - 1);
        guardarVuelos(baseVuelos);
        System.out.println("Vuelo eliminado exitosamente.");
        
    }

    public void comprarVuelo(Cliente cliente, String numVuelo, String numeroAsiento) {
        Vuelo vuelo = buscarVuelo(numVuelo);

        if(vuelo != null) {
            GestionCompras.comprarVuelo(cliente, vuelo, numeroAsiento);
        } else {
            System.out.println("El vuelo no está disponible o no existe.");
        }
    }

    private Vuelo buscarVuelo(String numVuelo) {
        for(Vuelo vuelo : baseVuelos) {
            if(vuelo.getNumVuelo().equals(numVuelo)) {
                return vuelo;
            }
        }
        return null;
    }

    public static boolean hayVuelos() {
        return baseVuelos != null && !baseVuelos.isEmpty();
    }

    // ====================
    // Gestión de Hoteles
    // ====================
    
    public void añadirHotel(String nombre, String ubicacion, double precio, int habitacionesDisponibles) {
        Hoteles hotel = new Hoteles(nombre, ubicacion, precio, habitacionesDisponibles);
        baseHoteles.add(hotel);
        guardarHoteles(baseHoteles); // Guardar cambios en el archivo
        System.out.println("Hotel añadido exitosamente.\n");
        notificarObservadores("Se ha añadido un nuevo hotel: "+ nombre);
    }

    public void verHoteles() {
        if (!hayHoteles()) {
            System.out.println("No hay hoteles disponibles");
            return;
        }
        System.out.println("Lista de hoteles disponibles:");
        int i = 1;
        for (Hoteles hotel : baseHoteles) {
            System.out.println("Hotel " + i + ": " + hotel);
            i++;
        }
    }

    public void eliminarHotel(Scanner scanner) {
        if (!hayHoteles()) {
            System.out.println("No hay hoteles disponibles");
            return;
        }
        verHoteles();
        System.out.println("A partir del índice, ¿Qué hotel se quiere eliminar?");
        int num = scanner.nextInt();

        if (num < 1 || num > baseHoteles.size()) {
            System.out.println("Índice no válido.");
            return;
        }

        notificarObservadores("Se ha eliminado el hotel: "+ baseHoteles.get(num - 1).getNombre());
        baseHoteles.remove(num - 1);
        guardarHoteles(baseHoteles); // Guardar cambios en el archivo
        System.out.println("Hotel eliminado exitosamente.");
    }

    public void reservarHotel(Cliente cliente, String nombreHotel) {
        if (!hayHoteles()) {
            System.out.println("No hay hoteles disponibles");
            return;
        }
        Hoteles hotel = buscarHotel(nombreHotel);

        if(hotel != null) {
            GestionCompras.comprarHotel(cliente, hotel);
        } else {
            System.out.println("El hotel no está disponible o no existe.");
        }
    }

    private Hoteles buscarHotel(String nombreHotel) {
        for(Hoteles hotel : baseHoteles) {
            if(hotel.getNombre().equalsIgnoreCase(nombreHotel)) {
                return hotel;
            }
        }
        return null;
    }

    public static boolean hayHoteles() {
        return baseHoteles != null && !baseHoteles.isEmpty();
    }

    // ====================
    // Compra de paquetes
    // ====================

    public void comprarPaquete(Cliente cliente, String numVuelo, String nombreHotel) {
        Vuelo vuelo = buscarVuelo(numVuelo);
        Hoteles hotel = buscarHotel(nombreHotel);

        if(vuelo != null && hotel != null) {
            Paquetes paquete = new Paquetes(vuelo, hotel);
            GestionCompras.comprarPaquete(cliente, paquete);
        } else {
        System.out.println("El paquete no está disponible (verifica vuelo o hotel).");
        }
    }

    // ====================
    // Manejo de archivos
    // ====================

    @SuppressWarnings("unchecked")
    private HashMap<String, Usuario> leerUsuarios() {
        HashMap<String, Usuario> usuarios = new HashMap<>();
        File archivoUsuarios = new File(ARCHIVO_USUARIOS);
        if (archivoUsuarios.exists()) {
            try (ObjectInputStream archivo = new ObjectInputStream(new FileInputStream(archivoUsuarios))) {
                HashMap<String, Usuario> datosLeidos = (HashMap<String, Usuario>) archivo.readObject();
                if (datosLeidos != null) {
                    for (Usuario usuario : datosLeidos.values()) {
                        // Verificar si el usuario es un Cliente antes de agregarlo como Observador
                        if (usuario instanceof Cliente) {
                            agregarObservador((Cliente) usuario); // Solo hacer cast si es Cliente
                        }
                        usuarios.put(usuario.getNombreUsuario(), usuario);
                    }
                }
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Error al leer el archivo de usuarios.");
            }
        } else {
            System.out.println("El archivo de usuarios no existe.");
        }
        return usuarios;
    } 

    public void agregarUsuario(String numCliente, Usuario cliente) {
        baseUsuarios.put(numCliente,cliente);
    }

    private void guardarUsuarios(HashMap<String, Usuario> usuarios) {
        try (ObjectOutputStream archivo = new ObjectOutputStream(new FileOutputStream(ARCHIVO_USUARIOS))) {
            archivo.writeObject(usuarios);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void cargarUsuarios() {
        baseUsuarios = leerUsuarios();
        System.out.println("Usuarios cargados: ");
        baseUsuarios.forEach((k, v) -> System.out.println("Usuario: " + k + ", Tipo: " + v.getClass().getSimpleName()));
    }

    public Usuario buscarUsuario(String nombreUsuario) {
        return baseUsuarios.get(nombreUsuario);
    }
    
    @SuppressWarnings("unchecked")
    private ArrayList<Vuelo> leerVuelos() {
        ArrayList<Vuelo> vuelos = new ArrayList<>();
        File archivoVuelos = new File(ARCHIVO_VUELOS);
        if (archivoVuelos.exists()) {
            try (ObjectInputStream archivo = new ObjectInputStream(new FileInputStream(archivoVuelos))) {
                vuelos = (ArrayList<Vuelo>) archivo.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("");
            }
        } else {
            System.out.println("");
        }
        return vuelos;
    }

    public void agregarVuelo(Vuelo nuevo) {
        baseVuelos.add(nuevo);
    }

    private void guardarVuelos(ArrayList<Vuelo> baseVuelos) {
        try (ObjectOutputStream archivo = new ObjectOutputStream(new FileOutputStream(ARCHIVO_VUELOS))) {
            archivo.writeObject(baseVuelos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private ArrayList<Hoteles> leerHoteles() {
        ArrayList<Hoteles> hoteles = new ArrayList<>();
        File archivoHoteles = new File(ARCHIVO_HOTELES);
        if (archivoHoteles.exists()) {
            try (ObjectInputStream archivo = new ObjectInputStream(new FileInputStream(archivoHoteles))) {
                hoteles = (ArrayList<Hoteles>) archivo.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("");
            }
        } else {
            System.out.println("");
        }
        return hoteles;
    }

    private void guardarHoteles(ArrayList<Hoteles> baseHoteles) {
        try (ObjectOutputStream archivo = new ObjectOutputStream(new FileOutputStream(ARCHIVO_HOTELES))) {
            archivo.writeObject(baseHoteles);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Getters y setters
    /** Se definen getters y setters para todos los atributos de clase */
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getHorario() {
        return horario;
    }
    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Usuario getUsuario(String nomUsuairo) {
        return baseUsuarios.get(nomUsuairo);
    }

    @Override
    public String toString() {
        return "Sistema de Sistema de Reservas de Vuelos y Hoteles: "+nombre+"\n"+
                "Teléfono: "+ telefono +"\n"+
                "Horario: "+ horario +"\n";
    }
}
