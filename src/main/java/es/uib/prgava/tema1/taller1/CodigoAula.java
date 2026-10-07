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
        if (edificio == null || edificio.isBlank()){
            throw new IllegalArgumentException("Nombre de edificio no válido");
        } else if (planta < 0 || planta > 5){
            throw new IllegalArgumentException("Planta fuera de rango: " + planta);
        } else if (numero < 1 || numero > 99){
            throw new IllegalArgumentException("Número fuera de rango: " + numero);
        }
    }

    /** Forma habitual de un código, por ejemplo {@code AT.2.17}. */
    @Override
    public String toString() {
        return edificio + "." + planta + "." + numero;
    }

    /**
     * Orden natural: primero el edificio; si coincide, la planta; si coincide, el número.
     *
     * <p>Para los enteros usa {@code Integer.compare}, no la resta.
     */
    @Override
    public int compareTo(CodigoAula otro) {
        int resultado = edificio.compareTo(otro.edificio);
        if (resultado == 0){
            resultado = Integer.compare(planta, otro.planta);
            if (resultado == 0){
                resultado = Integer.compare(numero, otro.numero);
            }
        }
        return resultado;
    }
}