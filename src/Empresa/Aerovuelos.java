package Empresa;

import Usuarios.Usuario;
import Vuelos.Vuelo;
import Usuarios.Administrador;
import Usuarios.Cliente;
import Extras.Paquetes;

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
 * @version 2024.09.22
 * Clase para implemetacion de facade
 */
public class Aerovuelos {
    private String nombre;
    private String telefono;
    private String horario;
    private static HashMap<String,Usuario> usuarios;
    private static ArrayList<Vuelo> baseVuelos; 
    private static ArrayList<Paquetes> basePaquetes; 
    private final String ARCHIVO_VUELOS = "vuelos.dat";
    private final String ARCHIVO_USUARIOS = "usuarios.dat";
    public static Scanner entrada = new Scanner(System.in);
    private static Aerovuelos instancia;

    public Aerovuelos(String nombre, String telefono, String horario) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.horario = horario;
        usuarios = leerUsuarios(); // Objetos Usuarios
        baseVuelos=leerVuelos();
        
    }

    //singelton
    public static Aerovuelos getInstancia(String nombre, String telefono, String horario) {
        if (instancia == null) {
            instancia = new Aerovuelos( nombre,  telefono,  horario);
        }
        return instancia;
    }

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
        usuarios.put(nombreUsuario, usuario);
        guardarUsuarios(usuarios);
        System.out.println("Registro exitoso.\n");
    }
    

    public void añadirVuelo(String tipo,String aerolinea, String numVuelo, String origen, String destino, LocalDateTime fechaSalida, double precio, int disponibilidad, int escalas, boolean vueloNacional,boolean requiereVisa) {
        Vuelo nuevo;
        if ("internacional".equalsIgnoreCase(tipo)) {
            nuevo = new Vuelo( aerolinea,  numVuelo,  origen,  destino,  fechaSalida,  precio,  disponibilidad);
        } else if ("nacional".equalsIgnoreCase(tipo)) {
            nuevo = new Vuelo(aerolinea, numVuelo, origen, destino, fechaSalida, precio, disponibilidad, escalas, vueloNacional, requiereVisa);
        } else {
            System.out.println("Tipo de usuario no reconocido.");
            return;
        }

        baseVuelos.add(nuevo);
        guardarVuelos(baseVuelos);
        System.out.println("Vuelo añadido exitosamente.");
    }

    // Método para ver todas las computadoras
    public void verVuelos() {
        System.out.println("Lista de computadoras: ");
        int i = 1;
        for (Vuelo vuelo : baseVuelos) {
            System.out.println("Índice: " + i + "  " + vuelo);
            i++;
        }
    }

    public void verUsuarios() {
        System.out.println("Lista de clientes:");
        int i = 1;
        for (Map.Entry<String, Usuario> entrada : usuarios.entrySet()) {
            String numCliente = entrada.getKey();
            Usuario usuario = entrada.getValue();
            System.out.println("Índice: " + i + "  Número de Cliente: " + numCliente + "  " + usuario);
            i++;
        }
    }


    // Método para eliminar una computadora
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


    private void guardarVuelos(ArrayList<Vuelo> vuelos) {
        try (ObjectOutputStream archivo = new ObjectOutputStream(new FileOutputStream(ARCHIVO_VUELOS))) {
            archivo.writeObject(baseVuelos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void guardarUsuarios(HashMap<String, Usuario> usuarios) {
        try (ObjectOutputStream archivo = new ObjectOutputStream(new FileOutputStream(ARCHIVO_USUARIOS))) {
            archivo.writeObject(usuarios);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean verificarUsuario(String nombreUsuario, String contraseña) {
        Usuario usuario = usuarios.get(nombreUsuario);
        if (usuario != null) {
            return usuario.validarContraseña(contraseña);
        }
        return false;
    }

    public void agregarCliente(String numCliente, Usuario cliente) {
        usuarios.put(numCliente,cliente);
    }
    
    public void AgregarVuelo(Vuelo nuevo) {
        baseVuelos.add(nuevo);
    }

    public Usuario buscarCliente(String llave) {
        return usuarios.get(llave);
    }

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

    public Usuario getUsuarios(String nomUsuairo) {
        return usuarios.get(nomUsuairo);
    }

    @Override
    public String toString() {
        return "Banco: "+nombre+"\n"+
                "Teléfono: "+telefono+"\n"+
                "Horario: "+horario+"\n";
    }
}

