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
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("Nombre de edificio no válido");
        } else if (aulas == null) {
            throw new IllegalArgumentException("Array de aulas no válido");
        }
        this.nombre = nombre;
        this.aulas = aulas;
    }

    public String nombre() {
        return nombre;
    }

    /** Suma de la capacidad de las aulas que no están ocupadas. */
    public int plazasLibres() {
        int total = 0;
        for (Aula aula : aulas) {
            if (aula.estaLibre()) {
                total += aula.capacidad();
            }
        }
        return total;
    }


    public String resumen() {
        return nombre + ": " + aulas.length + " aulas, " + plazasLibres() + " plazas libres";
    }
}
