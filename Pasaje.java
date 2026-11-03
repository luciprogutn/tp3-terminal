public class Pasaje {
    private int numeroAsiento;
    private double precio;
    private Pasajero pasajero;
    private String codigoServicio;

    public Pasaje(int numeroAsiento, double precio, Pasajero pasajero, String codigoServicio) {
        this.numeroAsiento = numeroAsiento;
        this.precio = precio;
        this.pasajero = pasajero;
        this.codigoServicio = codigoServicio;
    }

    public int getNumeroAsiento() {
        return numeroAsiento;
    }

    public void setNumeroAsiento(int numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public String getCodigoServicio() {
        return codigoServicio;
    }

    public void setCodigoServicio(String codigoServicio) {
        this.codigoServicio = codigoServicio;
    }

    @Override
    public String toString() {
        return "Pasaje{" +
                "numeroAsiento=" + numeroAsiento +
                ", precio=" + precio +
                ", pasajero=" + pasajero +
                ", codigoServicio='" + codigoServicio + '\'' +
                '}';
    }
}