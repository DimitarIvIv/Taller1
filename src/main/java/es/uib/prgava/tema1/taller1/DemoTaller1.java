package es.uib.prgava.tema1.taller1;

/**
 * Programa de arranque, ya escrito. Es el ejemplo de uso del enunciado: cuando el taller esté
 * resuelto, su salida debe coincidir línea por línea con la que allí aparece.
 */
public final class DemoTaller1 {

    public static void main(String[] args) {
        var a = new Aula(new CodigoAula("AT", 2, 17), 40);
        var b = new Aula(new CodigoAula("AT", 1, 3), 45);
        var c = new Aula(new CodigoAula("MA", 0, 1), 120);
        b.ocupar();

        System.out.println(a);
        System.out.println(b);
        System.out.println(b.disponibilidad());
        System.out.println(Aula.aulasCreadas());

        Reservable.mostrarLibres(a, b, c);

        var at = new Edificio("Anselm Turmeda", a, b, c);
        System.out.println(at.plazasLibres());
        System.out.println(at.resumen());

        var uno = new CodigoAula("AT", 1, 3);
        var otro = new CodigoAula("AT", 1, 3);
        System.out.println(uno.equals(otro));
        System.out.println(uno == otro);
        System.out.println(uno.compareTo(new CodigoAula("AT", 2, 17)) < 0);

        try {
            new CodigoAula("AT", 7, 17);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            new Aula(new CodigoAula("AT", 0, 1), 0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
