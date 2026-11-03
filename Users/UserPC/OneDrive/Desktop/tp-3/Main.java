import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Terminal terminal = new Terminal();


        terminal.agregarServicio(new Servicio("NEC-MDP-0700", "Costera", "Mar del Plata", null, 4, 12000.0));
        terminal.agregarServicio(new Servicio("NEC-BA-2200", "Atlántica", "Buenos Aires", null, 6, 38000.0));
        terminal.agregarServicio(new Servicio("NEC-TAN-0930", "Costera", "Tandil", null, 3, 9500.0));
        terminal.agregarServicio(new Servicio("NEC-TRA-1400", "Atlántica", "Tres Arroyos", null, 5, 21000.0));

        System.out.println("=== 2. PROCESANDO VENTAS.TXT ===");
        procesarArchivoVentas("ventas.txt", terminal);

        System.out.println("\n=== PROBANDO ARCHIVO INEXISTENTE ===");
        try {
            procesarArchivoVentas("archivo_falso.txt", terminal);
        } catch (Exception e) {
            System.out.println("Error: El archivo de ventas especificado no existe.");
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


        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) { // O Paths.get(rutaArchivo)
            String linea;
            while ((linea = br.readLine()) != null) {
                lineasLeidas++;
                try {
                    ventasExitosas++;
                } catch (Exception e) {

                    rechazados++;
                    System.out.println("Renglón " + lineasLeidas + " rechazado: " + e.getMessage());
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
}