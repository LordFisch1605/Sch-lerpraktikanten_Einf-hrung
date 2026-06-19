package level3_5_interface;

public class Multiplikation implements Operation {

    @Override
    public double berechne(double a, double b) {
        return a * b;
    }
}
