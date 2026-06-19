package level4_1_gui_vollausbau;

/**
 * LEVEL 4.1 – Klasse: Grundrechenarten
 *
 * Identisch zu Level 3.0 / 4.0 – die Rechen-Logik ändert sich nicht.
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
