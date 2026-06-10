package level4;

/**
 * LEVEL 4 – Klasse: ErweiterteOperationen
 *
 * Identisch zu Level 3 – die Rechen-Logik ändert sich nicht,
 * nur die Benutzeroberfläche wurde auf eine GUI umgestellt.
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
