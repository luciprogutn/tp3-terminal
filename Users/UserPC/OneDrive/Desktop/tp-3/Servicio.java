import java.util.Date;

public class Servicio {
    private String ID;
    private String empresa;
    private String destino;
    private Date horario;
    private int cantAsientos;
    private double precio;
    private int asientosDisponibles;


    private ListaDeEspera<String> listaEspera; // O el tipo de objeto pasajero que uses

    public Servicio(String ID, String empresa, String destino, Date horario, int cantAsientos, double precio) {
        this.ID = ID;
        this.empresa = empresa;
        this.destino = destino;
        this.horario = horario;
        this.cantAsientos = cantAsientos;
        this.precio = precio;
        this.asientosDisponibles = cantAsientos; // ¡Aquí inicializamos el contador con el total!
        this.listaEspera = new ListaDeEspera<>();
    }

}

public String getID() {
    return ID;
}
public String getEmpresa() {
    return empresa;
}
public String getDestino() {
    return destino;
}
public Date getHorario() {
    return horario;
}
public int getCantAsientos() {
    return cantAsientos;
}
public double getPrecio() {
    return precio;
}
public int lugaresDisponibles() {
    return asientosDisponibles;
}
public void venderPasaje(String pasajero) {
    if (asientosDisponibles > 0) {
        asientosDisponibles--;
        System.out.println("¡Pasaje vendido con éxito!");
    } else {
        listaEspera.agregar(pasajero);
        System.out.println("Colectivo lleno. Pasajero agregado a la lista de espera.");
    }
}