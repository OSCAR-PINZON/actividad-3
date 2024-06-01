package act3;

public class ListaTitular {
    private NodoJugador inicio; // Atributo para el inicio de la lista
    private NodoJugador ultimo; // Atributo para el último de la lista
    private int cantidad; // Atributo para controlar la cantidad de nodos

    // Constructor sin argumentos (inicializa la lista vacía)
    public ListaTitular() {
        inicio = null;
        ultimo = null;
        cantidad = 0;
    }

    // Método para verificar si la lista está vacía
    public boolean estaVacia() {
        return inicio == null;
    }

    // Método para obtener la cantidad de nodos en la lista
    public int getCantidad() {
        return cantidad;
    }

    // Método para agregar un jugador al final de la lista
    public void agregarJugador(Jugador jugador) {
        NodoJugador nuevoNodo = new NodoJugador(jugador);
        if (estaVacia()) {
            inicio = nuevoNodo;
            ultimo = nuevoNodo;
            inicio.setAnterior(ultimo);
            ultimo.setSiguiente(inicio);
        } else {
            nuevoNodo.setAnterior(ultimo);
            nuevoNodo.setSiguiente(inicio);
            ultimo.setSiguiente(nuevoNodo);
            ultimo = nuevoNodo;
            inicio.setAnterior(ultimo);
        }
        cantidad++;
    }

    // Método para mostrar los jugadores titulares
    public void mostrarTitulares() {
        if (!estaVacia()) {
            NodoJugador actual = inicio;
            do {
                System.out.println(actual.getDato().toString());
                actual = actual.getSiguiente();
            } while (actual != inicio);
        } else {
            System.out.println("La lista de jugadores titulares está vacía.");
        }
    }

    // Método para buscar y cambiar un jugador por otro
    public boolean cambiarJugador(String nombreAntiguo, Jugador nuevoJugador) {
        if (!estaVacia()) {
            NodoJugador actual = inicio;
            do {
                if (actual.getDato().getNombreJugador().equals(nombreAntiguo)) {
                    actual.setDato(nuevoJugador);
                    return true;
                }
                actual = actual.getSiguiente();
            } while (actual != inicio);
        }
        return false;
    }

    // Método para expulsar a un jugador
    public boolean expulsarJugador(String nombreJugador) {
        if (!estaVacia()) {
            NodoJugador actual = inicio;
            do {
                if (actual.getDato().getNombreJugador().equals(nombreJugador)) {
                    if (cantidad == 1) {
                        inicio = null;
                        ultimo = null;
                    } else {
                        actual.getAnterior().setSiguiente(actual.getSiguiente());
                        actual.getSiguiente().setAnterior(actual.getAnterior());
                        if (actual == inicio) {
                            inicio = inicio.getSiguiente();
                        }
                        if (actual == ultimo) {
                            ultimo = ultimo.getAnterior();
                        }
                    }
                    cantidad--;
                    return true;
                }
                actual = actual.getSiguiente();
            } while (actual != inicio);
        }
        return false;
    }

    // Método para eliminar toda la lista
    public void eliminarLista() {
        inicio = null;
        ultimo = null;
        cantidad = 0;
    }

    // Clase interna NodoJugador
    private class NodoJugador {
        private Jugador dato;
        private NodoJugador anterior;
        private NodoJugador siguiente;

        public NodoJugador(Jugador dato) {
            this.dato = dato;
            this.anterior = null;
            this.siguiente = null;
        }

        public Jugador getDato() {
            return dato;
        }

        public void setDato(Jugador dato) {
            this.dato = dato;
        }

        public NodoJugador getAnterior() {
            return anterior;
        }

        public void setAnterior(NodoJugador anterior) {
            this.anterior = anterior;
        }

        public NodoJugador getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(NodoJugador siguiente) {
            this.siguiente = siguiente;
        }
    }

    // Método main para probar la lista de jugadores titulares
    public static void main(String[] args) {
        ListaTitular listaTitulares = new ListaTitular();

        // Crear jugadores
        Jugador jugador1 = new Jugador("Antonio Valencia", 25, "Defensa");
        Jugador jugador2 = new Jugador("Enner Valencia", 13, "Delantero");
        Jugador jugador3 = new Jugador("Jefferson Montero", 7, "Extremo");

        // Agregar jugadores a la lista
        listaTitulares.agregarJugador(jugador1);
        listaTitulares.agregarJugador(jugador2);
        listaTitulares.agregarJugador(jugador3);

        // Mostrar los jugadores titulares
        System.out.println("Lista de jugadores titulares:");
        listaTitulares.mostrarTitulares();
        System.out.println();

        // Cambiar un jugador por otro
        Jugador nuevoJugador = new Jugador("Felipe Caicedo", 11, "Delantero");
        boolean cambiado = listaTitulares.cambiarJugador("Enner Valencia", nuevoJugador);
        if (cambiado) {
            System.out.println("Lista de jugadores titulares actualizada:");
            listaTitulares.mostrarTitulares();
            System.out.println();
        } else {
            System.out.println("No se encontró al jugador Enner Valencia para cambiar.");
        }

        // Expulsar a un jugador
        boolean expulsado = listaTitulares.expulsarJugador("Jefferson Montero");
        if (expulsado) {
            System.out.println("Lista de jugadores titulares después de expulsar a Jefferson Montero:");
            listaTitulares.mostrarTitulares();
            System.out.println();
        } else {
            System.out.println("No se encontró al jugador Jefferson Montero para expulsar.");
        }

        // Eliminar toda la lista
        listaTitulares.eliminarLista();

        // Mostrar la lista después de eliminarla
        System.out.println("Lista de jugadores titulares después de eliminarla:");
        listaTitulares.mostrarTitulares();
    }
}
