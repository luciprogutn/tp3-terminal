public class Pasaje {
    private Servicio servicio;
    private Pasajero pasajero;
    private int numeroAsiento;

    public Pasaje(Servicio servicio, Pasajero pasajero, int numeroAsiento) {
        this.servicio = servicio;
        this.pasajero = pasajero;
        this.numeroAsiento = numeroAsiento;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public int getNumeroAsiento() {
        return numeroAsiento;
    }

    public void setNumeroAsiento(int numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }
}