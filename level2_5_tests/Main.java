package level2_5_tests;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * LEVEL 2.5 – Taschenrechner mit Tests
 *
 * Aufbauend auf Level 2.0 (Methoden, Math.pow/sqrt):
 * Der Programmablauf bleibt identisch zu Level 2.0.
 * Neu ist, dass die Rechen-Methoden jetzt durch automatisierte Tests
 * abgesichert werden (siehe RechnerTest.java).
 *
 * Kleine Änderung gegenüber Level 2.0:
 *   dividieren() wirft jetzt eine ArithmeticException bei Division durch 0,
 *   statt den Fehler nur in verarbeiteAuswahl() abzufangen. Das macht die Methode
 *   "testfreundlicher", weil Tests mit assertThrows() prüfen können, ob der
 *   Fehlerfall korrekt behandelt wird.
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean weitermachen = true;

        System.out.println("=== Taschenrechner ===");
        System.out.println("Tipp: Gib 0 ein, um das Programm zu beenden.");

        while (weitermachen) {

            System.out.println("\n=== Menü ===");
            System.out.println("1) Addition       (+)");
            System.out.println("2) Subtraktion    (-)");
            System.out.println("3) Multiplikation (*)");
            System.out.println("4) Division       (/)");
            System.out.println("5) Potenz         (x^y)");
            System.out.println("6) Wurzel         (√x)");
            System.out.println("0) Beenden");
            System.out.print("Deine Auswahl: ");

            try {
                int auswahl = scanner.nextInt();

                if (auswahl == 0) {
                    weitermachen = false;
                } else {
                    verarbeiteAuswahl(auswahl, scanner);
                }

            } catch (InputMismatchException e) {
                System.out.println("Fehler: Bitte nur Zahlen eingeben!");
                scanner.nextLine();
            } catch (ArithmeticException e) {
                System.out.println("Fehler: " + e.getMessage());
            }
        }

        System.out.println("Taschenrechner beendet. Auf Wiedersehen!");
        scanner.close();
    }

    static void verarbeiteAuswahl(int auswahl, Scanner scanner) {

        if (auswahl == 6) {
            System.out.print("Zahl: ");
            double a = scanner.nextDouble();
            System.out.println("Ergebnis: √" + a + " = " + wurzel(a));

        } else if (auswahl >= 1 && auswahl <= 5) {

            System.out.print("Erste Zahl:  ");
            double a = scanner.nextDouble();
            System.out.print("Zweite Zahl: ");
            double b = scanner.nextDouble();

            if (auswahl == 1) {
                System.out.println("Ergebnis: " + a + " + " + b + " = " + addieren(a, b));
            } else if (auswahl == 2) {
                System.out.println("Ergebnis: " + a + " - " + b + " = " + subtrahieren(a, b));
            } else if (auswahl == 3) {
                System.out.println("Ergebnis: " + a + " * " + b + " = " + multiplizieren(a, b));
            } else if (auswahl == 4) {
                System.out.println("Ergebnis: " + a + " / " + b + " = " + dividieren(a, b));
            } else if (auswahl == 5) {
                System.out.println("Ergebnis: " + a + " ^ " + b + " = " + potenzieren(a, b));
            }

        } else {
            System.out.println("Ungültige Auswahl! Bitte 0 bis 6 eingeben.");
        }
    }

    static double addieren(double a, double b) {
        return a + b;
    }

    static double subtrahieren(double a, double b) {
        return a - b;
    }

    static double multiplizieren(double a, double b) {
        return a * b;
    }

    // Wirft ArithmeticException bei Division durch 0 – macht die Methode testbar
    static double dividieren(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division durch 0 ist nicht erlaubt!");
        }
        return a / b;
    }

    static double potenzieren(double basis, double exponent) {
        return Math.pow(basis, exponent);
    }

    static double wurzel(double zahl) {
        if (zahl < 0) {
            System.out.println("Fehler: Wurzel aus einer negativen Zahl ist nicht erlaubt!");
            return 0;
        }
        return Math.sqrt(zahl);
    }
}
