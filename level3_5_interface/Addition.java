package level3_5_interface;

/**
 * LEVEL 3.5 – Implementierung: Addition
 *
 * "implements Operation" bedeutet: diese Klasse verpflichtet sich,
 * alle Methoden des Interfaces zu implementieren (hier: berechne).
 * Der Compiler prüft das – fehlt die Methode, gibt es einen Fehler.
 */
public class Addition implements Operation {

    @Override
    public double berechne(double a, double b) {
        return a + b;
    }
}
