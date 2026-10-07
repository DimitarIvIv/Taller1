# t1-taller — Tema 1, Taller 1: Reserva de aulas

Esqueleto del **Taller 1** de *Programación Avanzada (22354)*, Grado en Ingeniería Telemática,
UIB-EPS. El enunciado está en el
[Aula Digital](https://ad.uib.es/estudis2627/mod/assign/view.php?id=331979); aquí tienes el
código sobre el que trabajar.

Es un proyecto **Maven** para **Java 25** con pruebas en **JUnit 5**, preparado para **GitHub
Codespaces**. El esqueleto **compila desde el primer momento**, pero las pruebas fallan: tu
trabajo consiste en ponerlas en verde. Son **100 minutos**.

## Cómo empezar

Pulsa **Use this template** → **Create a new repository** y créalo en **tu cuenta personal**. A
partir de ahí tienes dos caminos, y **los dos valen igual**: es un proyecto Maven corriente.

**En el navegador, con Codespaces.** No hay nada que instalar. En tu copia, **Code** →
**Codespaces** → **Create codespace on main**. Se abre VS Code con el JDK 25 y Maven ya puestos.
En el terminal:

```bash
java -version    # debe empezar por: openjdk version "25
mvn test         # verás fallos: es lo esperado al empezar
```

**En tu ordenador, con IntelliJ IDEA o con VS Code.** Clona tu copia y abre el proyecto por su
`pom.xml`: en IntelliJ, **File → Open** y selecciona el `pom.xml` (elige *Open as Project*); en
VS Code, abre la carpeta y deja que la extensión de Java la importe.

## Un apartado, una clase de prueba

Cada apartado del enunciado se comprueba con una clase de prueba, y solo con esa. Para trabajar
en uno, abre su clase de prueba y pulsa el botón de ejecutar que aparece junto al nombre de la
clase: el ▶ en VS Code, la flecha verde del margen izquierdo en IntelliJ. Para verlas todas en
árbol, el icono de matraz (*Testing*) de la barra lateral en VS Code, o la ventana *Run* en
IntelliJ.

| Apartado | Clase | Clase de prueba |
|---|---|---|
| 1 | `CodigoAula` | `CodigoAulaTest` |
| 2 | `Aula` | `AulaTest` |
| 3 | `Reservable` | `ReservableTest` |
| 4 | `Edificio` | `EdificioTest` |

Son **31 pruebas** en total. **Al clonar, 26 fallan. Es lo normal**: son la lista de tareas, no
una avería. Las cinco que ya pasan lo hacen porque comprueban cosas que te da el lenguaje (la
igualdad del `record`) o que consisten en *no* escribir algo.

Que las pruebas se pongan verdes significa que el programa hace lo que se le pide, **no que el
diseño sea el correcto**: eso se juzga leyendo el código, y es parte de la calificación.

## Cómo está organizado

```text
t1-taller/
├── pom.xml                       ← proyecto Maven (Java 25, JUnit 5)
└── src/
    ├── main/java/es/uib/prgava/tema1/taller1/
    │   ├── CodigoAula.java       ← apartado 1
    │   ├── Aula.java             ← apartado 2
    │   ├── Reservable.java       ← apartado 3
    │   ├── Edificio.java         ← apartado 4
    │   └── DemoTaller1.java      ← ya escrito, no lo toques
    └── test/java/es/uib/prgava/tema1/taller1/   ← las pruebas
```

## Cómo leer el esqueleto

Las cuatro clases traen ya las **declaraciones**: las firmas de sus métodos, la documentación, los
atributos y las cláusulas `implements`. Tú escribes los cuerpos. Cada hueco está marcado con un
comentario `// TODO n`, donde `n` es el apartado del enunciado, y el método lanza
`UnsupportedOperationException` para que el proyecto compile mientras no lo hayas escrito. Cuando
escribas el cuerpo, **borra ese `throw`**.

Dos cosas vienen **ya resueltas** y no hay que tocarlas:

- `Edificio.resumen()`, porque no evalúa nada que no evalúe ya `plazasLibres()`;
- `DemoTaller1`, el programa de arranque. Es el ejemplo de uso del enunciado: cuando el taller
  esté terminado, su salida debe coincidir **línea por línea** con la que allí aparece. Ejecútalo
  de vez en cuando; es más rápido de leer que el informe de las pruebas.

```bash
mvn -q compile exec:java -Dexec.mainClass=es.uib.prgava.tema1.taller1.DemoTaller1
```

o, más simple, el botón de ejecutar junto al `main` en tu IDE.

## Órdenes útiles

```bash
mvn test                           # todas las pruebas
mvn -Dtest=CodigoAulaTest test     # solo una clase
mvn -q compile                     # solo compilar
```

## Integridad académica

El taller se resuelve **en el aula y se permiten asistentes de IA**, según las condiciones de uso de la IA
de la [guía docente](https://uib-22354-programacion-avanzada.github.io/website/es/informaciones/guia-docente.html).
El material de los ejercicios del tema es la preparación de este taller.

## Licencia

El proyecto se publica bajo licencia [MIT](LICENSE) — copyright © 2026 Alejandro
Mesejo. **Las soluciones que escribas son tuyas.** Los enunciados y el resto del material docente
están en el
[sitio web de la asignatura](https://uib-22354-programacion-avanzada.github.io/website/), bajo
licencia [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en).
