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
    private HashMap<String,Usuario> clientes;
    private ArrayList<Vuelo> baseVuelos; 
    private ArrayList<Paquetes> basePaquetes; 
    private final String ARCHIVO_VUELOS = "vuelos.dat";
    private final String ARCHIVO_CLIENTES = "clientes.dat";
    public static Scanner entrada = new Scanner(System.in);
    private static Aerovuelos instancia;

    public Aerovuelos(String nombre, String telefono, String horario) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.horario = horario;
        this.clientes = new HashMap<String,Usuario>(); // Objetos clientes
        this.baseVuelos=leerVuelos();
        
    }

    //singelton
    public static Aerovuelos getInstancia(String nombre, String telefono, String horario) {
        if (instancia == null) {
            instancia = new Aerovuelos( nombre,  telefono,  horario);
        }
        return instancia;
    }

    public void registrarUsuario(String tipo, String id, String nombreUsuario, String contraseña, String nombre, String apellido, String formaDePago) {
        HashMap<String,Usuario> usuarios = leerClientes();
        Usuario usuario;
        if ("Cliente".equalsIgnoreCase(tipo)) {
            usuario = new Cliente(id, nombreUsuario, contraseña, nombre, apellido, formaDePago);
        } else if ("Administrador".equalsIgnoreCase(tipo)) {
            usuario = new Administrador(nombreUsuario, contraseña, nombre, apellido, id);
        } else {
            System.out.println("Tipo de usuario no reconocido.");
            return;
        }
        agregarCliente(id, usuario);
        usuarios.put(id, usuario);
        guardarClientes(usuarios);
        System.out.println("Registro exitoso.\n");
    }
    

    public void añadirVuelo(String tipo,String aerolinea, String numVuelo, String origen, String destino, LocalDateTime fechaSalida, double precio, int disponibilidad, int escalas, boolean vueloNacional,boolean requiereVisa) {
        ArrayList<Vuelo> vuelos = leerVuelos();
        Vuelo nuevo;
        if ("internacional".equalsIgnoreCase(tipo)) {
            nuevo = new Vuelo( aerolinea,  numVuelo,  origen,  destino,  fechaSalida,  precio,  disponibilidad);
        } else if ("nacional".equalsIgnoreCase(tipo)) {
            nuevo = new Vuelo(aerolinea, numVuelo, origen, destino, fechaSalida, precio, disponibilidad, escalas, vueloNacional, requiereVisa);
        } else {
            System.out.println("Tipo de usuario no reconocido.");
            return;
        }

        AgregarVuelo(nuevo);
        vuelos.add(nuevo);
        guardarVuelos(vuelos);
        System.out.println("Vuelo añadido exitosamente.");
    }

    // Método para ver todas las computadoras
    public void verVuelos() {
        ArrayList<Vuelo> vuelos = leerVuelos();
        System.out.println("Lista de computadoras: ");
        int i = 1;
        for (Vuelo vuelo : vuelos) {
            System.out.println("Índice: " + i + "  " + vuelo);
            i++;
        }
    }

    public void verClientes() {
        HashMap<String, Usuario> clientes = leerClientes();
        System.out.println("Lista de clientes:");
        int i = 1;
        for (Map.Entry<String, Usuario> entrada : clientes.entrySet()) {
            String numCliente = entrada.getKey();
            Usuario usuario = entrada.getValue();
            System.out.println("Índice: " + i + "  Número de Cliente: " + numCliente + "  " + usuario);
            i++;
        }
    }


    // Método para eliminar una computadora
    public void eliminarVuelo() {
        ArrayList<Vuelo> vuelos = leerVuelos();
        verVuelos();
        System.out.println("A partir del índice, ¿Qué máquina se quiere eliminar?");
        int num = entrada.nextInt();

        if (num < 1 || num > vuelos.size()) {
            System.out.println("Índice no válido.");
            return;
        }

        vuelos.remove(num - 1);
        guardarVuelos(vuelos);
        System.out.println("Computadora eliminada exitosamente.");
    }

    @SuppressWarnings("unchecked")
    private HashMap<String, Usuario> leerClientes() {
        HashMap<String, Usuario> clientes = new HashMap<>();
        try (ObjectInputStream archivo = new ObjectInputStream(new FileInputStream(ARCHIVO_CLIENTES))) {
            HashMap<String, Usuario> datosLeidos = (HashMap<String, Usuario>) archivo.readObject();
            for (Usuario usuario : datosLeidos.values()) {
                clientes.put(usuario.getNumUsuario(), usuario);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado, se creará uno nuevo.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return clientes;
    }
    

    @SuppressWarnings("unchecked")
    private ArrayList<Vuelo> leerVuelos() {
        ArrayList<Vuelo> vuelos = new ArrayList<>();
        try (ObjectInputStream archivo = new ObjectInputStream(new FileInputStream(ARCHIVO_VUELOS))) {
            vuelos = (ArrayList<Vuelo>) archivo.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado, se creará uno nuevo.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return vuelos;
    }


    private void guardarVuelos(ArrayList<Vuelo> vuelos) {
        try (ObjectOutputStream archivo = new ObjectOutputStream(new FileOutputStream(ARCHIVO_VUELOS))) {
            archivo.writeObject(vuelos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void guardarClientes(HashMap<String, Usuario> clientes) {
        try (ObjectOutputStream archivo = new ObjectOutputStream(new FileOutputStream(ARCHIVO_CLIENTES))) {
            archivo.writeObject(clientes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void agregarCliente(String numCliente, Usuario cliente) {
        clientes.put(numCliente,cliente);
    }
    
    public void AgregarVuelo(Vuelo nuevo) {
        baseVuelos.add(nuevo);
    }

    public Usuario buscarCliente(String llave) {
        return clientes.get(llave);
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

    @Override
    public String toString() {
        return "Banco: "+nombre+"\n"+
                "Teléfono: "+telefono+"\n"+
                "Horario: "+horario+"\n";
    }
}

