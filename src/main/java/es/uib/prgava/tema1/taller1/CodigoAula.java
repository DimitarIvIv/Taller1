package es.uib.prgava.tema1.taller1;

/**
 * Apartado 1. Código de un aula: edificio, planta y número.
 *
 * <p>Objeto-valor: sin identidad propia e inmutable. Por eso es un {@code record} y por eso no
 * tienes que escribir {@code equals} ni {@code hashCode}.
 */
public record CodigoAula(String edificio, int planta, int numero)
        implements Comparable<CodigoAula> {

    public CodigoAula {
        // TODO 1: el edificio no puede ser null ni estar en blanco; la planta va de 0 a 5 y el
        // número de 1 a 99. Lanza IllegalArgumentException nombrando el dato culpable y su
        // valor, por ejemplo "Planta fuera de rango: 7".
    }

    /** Forma habitual de un código, por ejemplo {@code AT.2.17}. */
    @Override
    public String toString() {
        // TODO 1: concatena edificio, planta y número separados por puntos.
        throw new UnsupportedOperationException("TODO 1: CodigoAula.toString");
    }

    /**
     * Orden natural: primero el edificio; si coincide, la planta; si coincide, el número.
     *
     * <p>Para los enteros usa {@code Integer.compare}, no la resta.
     */
    @Override
    public int compareTo(CodigoAula otro) {
        // TODO 1
        throw new UnsupportedOperationException("TODO 1: CodigoAula.compareTo");
    }
}
