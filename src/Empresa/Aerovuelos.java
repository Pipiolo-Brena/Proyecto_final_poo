package Empresa;

import Usuarios.*;
import Extras.*;
import Vuelos.Vuelo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/**
 * @author Equipo 5
 * @version 2024.11.17
 * Clase para la implementación de Facade y Singleton
 */
public class Aerovuelos {
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

    public static Scanner entrada = new Scanner(System.in);
    private static Aerovuelos instancia; // Instancia Singleton

    public Aerovuelos(String nombre, String telefono, String horario) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.horario = horario;
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

    // ========================
    // Gestión de Usuarios
    // ========================

    public void registrarUsuario(String tipo, String nombreUsuario, String contraseña, String nombre, String apellido, String formaDePago) {
        Usuario usuario;
        if ("Cliente".equalsIgnoreCase(tipo)) {
            usuario = new Cliente(nombreUsuario, contraseña, nombre, apellido, formaDePago);
        } else if ("Administrador".equalsIgnoreCase(tipo)) {
            usuario = new Administrador(nombreUsuario, contraseña, nombre, apellido);
        } else {
            System.out.println("Tipo de usuario no reconocido.");
            return;
        }
        baseUsuarios.put(nombreUsuario, usuario);
        guardarUsuarios(baseUsuarios);
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
            System.out.println("El cliente que busca es un administrador.");
            return null;
        }
    }

    public void verUsuarios() {
        System.out.println("Lista de clientes:");
        int i = 1;
        for (Map.Entry<String, Usuario> entrada : baseUsuarios.entrySet()) {
            String numCliente = entrada.getKey();
            Usuario usuario = entrada.getValue();
            if(usuario instanceof Cliente) {
                System.out.println("Índice: " + i + "  Número de Cliente: " + numCliente + "  " + usuario);
                i++;
            }
        }
    } // No se muestran los administradores registrados en el sistema.

    // ========================
    // Gestión de Vuelos
    // ========================
    
    public void añadirVuelo(String tipo,String aerolinea, String numVuelo, String origen, String destino, LocalDateTime fechaSalida, double precio, int disponibilidad, int escalas, boolean vueloNacional, boolean requiereVisa) {
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
    }

    /** Método para ver todos los vuelos en el sistema */
    public void verVuelos() {
        System.out.println("Lista de vuelos disponibles:");
        int i = 1;
        for (Vuelo vuelo : baseVuelos) {
            System.out.println("Vuelo " + i + ": " + vuelo);
            i++;
        }
    }

    // Método para eliminar un vuelo
    public void eliminarVuelo() {
        verVuelos();
        System.out.println("A partir del índice, ¿Qué vuelo se quiere eliminar?");
        int num = entrada.nextInt();

        if (num < 1 || num > baseVuelos.size()) {
            System.out.println("Índice no válido.");
            return;
        }

        baseVuelos.remove(num - 1);
        guardarVuelos(baseVuelos);
        System.out.println("Vuelo eliminado exitosamente.");
    }

    // ====================
    // Gestión de Hoteles
    // ====================
    
    public void añadirHotel(String nombre, String ubicacion, double precio, int habitacionesDisponibles) {
        Hoteles hotel = new Hoteles(nombre, ubicacion, precio, habitacionesDisponibles);
        baseHoteles.add(hotel);
        guardarHoteles(baseHoteles); // Guardar cambios en el archivo
        System.out.println("Hotel añadido exitosamente.\n");
    }

    public void verHoteles() {
        System.out.println("Lista de hoteles disponibles:");
        int i = 1;
        for (Hoteles hotel : baseHoteles) {
            System.out.println("Hotel " + i + ": " + hotel);
            i++;
        }
    }

    public void eliminarHotel() {
        verHoteles();
        System.out.println("A partir del índice, ¿Qué hotel se quiere eliminar?");
        int num = entrada.nextInt();

        if (num < 1 || num > baseHoteles.size()) {
            System.out.println("Índice no válido.");
            return;
        }

        baseHoteles.remove(num - 1);
        guardarHoteles(baseHoteles); // Guardar cambios en el archivo
        System.out.println("Hotel eliminado exitosamente.");
    }


    // ====================
    // Manejo de archivos
    // ====================

    @SuppressWarnings("unchecked")
    private HashMap<String, Usuario> leerUsuarios() {
        HashMap<String, Usuario> usuarios = new HashMap<>();
        try (ObjectInputStream archivo = new ObjectInputStream(new FileInputStream(ARCHIVO_USUARIOS))) {
            HashMap<String, Usuario> datosLeidos = (HashMap<String, Usuario>) archivo.readObject();
            for (Usuario usuario : datosLeidos.values()) {
                usuarios.put(usuario.getNombreUsuario(), usuario);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado, se creará uno nuevo.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
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
    
    @SuppressWarnings("unchecked")
    private ArrayList<Vuelo> leerVuelos() {
        try (ObjectInputStream archivo = new ObjectInputStream(new FileInputStream(ARCHIVO_VUELOS))) {
            baseVuelos = (ArrayList<Vuelo>) archivo.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado, se creará uno nuevo.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return baseVuelos;
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
        try (ObjectInputStream archivo = new ObjectInputStream(new FileInputStream(ARCHIVO_HOTELES))) {
            hoteles = (ArrayList<Hoteles>) archivo.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo de hoteles no encontrado, se creará uno nuevo.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
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
