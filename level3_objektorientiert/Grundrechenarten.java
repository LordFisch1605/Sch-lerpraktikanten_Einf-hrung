package level3_objektorientiert;

/**
 * LEVEL 3 â€“ Klasse: Grundrechenarten
 *
 * Diese Klasse ist in einer eigenen Datei und kÃ¼mmert sich nur um
 * die vier Grundrechenarten. Jede Klasse hat eine klare Aufgabe â€“
 * das nennt man das "Prinzip der einzelnen Verantwortung".
 */
public class Grundrechenarten {

    public double addieren(double a, double b) {
        return a + b;
    }

    public double subtrahieren(double a, double b) {
        return a - b;
    }

    public double multiplizieren(double a, double b) {
        return a * b;
    }

    public double dividieren(double a, double b) {
        if (b == 0) {
            System.out.println("Fehler: Division durch 0 ist nicht erlaubt!");
            return 0;
        }
        return a / b;
    }
}
