package act3;

public class Nodo {
    private Jugador jugador;
    private Nodo siguiente;
    private Nodo anterior;

    public Nodo(Jugador jugador) {
        this.jugador = jugador;
        this.siguiente = null;
        this.anterior = null;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }
}
