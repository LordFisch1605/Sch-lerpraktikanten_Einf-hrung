package level3_objektorientiert;

/**
 * LEVEL 3 â€“ Klasse: ErweiterteOperationen
 *
 * Diese Klasse enthÃ¤lt mathematische Operationen,
 * die Ã¼ber die vier Grundrechenarten hinausgehen.
 * Sie wird als Objekt in der Klasse Taschenrechner verwendet (Komposition).
 */
public class ErweiterteOperationen {

    public double potenzieren(double basis, double exponent) {
        return Math.pow(basis, exponent);
    }

    public double wurzel(double zahl) {
        if (zahl < 0) {
            System.out.println("Fehler: Wurzel aus einer negativen Zahl ist nicht erlaubt!");
            return 0;
        }
        return Math.sqrt(zahl);
    }
}
