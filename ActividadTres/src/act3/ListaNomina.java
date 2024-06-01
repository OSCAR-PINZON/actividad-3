package act3;

public class ListaNomina {
    private Nodo inicio; // Atributo para el inicio de la lista

    // Constructor sin argumentos
    public ListaNomina() {
        this.inicio = null;
    }

    // Método para ingresar al final de la lista los nuevos nodos
    public void agregarNodo(Jugador jugador) {
        Nodo nuevoNodo = new Nodo(jugador);
        if (inicio == null) {
            inicio = nuevoNodo;
            inicio.setAnterior(inicio);
            inicio.setSiguiente(inicio);
        } else {
            Nodo ultimo = inicio.getAnterior();
            nuevoNodo.setAnterior(ultimo);
            nuevoNodo.setSiguiente(inicio);
            inicio.setAnterior(nuevoNodo);
            ultimo.setSiguiente(nuevoNodo);
        }
    }

    // Método para buscar un jugador en la lista y desconectar su nodo
    public void eliminarJugador(String nombreJugador) {
        if (inicio != null) {
            Nodo actual = inicio;
            do {
                if (actual.getJugador().getNombreJugador().equals(nombreJugador)) {
                    if (actual == inicio && inicio.getSiguiente() == inicio) {
                        inicio = null;
                    } else {
                        actual.getAnterior().setSiguiente(actual.getSiguiente());
                        actual.getSiguiente().setAnterior(actual.getAnterior());
                        if (actual == inicio) {
                            inicio = inicio.getSiguiente();
                        }
                    }
                    return;
                }
                actual = actual.getSiguiente();
            } while (actual != inicio);
        }
    }

    // Método para mostrar la información de todos los nodos
    public void mostrarNodos() {
        if (inicio != null) {
            Nodo actual = inicio;
            do {
                System.out.println(actual.getJugador().toString());
                actual = actual.getSiguiente();
            } while (actual != inicio);
        } else {
            System.out.println("La lista de nómina está vacía.");
        }
    }

    // Clase interna Nodo
    private static class Nodo {
        private Jugador jugador;
        private Nodo anterior;
        private Nodo siguiente;

        public Nodo(Jugador jugador) {
            this.jugador = jugador;
            this.anterior = null;
            this.siguiente = null;
        }

        public Jugador getJugador() {
            return jugador;
        }

        public void setJugador(Jugador jugador) {
            this.jugador = jugador;
        }

        public Nodo getAnterior() {
            return anterior;
        }

        public void setAnterior(Nodo anterior) {
            this.anterior = anterior;
        }

        public Nodo getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(Nodo siguiente) {
            this.siguiente = siguiente;
        }
    }

    // Método main para probar la lista de nómina
    public static void main(String[] args) {
        ListaNomina listaNomina = new ListaNomina();

        // Crear jugadores
        Jugador jugador1 = new Jugador("Antonio Valencia", 25, "Defensa");
        Jugador jugador2 = new Jugador("Enner Valencia", 13, "Delantero");
        Jugador jugador3 = new Jugador("Jefferson Montero", 7, "Extremo");

        // Agregar jugadores a la lista
        listaNomina.agregarNodo(jugador1);
        listaNomina.agregarNodo(jugador2);
        listaNomina.agregarNodo(jugador3);

        // Mostrar los jugadores de la nómina
        System.out.println("Lista de jugadores de la nómina:");
        listaNomina.mostrarNodos();
        System.out.println();

        // Eliminar un jugador
        listaNomina.eliminarJugador("Enner Valencia");

        // Mostrar la lista después de eliminar un jugador
        System.out.println("Lista de jugadores de la nómina después de eliminar a Enner Valencia:");
        listaNomina.mostrarNodos();
        System.out.println();
    }
}
