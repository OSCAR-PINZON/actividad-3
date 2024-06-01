package act3;

public class Jugador {
    private String nombreJugador;
    private int numeroDorsal;
    private String posicion;

    public Jugador(String nombreJugador, int numeroDorsal, String posicion) {
        this.nombreJugador = nombreJugador;
        this.numeroDorsal = numeroDorsal;
        this.posicion = posicion;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "nombreJugador='" + nombreJugador + '\'' +
                ", numeroDorsal=" + numeroDorsal +
                ", posicion='" + posicion + '\'' +
                '}';
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public int getNumeroDorsal() {
        return numeroDorsal;
    }

    public void setNumeroDorsal(int numeroDorsal) {
        this.numeroDorsal = numeroDorsal;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }
}
