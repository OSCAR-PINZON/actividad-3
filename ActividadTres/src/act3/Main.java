package act3;

public class Main {

    public static void main(String[] args) {
        Jugador jugador1 = new Jugador("Antonio Valencia", 10, "Centrocampista");
        Jugador jugador2 = new Jugador("Enner Valencia", 11, "Delantero");
        Jugador jugador3 = new Jugador("Arturina", 18, "Defensa");

        System.out.println("Lista de jugadores titulares:");
        System.out.println(jugador1);
        System.out.println(jugador2);
        System.out.println(jugador3);
    }
}
