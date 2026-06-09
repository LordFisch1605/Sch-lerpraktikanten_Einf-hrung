package Taschenrechner;

public class Main {

    public static void main(String[] args) {
        Grundrechenarten rechner = new Grundrechenarten();
        ErweiterteOperationen erweitert = new ErweiterteOperationen();

        System.out.println("10 + 5 = " + rechner.addieren(10, 5));
        System.out.println("10 - 5 = " + rechner.subtrahieren(10, 5));
        System.out.println("10 * 5 = " + rechner.multiplizieren(10, 5));
        System.out.println("10 / 5 = " + rechner.dividieren(10, 5));
        System.out.println("2 ^ 8 = " + erweitert.potenzieren(2, 8));
        System.out.println("√16  = " + erweitert.wurzel(16));
    }
}
