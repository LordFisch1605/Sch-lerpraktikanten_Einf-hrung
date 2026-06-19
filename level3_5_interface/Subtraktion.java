package level3_5_interface;

public class Subtraktion implements Operation {

    @Override
    public double berechne(double a, double b) {
        return a - b;
    }
}
