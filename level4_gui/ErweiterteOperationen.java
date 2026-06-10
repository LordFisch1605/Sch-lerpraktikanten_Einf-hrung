package level4_gui;

/**
 * LEVEL 4 â€“ Klasse: ErweiterteOperationen
 *
 * Identisch zu Level 3 â€“ die Rechen-Logik Ã¤ndert sich nicht,
 * nur die BenutzeroberflÃ¤che wurde auf eine GUI umgestellt.
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
