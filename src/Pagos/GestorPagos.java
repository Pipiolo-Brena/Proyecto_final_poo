package Pagos;

import java.util.HashMap;
import java.util.Map;

public class GestorPagos {
    private MetodosPago metodoSeleccionado;
    private Map<String, MetodosPago> metodosDisponibles;

    public GestorPagos() {
        this.metodosDisponibles = new HashMap<>();
    }

    public void registrarMetodoPago(String metodoPago, MetodosPago metodo) {
        metodosDisponibles.put(metodoPago, metodo);
    }

    public boolean seleccionarMetodoPago(String metodoPago) {
        if(metodosDisponibles.containsKey(metodoPago)) {
            metodoSeleccionado = metodosDisponibles.get(metodoPago);
            return true;
        } else {
            System.out.println("Método de pago no encontrado: "+ metodoPago);
            return false;
        }
    }

    public void realizarPago(double monto) {
        if(metodoSeleccionado == null) {
            System.out.println("No se ha encontrado un método de pago.");
            return;
        }
        if(metodoSeleccionado.validarPago()) {
            metodoSeleccionado.realizarPago(monto);
            System.out.println("Pago realizado exitosamente.");
        } else {
            System.out.println("El método de pago no es válido.");
        }
    }

    public void metodosPagoDisponibles() {
        System.out.println("Métodos de pago disponibles:");
        for (String nombre : metodosDisponibles.keySet()) {
            System.out.println("- " + nombre);
        }
    }

    public MetodosPago getMetodoSeleccionado() {
        return metodoSeleccionado;
    }
}
