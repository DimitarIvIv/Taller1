package es.uib.prgava.tema1.taller1;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/** Apartado 3: el método default, el método de clase y el tipo del parámetro. */
class ReservableTest {

    /** Un Reservable que no es un Aula: la interfaz no exige parentesco. */
    private record Puesto(boolean libre) implements Reservable {
        @Override
        public boolean estaLibre() {
            return libre;
        }
    }

    @Test
    void elMetodoDefaultTraduceElEstado() {
        assertEquals("libre", new Puesto(true).disponibilidad());
        assertEquals("ocupada", new Puesto(false).disponibilidad());
    }

    @Test
    void unAulaEsReservable() {
        Reservable aula = new Aula(new CodigoAula("AT", 2, 17), 40);
        assertTrue(aula.estaLibre());
        assertEquals("libre", aula.disponibilidad());
    }

    @Test
    void aulaNoRedefineDisponibilidad() {
        for (var m : Aula.class.getDeclaredMethods()) {
            assertFalse(m.getName().equals("disponibilidad"),
                    "disponibilidad() se hereda de Reservable: no la reescribas en Aula");
        }
    }

    @Test
    void mostrarLibresImprimeSoloLosLibres() {
        var a = new Aula(new CodigoAula("AT", 2, 17), 40);
        var b = new Aula(new CodigoAula("AT", 1, 3), 45);
        b.ocupar();

        var capturado = new ByteArrayOutputStream();
        PrintStream anterior = System.out;
        try {
            System.setOut(new PrintStream(capturado, true));
            Reservable.mostrarLibres(a, b, new Puesto(true), new Puesto(false));
        } finally {
            System.setOut(anterior);
        }

        String[] lineas = capturado.toString().split("\\R");
        assertEquals(2, lineas.length, "una linea por elemento libre");
        assertTrue(lineas[0].contains("AT.2.17"));
    }

    @Test
    void mostrarLibresAceptaCeroElementos() {
        Reservable.mostrarLibres();
    }
}
