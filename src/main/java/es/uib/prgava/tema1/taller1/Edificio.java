package es.uib.prgava.tema1.taller1;

/**
 * Apartado 4. Edificio: un todo hecho de partes.
 *
 * <p>Un edificio no <em>es un</em> aula: <em>tiene</em> aulas. Por eso composición y no herencia.
 * Fíjate en que no hay ningún método que devuelva el array.
 */
public final class Edificio {

    private final String nombre;
    private final Aula[] aulas;

    /**
     * @throws IllegalArgumentException si el nombre está en blanco o el array es {@code null}
     */
    public Edificio(String nombre, Aula... aulas) {
        // TODO 4: valida los dos parámetros y guarda el estado.
        throw new UnsupportedOperationException("TODO 4: constructor de Edificio");
    }

    public String nombre() {
        // TODO 4
        throw new UnsupportedOperationException("TODO 4: Edificio.nombre");
    }

    /** Suma de la capacidad de las aulas que no están ocupadas. */
    public int plazasLibres() {
        // TODO 4
        throw new UnsupportedOperationException("TODO 4: Edificio.plazasLibres");
    }

    /**
     * Ya escrito: por ejemplo {@code Anselm Turmeda: 3 aulas, 160 plazas libres}.
     *
     * <p>No lo toques. Está aquí para que veas que un método del todo puede contestar preguntas
     * sobre las partes sin dejar que nadie de fuera llegue a ellas.
     */
    public String resumen() {
        return nombre + ": " + aulas.length + " aulas, " + plazasLibres() + " plazas libres";
    }
}
