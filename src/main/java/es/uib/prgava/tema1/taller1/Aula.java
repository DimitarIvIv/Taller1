package es.uib.prgava.tema1.taller1;

/**
 * Apartado 2. Aula: objeto con identidad y con estado que cambia.
 *
 * <p>Clase tradicional, no un {@code record}, precisamente porque su estado cambia. Fíjate en que
 * no hay ni debe haber un método para cambiar el código.
 */
public class Aula implements Reservable {

    // TODO 2: declara aquí el atributo de clase que cuenta las aulas creadas.

    private final CodigoAula codigo;
    private int capacidad;
    private boolean ocupada;

    /**
     * Un aula nace libre.
     *
     * @throws IllegalArgumentException si el código es {@code null} o la capacidad no es positiva
     */
    public Aula(CodigoAula codigo, int capacidad) {
        // TODO 2: valida los dos parámetros, inicializa el estado e incrementa el contador.
        throw new UnsupportedOperationException("TODO 2: constructor de Aula");
    }

    /** Método de clase: cuántas aulas se han construido desde que arrancó el programa. */
    public static int aulasCreadas() {
        // TODO 2
        throw new UnsupportedOperationException("TODO 2: Aula.aulasCreadas");
    }

    public CodigoAula codigo() {
        // TODO 2
        throw new UnsupportedOperationException("TODO 2: Aula.codigo");
    }

    public int capacidad() {
        // TODO 2
        throw new UnsupportedOperationException("TODO 2: Aula.capacidad");
    }

    public boolean estaOcupada() {
        // TODO 2
        throw new UnsupportedOperationException("TODO 2: Aula.estaOcupada");
    }

    public void ocupar() {
        // TODO 2
        throw new UnsupportedOperationException("TODO 2: Aula.ocupar");
    }

    public void liberar() {
        // TODO 2
        throw new UnsupportedOperationException("TODO 2: Aula.liberar");
    }

    @Override
    public boolean estaLibre() {
        // TODO 3: lo que exige la interfaz Reservable.
        throw new UnsupportedOperationException("TODO 3: Aula.estaLibre");
    }

    /** Por ejemplo {@code AT.2.17 (40 plazas, libre)} o {@code AT.1.3 (45 plazas, ocupada)}. */
    @Override
    public String toString() {
        // TODO 2: reutiliza disponibilidad(), que te llega de la interfaz.
        throw new UnsupportedOperationException("TODO 2: Aula.toString");
    }
}
