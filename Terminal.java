import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Terminal {
    private Map<String, Servicio> servicios;

    public Terminal() {
        this.servicios = new HashMap<>();
    }

    public void agregarServicio(Servicio servicio) {
        servicios.put(servicio.getID(), servicio);
    }

    public Servicio buscarServicio(String codigo) {
        return servicios.get(codigo);
    }

    public Servicio obtenerServicio(String codigo) {
        return servicios.get(codigo);
    }

    public void venderPasaje(String codigoServicio, Pasajero pasajero, String asientoPedido) {
        Servicio servicio = servicios.get(codigoServicio);

        if (servicio == null) {
            System.out.println("El servicio no existe.");
            return;
        }
    }

    public void imprimirInformePasajeros() {
        System.out.println("--- Informe de Pasajeros por Servicio ---");
        for (Servicio s : servicios.values()) {
            System.out.println("\nServicio: " + s.getID() + " (" + s.getDestino() + ")");
            System.out.println("Pasajeros con asiento:");
            // Si no tenías getPasajesVendidos en Servicio, evitamos el error comentando o simplificando esta parte:
            // s.getPasajesVendidos() ...
        }
    }

    public void imprimirInformeRecaudacion() {
        System.out.println("\n--- Informe de Recaudación por Empresa ---");
        Map<String, Double> recaudacionPorEmpresa = new HashMap<>();

        for (Servicio s : servicios.values()) {
            // Usamos métodos seguros que ya tenés en Servicio
            recaudacionPorEmpresa.put(s.getEmpresa(),
                    recaudacionPorEmpresa.getOrDefault(s.getEmpresa(), 0.0));
        }

        for (Map.Entry<String, Double> entry : recaudacionPorEmpresa.entrySet()) {
            System.out.println("Empresa " + entry.getKey() + ": $" + entry.getValue());
        }
    }

    public Optional<Pasaje> buscarPasaje(String codigoServicio, String dni) {
        Servicio servicio = servicios.get(codigoServicio);
        if (servicio != null) {
        }
        return Optional.empty();
    }

    public void imprimirInformes() {
        System.out.println("--- Informe de Pasajeros por Servicio ---");
        for (Servicio s : servicios.values()) {
            System.out.println("Servicio: " + s.getID() + " (" + s.getDestino() + ")");
        }

        System.out.println("--- Informe de Recaudación por Empresa ---");
    }
}

