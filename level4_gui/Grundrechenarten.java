package level4;

/**
 * LEVEL 4 – Klasse: Grundrechenarten
 *
 * Identisch zu Level 3 – die Rechen-Logik ändert sich nicht,
 * nur die Benutzeroberfläche wurde auf eine GUI umgestellt.
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
            return Double.NaN;
        }
        return a / b;
    }
}
