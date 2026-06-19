package level3_5_interface;

public class Potenz implements Operation {

    @Override
    public double berechne(double a, double b) {
        return Math.pow(a, b);
    }
}
