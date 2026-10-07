package es.uib.prgava.tema1.taller1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/** Apartado 1: invariante, toString, igualdad de valor y orden natural. */
class CodigoAulaTest {

    @Test
    void losExtremosDelRangoSonValidos() {
        assertEquals(0, new CodigoAula("AT", 0, 1).planta());
        assertEquals(5, new CodigoAula("AT", 5, 99).planta());
        assertEquals(99, new CodigoAula("AT", 5, 99).numero());
    }

    @Test
    void laPlantaFueraDeRangoEsRechazada() {
        assertThrows(IllegalArgumentException.class, () -> new CodigoAula("AT", -1, 1));
        assertThrows(IllegalArgumentException.class, () -> new CodigoAula("AT", 6, 1));
    }

    @Test
    void elNumeroFueraDeRangoEsRechazado() {
        assertThrows(IllegalArgumentException.class, () -> new CodigoAula("AT", 0, 0));
        assertThrows(IllegalArgumentException.class, () -> new CodigoAula("AT", 0, 100));
    }

    @Test
    void elEdificioEnBlancoEsRechazado() {
        assertThrows(IllegalArgumentException.class, () -> new CodigoAula(null, 1, 1));
        assertThrows(IllegalArgumentException.class, () -> new CodigoAula("", 1, 1));
        assertThrows(IllegalArgumentException.class, () -> new CodigoAula("   ", 1, 1));
    }

    @Test
    void elMensajeDeErrorNombraElDatoCulpable() {
        var e = assertThrows(IllegalArgumentException.class, () -> new CodigoAula("AT", 7, 17));
        assertTrue(e.getMessage() != null && e.getMessage().contains("7"),
                "el mensaje debe contener el valor rechazado");
    }

    @Test
    void elToStringEsLaFormaConPuntos() {
        assertEquals("AT.2.17", new CodigoAula("AT", 2, 17).toString());
        assertEquals("MA.0.1", new CodigoAula("MA", 0, 1).toString());
    }

    @Test
    void dosObjetosDistintosConLosMismosDatosSonIguales() {
        var uno = new CodigoAula("AT", 1, 3);
        var otro = new CodigoAula("AT", 1, 3);
        assertNotSame(uno, otro);
        assertEquals(uno, otro);
        assertEquals(uno.hashCode(), otro.hashCode());
    }

    @Test
    void elOrdenMiraPrimeroElEdificio() {
        assertTrue(new CodigoAula("AT", 5, 99).compareTo(new CodigoAula("MA", 0, 1)) < 0);
    }

    @Test
    void conElMismoEdificioElOrdenMiraLaPlanta() {
        assertTrue(new CodigoAula("AT", 1, 3).compareTo(new CodigoAula("AT", 2, 17)) < 0);
        assertTrue(new CodigoAula("AT", 2, 17).compareTo(new CodigoAula("AT", 1, 3)) > 0);
    }

    @Test
    void conElMismoEdificioYPlantaElOrdenMiraElNumero() {
        assertTrue(new CodigoAula("AT", 2, 3).compareTo(new CodigoAula("AT", 2, 17)) < 0);
        assertEquals(0, Integer.signum(new CodigoAula("AT", 2, 17)
                .compareTo(new CodigoAula("AT", 2, 17))));
    }

    @Test
    void elOrdenEsCoherenteConLaIgualdad() {
        var uno = new CodigoAula("AT", 2, 17);
        var otro = new CodigoAula("AT", 2, 17);
        assertEquals(uno.equals(otro), uno.compareTo(otro) == 0);
    }
}
