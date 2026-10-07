package es.uib.prgava.tema1.taller1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

/** Apartado 4: composición, suma sobre las partes y no exponer la representación interna. */
class EdificioTest {

    private static Aula aula(String edificio, int planta, int numero, int capacidad) {
        return new Aula(new CodigoAula(edificio, planta, numero), capacidad);
    }

    @Test
    void conTodasLibresSumaTodasLasPlazas() {
        var at = new Edificio("Anselm Turmeda",
                aula("AT", 2, 17, 40), aula("AT", 1, 3, 45), aula("MA", 0, 1, 120));
        assertEquals(205, at.plazasLibres());
    }

    @Test
    void laOcupadaNoCuenta() {
        var ocupada = aula("AT", 1, 3, 45);
        ocupada.ocupar();
        var at = new Edificio("Anselm Turmeda", aula("AT", 2, 17, 40), ocupada,
                aula("MA", 0, 1, 120));
        assertEquals(160, at.plazasLibres());
    }

    @Test
    void conTodasOcupadasNoHayPlazasLibres() {
        var una = aula("AT", 2, 17, 40);
        var otra = aula("AT", 1, 3, 45);
        una.ocupar();
        otra.ocupar();
        assertEquals(0, new Edificio("Anselm Turmeda", una, otra).plazasLibres());
    }

    @Test
    void unEdificioSinAulasEsValido() {
        var vacio = new Edificio("Mateu Orfila");
        assertEquals(0, vacio.plazasLibres());
        assertEquals("Mateu Orfila", vacio.nombre());
    }

    @Test
    void elNombreEnBlancoEsRechazado() {
        assertThrows(IllegalArgumentException.class, () -> new Edificio(null));
        assertThrows(IllegalArgumentException.class, () -> new Edificio("   "));
    }

    @Test
    void elResumenLlevaNombreAulasYPlazas() {
        var ocupada = aula("AT", 1, 3, 45);
        ocupada.ocupar();
        var at = new Edificio("Anselm Turmeda", aula("AT", 2, 17, 40), ocupada,
                aula("MA", 0, 1, 120));
        assertEquals("Anselm Turmeda: 3 aulas, 160 plazas libres", at.resumen());
    }

    @Test
    void elEdificioNoExponeSuArrayDeAulas() {
        for (var m : Edificio.class.getDeclaredMethods()) {
            assertFalse(m.getReturnType().isArray(),
                    "devolver el array rompe la encapsulacion: " + m.getName());
        }
    }
}
