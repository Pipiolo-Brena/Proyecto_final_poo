package Empresa;

import Usuarios.Usuario;
import Vuelos.Vuelo;
import Vuelos.VueloInternacional;
import Usuarios.Administrador;
import Usuarios.Cliente;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * @author Equipo 5
 * @version 2024.09.22
 */
public class Aerovuelos {
    private String nombre;
    private String telefono;
    private String horario;
    private HashMap<String,Usuario> clientes;
    private ArrayList<Vuelo> baseVuelos; 

    public Aerovuelos(String nombre, String telefono, String horario) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.horario = horario;
        this.clientes = new HashMap<String,Usuario>(); // Objetos clientes
        
    }

    public void registrarUsuario(String tipo, String id, String nombreUsuario, String contraseña, String nombre, String apellido, String formaDePago) {
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
        System.out.println("Registro exitoso.\n");
    }
    

    public void AgregarVuelo(){
        Vuelo usuario;
        if ("Cliente".equalsIgnoreCase(tipo)) {
            usuario = new Cliente(id, nombreUsuario, contraseña, nombre, apellido, formaDePago);
        } else if ("Administrador".equalsIgnoreCase(tipo)) {
            usuario = new Administrador(nombreUsuario, contraseña, nombre, apellido, id);
        } else {
            System.out.println("Tipo de usuario no reconocido.");
            return;
        }

        agregarCliente(id, usuario);
    }


    public void agregarCliente(String numCliente, Usuario cliente) {
        clientes.put(numCliente,cliente);
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

