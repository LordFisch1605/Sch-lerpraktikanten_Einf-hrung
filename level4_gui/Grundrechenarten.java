package level4_gui;

/**
 * LEVEL 4 â€“ Klasse: Grundrechenarten
 *
 * Identisch zu Level 3 â€“ die Rechen-Logik Ã¤ndert sich nicht,
 * nur die BenutzeroberflÃ¤che wurde auf eine GUI umgestellt.
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
