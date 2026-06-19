package level3_5_interface;

/**
 * LEVEL 3.5 – Sonderfall Wurzel
 *
 * Wurzel braucht nur eine Zahl (nicht zwei). Da das Interface zwei Parameter
 * vorschreibt, wird `b` hier schlicht ignoriert. Im Taschenrechner wird Wurzel
 * separat behandelt, damit nur eine Zahl abgefragt wird.
 */
public class Wurzel implements Operation {

    @Override
    public double berechne(double a, double b) {
        if (a < 0) {
            throw new ArithmeticException("Wurzel aus einer negativen Zahl ist nicht erlaubt!");
        }
        return Math.sqrt(a);
    }
}
