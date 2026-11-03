import java.util.LinkedList;
import java.util.Queue;

public class ListaDeEspera<T> {
    private Queue<T> fila;
    public ListaDeEspera() {
        this.fila = new LinkedList<>();
    }
    public void agregar(T persona) {
        fila.add(persona);
    }
    public T atenderSiguiente() {
        if (!estaVacia()) {
            return fila.poll();
        }
        return null;
    }
    public boolean estaVacia() {
        return fila.isEmpty();
    }
    public int cantidadAnotados() {
        return fila.size();
    }
}