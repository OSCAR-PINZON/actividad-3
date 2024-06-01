package act3;

public class Modo_jugador {
    private Jugador dato; // Atributo tipo Jugador
    private Modo_jugador anterior; // Atributo tipo NodoJugador para el nodo anterior
    private Modo_jugador siguiente; // Atributo tipo NodoJugador para el nodo siguiente

    // Constructor con argumentos
    public Modo_jugador(Jugador dato, Modo_jugador anterior, Modo_jugador siguiente) {
        this.dato = dato;
        this.anterior = anterior;
        this.siguiente = siguiente;
    }

    // Getters y Setters
    public Jugador getDato() {
        return dato;
    }

    public void setDato(Jugador dato) {
        this.dato = dato;
    }

    public Modo_jugador getAnterior() {
        return anterior;
    }

    public void setAnterior(Modo_jugador anterior) {
        this.anterior = anterior;
    }

    public Modo_jugador getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Modo_jugador siguiente) {
        this.siguiente = siguiente;
    }
}
