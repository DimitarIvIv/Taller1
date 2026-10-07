package es.uib.prgava.tema1.taller1;

/**
 * Apartado 2. Aula: objeto con identidad y con estado que cambia.
 *
 * <p>Clase tradicional, no un {@code record}, precisamente porque su estado cambia. Fíjate en que
 * no hay ni debe haber un método para cambiar el código.
 */
public class Aula implements Reservable {

    private static int AulasCreadas = 0;

    private final CodigoAula codigo;
    private final int capacidad;
    private boolean ocupada;

    /**
     * Un aula nace libre.
     *
     * @throws IllegalArgumentException si el código es {@code null} o la capacidad no es positiva
     */
    // Utilizado IA para escribir rápidamente el constructor.
    public Aula(CodigoAula codigo, int capacidad) {
        if (codigo == null) {
            throw new IllegalArgumentException("Código de aula no válido");
        } else if (capacidad <= 0) {
            throw new IllegalArgumentException("Capacidad no válida: " + capacidad);
        }
        this.codigo = codigo;
        this.capacidad = capacidad;
        this.ocupada = false;
        AulasCreadas++;
    }

    /** Método de clase: cuántas aulas se han construido desde que arrancó el programa. */
    public static int aulasCreadas() {
        return AulasCreadas;
    }

    public CodigoAula codigo() {
        return codigo;
    }

    public int capacidad() {
        return capacidad;
    }

    public boolean estaOcupada() {
        return ocupada;
    }

    public void ocupar() {
        ocupada = true;
    }

    public void liberar() {
        ocupada = false;
    }

    @Override
    public boolean estaLibre() {
        return !ocupada;
    }

    /** Por ejemplo {@code AT.2.17 (40 plazas, libre)} o {@code AT.1.3 (45 plazas, ocupada)}. */
    @Override
    public String toString() {
        return codigo + " ("+ capacidad + " plazas, " + (ocupada ? "ocupada" : "libre") + ")";
    }
}
