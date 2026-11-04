import java.util.Optional;
import java.util.Map;
import java.util.HashMap;

public class Servicio {
    private String ID;
    private String empresa;
    private String destino;
    private String horario;
    private int cantAsientos;
    private double precio;
    private int asientosDisponibles;

    private ListaDeEspera<Pasajero> listaEspera;
    private Map<Integer, Pasaje> pasajesVendidos = new HashMap<>();

    public Servicio(String ID, String empresa, String destino, String horario, int cantAsientos, double precio) {
        this.ID = ID;
        this.empresa = empresa;
        this.destino = destino;
        this.horario = horario;
        this.cantAsientos = cantAsientos;
        this.precio = precio;
        this.asientosDisponibles = cantAsientos;
        this.listaEspera = new ListaDeEspera<Pasajero>(); // Máximo 5 en espera según el enunciado
    }

    public String getID() { return ID; }
    public String getEmpresa() { return empresa; }
    public String getDestino() { return destino; }
    public String getHorario() { return horario; }
    public int getCantAsientos() { return cantAsientos; }
    public double getPrecio() { return precio; }
    public int lugaresDisponibles() { return asientosDisponibles; }
    public void venderPasaje(Pasajero pasajero) {
        if (asientosDisponibles > 0) {
            asientosDisponibles--;
            System.out.println("¡Pasaje vendido con éxito!");
        } else {
            listaEspera.agregar(pasajero);
            System.out.println("Colectivo lleno. Pasajero agregado a la lista de espera.");
        }
    }
    public Optional<Pasaje> buscarPasajePorDni(String dni) {
        for (Pasaje pasaje : pasajesVendidos.values()) {
            if (pasaje.getPasajero().getDni().equals(dni)) {
                return Optional.of(pasaje);
            }
        }
        return Optional.empty();
    }

    public Pasajero devolverPasaje(int numeroAsiento) {
        asientosDisponibles++;
        if (!listaEspera.estaVacia()) {
            Pasajero pasajeroDevuelto = pasajesVendidos.remove(numeroAsiento);
            Pasajero siguiente = listaEspera.atenderSiguiente();
            asientosDisponibles--;
            System.out.println("Se desocupó el asiento " + numeroAsiento + ". Subió desde la lista de espera: " + siguiente);
        } else {
            System.out.println("El asiento " + numeroAsiento + " quedó libre.");

        }
        return pasajeroDevuelto;
    }
}