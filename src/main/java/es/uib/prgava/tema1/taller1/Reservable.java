package es.uib.prgava.tema1.taller1;

/**
 * Apartado 3. Cualquier cosa de la que se pueda saber si está libre.
 *
 * <p>Una interfaz no exige parentesco: hoy la cumple {@link Aula}, y mañana podría cumplirla un
 * laboratorio o un proyector sin que esta interfaz cambie.
 */
public interface Reservable {

    /** Si ahora mismo está libre. Cada clase decide cómo lo sabe. */
    boolean estaLibre();

    /**
     * Comportamiento derivado del método abstracto: {@code "libre"} u {@code "ocupada"}.
     *
     * <p>Quien implemente la interfaz lo recibe sin escribirlo. No lo redefinas en {@link Aula}.
     */
    default String disponibilidad() {
        return estaLibre() ? "libre" : "ocupada";
    }
    // Imprime los que están libres.
    static void mostrarLibres(Reservable... cosas) {
        for (Reservable cosa : cosas) {
            if (cosa.estaLibre()) {
                System.out.println(cosa);
            }
        }
    }
}
