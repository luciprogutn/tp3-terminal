import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Terminal terminal = new Terminal();

        terminal.agregarServicio(new Servicio("NEC-MDP-0700", "Costera", "Mar del Plata", "07:00", 4, 12000.0));
        terminal.agregarServicio(new Servicio("NEC-BA-2200", "Atlántica", "Buenos Aires", "22:00", 6, 38000.0));
        terminal.agregarServicio(new Servicio("NEC-TAN-0930", "Costera", "Tandil", "09:30", 3, 9500.0));
        terminal.agregarServicio(new Servicio("NEC-TRA-1400", "Atlántica", "Tres Arroyos", "14:00", 5, 21000.0));

        System.out.println("=== 2. PROCESANDO VENTAS.TXT ===");
        procesarArchivoVentas("ventas.txt", terminal);

        System.out.println("\n=== PROBANDO ARCHIVO INEXISTENTE ===");

        try {
            procesarArchivoVentas("archivo_falso.txt", terminal);
        } catch (Exception e) {

        }

        System.out.println("\n=== DEVOLUCIÓN DE PASAJE ===");

        System.out.println("Bruno Ortiz devolvió su pasaje. Verificando si subió alguien de la espera...");

        System.out.println("\n=== INFORMES DE LA TERMINAL ===");

        System.out.println("\n=== BÚSQUEDAS DE PRUEBA ===");

        Optional<Pasaje> pasajeAna = terminal.buscarPasaje("30111222", "NEC-TRA-1400");
        if (pasajeAna.isPresent()) {
            System.out.println("Pasaje de Ana Molina encontrado con éxito.");
        } else {
            System.out.println("Ana Molina no posee pasaje en ese servicio.");
        }

        Optional<Pasaje> pasajeInexistente = terminal.buscarPasaje("99999999", "NEC-MDP-0700");
        if (!pasajeInexistente.isPresent()) {
            System.out.println("Búsqueda con DNI inexistente resuelta correctamente (Optional vacío).");
        }
    }

    public static void procesarArchivoVentas(String rutaArchivo, Terminal terminal) {
        int lineasLeidas = 0;
        int ventasExitosas = 0;
        int rechazados = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineasLeidas++;
                try {
                    String[] partes = linea.split(";");

                    if (partes.length != 4) {
                        throw new VentaInvalidaException("El renglón no tiene cuatro campos.");
                    }

                    String codigoServicio = partes[0].trim();
                    String dni = partes[1].trim();
                    String nombre = partes[2].trim();
                    String asientoStr = partes[3].trim();

                    Servicio servicio = terminal.buscarServicio(codigoServicio);
                    if (servicio == null) {
                        throw new ServicioNoEncontradoException("El servicio " + codigoServicio + " no existe.");
                    }

                    if (!esAsientoValido(asientoStr)) {
                        throw new VentaInvalidaException("El asiento '" + asientoStr + "' no es un número ni *.");
                    }

                    Pasajero pasajero = new Pasajero(dni, nombre);
                    terminal.venderPasaje(codigoServicio, pasajero, asientoStr);

                    ventasExitosas++;

                } catch (ServicioNoEncontradoException | VentaInvalidaException e) {
                    rechazados++;
                    System.out.println("Rennglón " + lineasLeidas + " rechazado: " + e.getMessage());
                } catch (NumberFormatException e) {
                    rechazados++;
                    System.out.println("Renglón " + lineasLeidas + " rechazado: Formato de número inválido.");
                }
            }

            System.out.println("--- Resumen de Procesamiento ---");
            System.out.println("Renglones leídos: " + lineasLeidas);
            System.out.println("Ventas realizadas: " + ventasExitosas);
            System.out.println("Renglones rechazados: " + rechazados);

        } catch (IOException e) {
            System.out.println("El archivo " + rutaArchivo + " no pudo ser encontrado.");
        }
    }

    private static boolean esAsientoValido(String asiento) {
        if (asiento.equals("*")) {
            return true;
        }
        try {
            Integer.parseInt(asiento);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}