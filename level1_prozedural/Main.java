package level1;

import java.util.Scanner;

/**
 * LEVEL 1 – Taschenrechner
 *
 * Alles läuft direkt in der main-Methode ab.
 * Es gibt noch keine eigenen Klassen oder Methoden – nur die Grundbausteine:
 *   - Variablen speichern Werte
 *   - Scanner liest Eingaben von der Tastatur
 *   - if/else entscheidet, was passiert
 */
public class Main {

    public static void main(String[] args) {

        // Scanner ermöglicht das Einlesen von Tastatureingaben
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Taschenrechner ===");
        System.out.println("Welche Rechenart möchtest du verwenden?");
        System.out.println("1) Addition       (+)");
        System.out.println("2) Subtraktion    (-)");
        System.out.println("3) Multiplikation (*)");
        System.out.println("4) Division       (/)");
        System.out.print("Deine Auswahl (1-4): ");

        // nextInt() liest eine ganze Zahl ein
        int auswahl = scanner.nextInt();

        System.out.print("Erste Zahl:  ");
        double a = scanner.nextDouble();

        System.out.print("Zweite Zahl: ");
        double b = scanner.nextDouble();

        // Abhängig von der Auswahl wird die richtige Rechnung ausgeführt
        if (auswahl == 1) {
            double ergebnis = a + b;
            System.out.println("Ergebnis: " + a + " + " + b + " = " + ergebnis);

        } else if (auswahl == 2) {
            double ergebnis = a - b;
            System.out.println("Ergebnis: " + a + " - " + b + " = " + ergebnis);

        } else if (auswahl == 3) {
            double ergebnis = a * b;
            System.out.println("Ergebnis: " + a + " * " + b + " = " + ergebnis);

        } else if (auswahl == 4) {
            // Sonderfall: Division durch 0 ist mathematisch nicht erlaubt
            if (b == 0) {
                System.out.println("Fehler: Division durch 0 ist nicht erlaubt!");
            } else {
                double ergebnis = a / b;
                System.out.println("Ergebnis: " + a + " / " + b + " = " + ergebnis);
            }

        } else {
            System.out.println("Ungültige Auswahl! Bitte 1, 2, 3 oder 4 eingeben.");
        }

        scanner.close();
    }
}
