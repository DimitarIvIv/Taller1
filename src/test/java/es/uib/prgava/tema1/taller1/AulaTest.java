package es.uib.prgava.tema1.taller1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/** Apartado 2: estado, validación en el constructor y atributo de clase. */
class AulaTest {

    private static CodigoAula codigo() {
        return new CodigoAula("AT", 2, 17);
    }

    @Test
    void unAulaNaceLibre() {
        var aula = new Aula(codigo(), 40);
        assertFalse(aula.estaOcupada());
        assertEquals(40, aula.capacidad());
        assertEquals(codigo(), aula.codigo());
    }

    @Test
    void ocuparYLiberarCambianElEstado() {
        var aula = new Aula(codigo(), 40);
        aula.ocupar();
        assertTrue(aula.estaOcupada());
        aula.liberar();
        assertFalse(aula.estaOcupada());
    }

    @Test
    void elCodigoNuloEsRechazado() {
        assertThrows(IllegalArgumentException.class, () -> new Aula(null, 40));
    }

    @Test
    void laCapacidadNoPositivaEsRechazada() {
        assertThrows(IllegalArgumentException.class, () -> new Aula(codigo(), 0));
        assertThrows(IllegalArgumentException.class, () -> new Aula(codigo(), -5));
    }

    @Test
    void elContadorCuentaLasAulasConstruidas() {
        int antes = Aula.aulasCreadas();
        new Aula(codigo(), 40);
        new Aula(new CodigoAula("MA", 0, 1), 120);
        assertEquals(antes + 2, Aula.aulasCreadas());
    }

    @Test
    void elContadorNoSeIncrementaConUnAulaRechazada() {
        int antes = Aula.aulasCreadas();
        assertThrows(IllegalArgumentException.class, () -> new Aula(codigo(), 0));
        assertEquals(antes, Aula.aulasCreadas());
    }

    @Test
    void elToStringLlevaCodigoCapacidadYEstado() {
        var aula = new Aula(codigo(), 40);
        assertEquals("AT.2.17 (40 plazas, libre)", aula.toString());
        aula.ocupar();
        assertEquals("AT.2.17 (40 plazas, ocupada)", aula.toString());
    }

    @Test
    void noHayManeraDeCambiarElCodigo() {
        for (var m : Aula.class.getDeclaredMethods()) {
            assertFalse(m.getName().toLowerCase().startsWith("setcodigo")
                            || m.getName().equals("cambiarCodigo"),
                    "un aula que cambia de codigo es otra aula: no debe haber " + m.getName());
        }
    }
}
