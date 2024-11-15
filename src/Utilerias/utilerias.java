package Utilerias;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import Vuelos.Vuelo;

public class utilerias {
    private static final String ARCHIVO_VUELOS = "vuelos.dat";
    public static Scanner entrada = new Scanner(System.in);

    public static void añadirVuelo() {
        ArrayList<Vuelo> vuelos = leerVuelos();
        Vuelo nuevo;
        int op;

        vuelos.add(nuevo);
        guardarVuelos(vuelos);
        System.out.println("Vuelo añadida exitosamente.");
    }

    // Método para ver todas las computadoras
    public static void verVuelos() {
        ArrayList<Vuelo> vuelos = leerVuelos();
        System.out.println("Lista de computadoras: ");
        int i = 1;
        for (Vuelo vuelo : vuelos) {
            System.out.println("Índice: " + i + "  " + vuelo);
            i++;
        }
    }

    // Método para eliminar una computadora
    public static void eliminarComputadora() {
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
    private static ArrayList<Vuelo> leerVuelos() {
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


    private static void guardarVuelos(ArrayList<Vuelo> vuelos) {
        try (ObjectOutputStream archivo = new ObjectOutputStream(new FileOutputStream(ARCHIVO_VUELOS))) {
            archivo.writeObject(vuelos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
