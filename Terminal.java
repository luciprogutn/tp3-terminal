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

    // Unificamos buscarServicio y obtenerServicio para que hagan exactamente lo mismo
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
        // Acá se completará la lógica de venta por asiento o asterisco (* según Parte B.3)
    }

    // Búsqueda de pasaje que retorna Optional (Parte B.5 - ¡Nunca devuelve null!)
    public Optional<Pasaje> buscarPasaje(String codigoServicio, String dni) {
        Servicio servicio = servicios.get(codigoServicio);
        if (servicio != null) {
            // Cuando tengan la colección de pasajes en Servicio, lo buscan acá y retornan:
            // return Optional.of(pasajeEncontrado);
        }
        return Optional.empty();
    }

    // Informes de la Terminal (Parte B.6)
    public void imprimirInformes() {
        System.out.println("--- Informe de Pasajeros por Servicio ---");
        for (Servicio s : servicios.values()) {
            System.out.println("Servicio: " + s.getID() + " (" + s.getDestino() + ")");
            // Acá pueden listar los pasajeros ordenados y los de la lista de espera
        }

        System.out.println("--- Informe de Recaudación por Empresa ---");
        // Lógica para acumular y mostrar lo recaudado por cada empresa
    }
}