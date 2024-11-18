package Pagos;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import Pagos.Efectivo.OXXO;
import Pagos.Linea.TarjetaCredito;
import Pagos.Linea.TerjataDebito;

public class GestorPagos implements Serializable {
    private static final long serialVersionUID = 1L;
    private MetodosPago metodoSeleccionado;
    private Map<String, MetodosPago> metodosDisponibles;

    public GestorPagos() {
        this.metodosDisponibles = new HashMap<>();
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

    public MetodosPago registrarMetodoPago(String nombreMetodo) {
        Scanner scanner = new Scanner(System.in);
        MetodosPago nuevoMetodo = null;

        switch(nombreMetodo) {
            case "TARJETA_CREDITO" -> {
                System.out.println("Ingrese los datos de la tarjeta de crédito:");
                System.out.print("Número de tarjeta: ");
                String numeroTarjeta = scanner.nextLine();
                System.out.println("Titular: ");
                String titular = scanner.nextLine();
                System.out.println("Fecha de expiración (YYYY-MM-DD): ");
                String fecha = scanner.nextLine();
                LocalDateTime fechaExp = LocalDateTime.parse(fecha + "T00:00:00");
                System.out.println("CVV: ");
                int cvv = scanner.nextInt();
                scanner.nextLine();

                nuevoMetodo = new TarjetaCredito(0, numeroTarjeta, titular, fechaExp, cvv, 0.0);
            }
            case "TARJETA_DEBITO" -> {
                System.out.println("Ingrese los datos de la tarjeta de crédito:");
                System.out.print("Número de tarjeta: ");
                String numeroTarjeta = scanner.nextLine();
                System.out.println("Titular: ");
                String titular = scanner.nextLine();
                System.out.println("Fecha de expiración (YYYY-MM-DD): ");
                String fecha = scanner.nextLine();
                LocalDateTime fechaExp = LocalDateTime.parse(fecha + "T00:00:00");
                System.out.println("CVV: ");
                int cvv = scanner.nextInt();
                System.out.println("Saldo de la tarjeta: ");
                double saldo = scanner.nextDouble();
                scanner.nextLine();
                nuevoMetodo = new TerjataDebito(0, numeroTarjeta, titular, fechaExp, cvv, saldo);
            }
            case "OXXO" -> {
                nuevoMetodo = new OXXO();
                System.out.println("Código de pago generado: " + ((OXXO) nuevoMetodo).getCodigoPago());
            }
            default -> {
                System.out.println("Método de pago no reconocido.");
                scanner.close();
                return null;
            }
        }

        if(nuevoMetodo != null) {
            metodosDisponibles.put(nombreMetodo, nuevoMetodo);
            System.out.println("Método de pago registrado exitosamente.");
        }

        scanner.close();
        return nuevoMetodo;
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
