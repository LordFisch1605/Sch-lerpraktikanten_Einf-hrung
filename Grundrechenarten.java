package Taschenrechner;

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
            throw new ArithmeticException("Division durch 0 ist nicht erlaubt.");
        }
        return a / b;
    }
}
