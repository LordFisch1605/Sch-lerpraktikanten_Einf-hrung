package level3_5_interface;

public class Division implements Operation {

    @Override
    public double berechne(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division durch 0 ist nicht erlaubt!");
        }
        return a / b;
    }
}
