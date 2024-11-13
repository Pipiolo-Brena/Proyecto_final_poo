package Empresa;

import Usuarios.Usuario;
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

   /**
    * Constructor de la clase Banco.
    * Inicializa los atributos del banco con la información recibida como parámetros.
    * También se crea un objeto Dirección con los datos proporcionados.
    * @param nombre Nombre del banco.
    * @param telefono Teléfono del banco.
    * @param horario Horario de atención del banco.
    * @param municipio Municipio de la dirección del banco.
    * @param colonia Colonia de la dirección del banco.
    * @param codigoPostal Código postal de la dirección del banco.
    * @param calle Calle de la dirección del banco.
    */
    public Aerovuelos(String nombre, String telefono, String horario) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.horario = horario;
        this.clientes = new HashMap<String,Usuario>(); // Objetos clientes
        
    }


    /**
     * Método para registrar un nuevo cliente en el banco.
     * Crea un objeto Cliente y lo añade a la HashMap de clientes.
     * @param numCliente Número único del cliente.
     * @param nombre Nombre del cliente.
     * @param aPaterno Apellido paterno del cliente.
     * @param aMaterno Apellido materno del cliente.
     * @param direccion Dirección del cliente.
     * @param telefono Teléfono del cliente.
     */
    public void registrarCliente(String numCliente,String nombre,String aPaterno,String aMaterno,String direccion,String telefono){
        Usuario cliente = new Usuario(numCliente, nombre,aPaterno,  aMaterno,direccion,telefono);
        agregarCliente(numCliente, cliente);
        System.out.println("Registro exitoso.\n");
    }

    /**
     * Método propio de la clase para agregar un cliente a la HashMap.
     * @param numCliente Número único del cliente.
     * @param cliente Objeto Cliente que se va a agregar.
     */
    public void agregarCliente(String numCliente, Usuario cliente) {
        clientes.put(numCliente,cliente);
    }


    /**
     * Método para buscar un cliente en la HashMap.
     * @param llave Clave de búsqueda, que en este caso es el número de cliente.
     * @return Objeto Cliente correspondiente al número de cliente buscado.
     */
    public Usuario buscarCliente(String llave) {
        return clientes.get(llave);
    }

    // Getters y setters para los atributos del banco

    /**
     * Método para obtener el nombre del banco.
     * @return Nombre del banco.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método para establecer el nombre del banco.
     * @param nombre Nuevo nombre del banco.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método para obtener el teléfono del banco.
     * @return Teléfono del banco.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Método para establecer el teléfono del banco.
     * @param telefono Nuevo teléfono del banco.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Método para obtener el horario del banco.
     * @return Horario de atención del banco.
     */
    public String getHorario() {
        return horario;
    }

    /**
     * Método para establecer el horario del banco.
     * @param horario Nuevo horario de atención del banco.
     */
    public void setHorario(String horario) {
        this.horario = horario;
    }

    /**
     * Método toString que devuelve una cadena con la información del banco.
     * Incluye el nombre, teléfono, horario, dirección y el número de clientes registrados.
     * @return Cadena con la información detallada del banco.
     */
    @Override
    public String toString() {
        return "Banco: "+nombre+"\n"+
                "Teléfono: "+telefono+"\n"+
                "Horario: "+horario+"\n"+
                "Nùmero de clientes en nuestra sucursal: "+Usuario.getContadorClientes()+"\n";
    }
}

