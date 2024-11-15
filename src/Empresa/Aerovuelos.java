package Empresa;

import Usuarios.Usuario;
import Usuarios.Cliente;

import java.util.HashMap;


/**
 * Archivo: Banco.java
 * package Clases.Banco
 * La clase Banco conecta las clases Cliente y Cuentas; maneja la administración 
 * de las operaciones bancarias. 
 * Almacena la información del banco (nombre, teléfono, horario, dirección) y una lista 
 * de clientes en una HashMap.
 * @author Equipo 5
 * @version 2024.09.22
 */
public class Aerovuelos {
    private String nombre;
    private String telefono;
    private String horario;
    private HashMap<String,Usuario> clientes;

    public Aerovuelos(String nombre, String telefono, String horario) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.horario = horario;
        this.clientes = new HashMap<String,Usuario>(); // Objetos clientes
        
    }

    public void registrarCliente(String numCliente,String nombreUsuario, String contraseña, String nombre, String apellido, String formaDePago ){
        Usuario cliente = new Cliente(numCliente, nombre,  contraseña,  nombre,  apellido, formaDePago);
        agregarCliente(numCliente, cliente);
        System.out.println("Registro exitoso.\n");
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

