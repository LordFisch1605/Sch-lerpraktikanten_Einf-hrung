package level4_1_gui_vollausbau;

/**
 * LEVEL 4.1 – Klasse: ErweiterteOperationen
 *
 * Identisch zu Level 3.0 / 4.0 – die Rechen-Logik ändert sich nicht.
 */
public class ErweiterteOperationen {

    public double potenzieren(double basis, double exponent) {
        return Math.pow(basis, exponent);
    }

    public double wurzel(double zahl) {
        if (zahl < 0) {
            return Double.NaN;
        }
        return Math.sqrt(zahl);
    }
}
