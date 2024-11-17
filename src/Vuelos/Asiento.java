package Vuelos;

public class Asiento {
    private String numero;   
    private boolean esVIP;     
    private boolean ocupado;     

    public Asiento(String numero, boolean esVIP) {
        this.numero = numero;
        this.esVIP = esVIP;
        this.ocupado = false;
    }

    public String getNumero() {
        return numero;
    }

    public boolean esVIP() {
        return esVIP;
    }

    public boolean estaOcupado() {
        return ocupado;
    }

    public void reservar() {
        if (ocupado) {
            System.out.println("El asiento no está disponible para reserva.");
            return;
        }
        ocupado = true;
    }

    public void cancelar() {
        if (!ocupado) {
            System.out.println("El asiento no está reservado, no se puede cancelar.");
            return;
        }
        ocupado = false;
    }

    public void liberar() {
        if (!ocupado) {
            System.out.println("El asiento ya está disponible.");
            return;
        }
        ocupado = false;
    }

    @Override
    public String toString() {
        return "Asiento{" +
                "numero='" + numero + '\'' +
                ", esVIP=" + esVIP +
                ", ocupado=" + ocupado +
                '}';
    }
}
