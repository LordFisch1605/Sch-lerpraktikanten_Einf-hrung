package Taschenrechner;

public class ErweiterteOperationen {

    public double potenzieren(double basis, double exponent) {
        return Math.pow(basis, exponent);
    }

    public double wurzel(double zahl) {
        if (zahl < 0) {
            throw new ArithmeticException("Wurzel aus einer negativen Zahl ist nicht erlaubt.");
        }
        return Math.sqrt(zahl);
    }
}
