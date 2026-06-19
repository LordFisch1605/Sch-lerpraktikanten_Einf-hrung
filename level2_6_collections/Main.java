package level2_6_collections;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * LEVEL 2.6 – Taschenrechner mit Collections und for-Schleife
 *
 * Aufbauend auf Level 2.5 (Methoden, Tests):
 * Die Rechen-Methoden und Fehlerbehandlung bleiben identisch.
 * Neu ist die Rechen-HISTORIE – und dafür brauchen wir zwei neue Konzepte,
 * die hier bewusst zusammen eingeführt werden, weil das eine das andere motiviert.
 *
 * 1) ARRAYLIST (Collection)
 *    Ein Array hat eine feste Größe, die beim Erstellen festgelegt wird.
 *    Eine ArrayList wächst automatisch, wenn neue Einträge dazukommen:
 *
 *      ArrayList<String> liste = new ArrayList<>();
 *      liste.add("Eintrag 1");   // fügt am Ende hinzu
 *      liste.get(0);             // liest Eintrag an Position 0
 *      liste.size();             // Anzahl der Einträge
 *      liste.clear();            // alle Einträge löschen
 *
 *    Der Typ in den spitzen Klammern (<String>) gibt an, welche Art von Werten
 *    die Liste enthält – das nennt man Generics.
 *
 * 2) FOR-EACH-SCHLEIFE
 *    Um alle Einträge einer Liste auszugeben, braucht man eine Schleife.
 *    Die for-each-Schleife ist dafür die sauberste Schreibweise:
 *
 *      for (String eintrag : liste) {
 *          System.out.println(eintrag);
 *      }
 *
 *    Lies das als: "Für jeden String `eintrag` in `liste`: gib ihn aus."
 *    Man braucht keinen Index-Zähler – Java geht automatisch durch alle Elemente.
 */
public class Main {

    // Die Historie speichert jede Berechnung als lesbaren Text (z. B. "3.0 + 4.0 = 7.0")
    private static ArrayList<String> historie = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean weitermachen = true;

        System.out.println("=== Taschenrechner ===");
        System.out.println("Tipp: Gib 0 ein zum Beenden, 'h' für Historie, 'c' zum Löschen.");

        while (weitermachen) {

            System.out.println("\n=== Menü ===");
            System.out.println("1) Addition       (+)");
            System.out.println("2) Subtraktion    (-)");
            System.out.println("3) Multiplikation (*)");
            System.out.println("4) Division       (/)");
            System.out.println("5) Potenz         (x^y)");
            System.out.println("6) Wurzel         (√x)");
            System.out.println("h) Historie anzeigen");
            System.out.println("c) Historie löschen");
            System.out.println("0) Beenden");
            System.out.print("Deine Auswahl: ");

            // next() liest ein einzelnes Wort (Token) – erlaubt sowohl Zahlen als auch Buchstaben
            String eingabe = scanner.next();

            try {
                switch (eingabe) {
                    case "0" -> weitermachen = false;
                    case "h" -> zeigeHistorie();
                    case "c" -> {
                        historie.clear();
                        System.out.println("Historie gelöscht.");
                    }
                    default -> {
                        int auswahl = Integer.parseInt(eingabe);
                        verarbeiteAuswahl(auswahl, scanner);
                    }
                }

            } catch (NumberFormatException e) {
                System.out.println("Ungültige Eingabe! Bitte eine Zahl (0-6) oder 'h'/'c' eingeben.");
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

    // Gibt alle gespeicherten Berechnungen mit einer for-each-Schleife aus
    private static void zeigeHistorie() {
        if (historie.isEmpty()) {
            System.out.println("Die Historie ist leer.");
            return;
        }
        System.out.println("\n=== Rechen-Historie ===");
        // for-each: geht automatisch durch jeden Eintrag in der Liste
        for (String eintrag : historie) {
            System.out.println("  " + eintrag);
        }
    }

    static void verarbeiteAuswahl(int auswahl, Scanner scanner) {

        if (auswahl == 6) {
            System.out.print("Zahl: ");
            double a = scanner.nextDouble();
            double ergebnis = wurzel(a);
            String ausgabe = "√" + a + " = " + ergebnis;
            System.out.println("Ergebnis: " + ausgabe);
            historie.add(ausgabe);

        } else if (auswahl >= 1 && auswahl <= 5) {

            System.out.print("Erste Zahl:  ");
            double a = scanner.nextDouble();
            System.out.print("Zweite Zahl: ");
            double b = scanner.nextDouble();

            String ausgabe = switch (auswahl) {
                case 1 -> a + " + " + b + " = " + addieren(a, b);
                case 2 -> a + " - " + b + " = " + subtrahieren(a, b);
                case 3 -> a + " * " + b + " = " + multiplizieren(a, b);
                case 4 -> a + " / " + b + " = " + dividieren(a, b);
                case 5 -> a + " ^ " + b + " = " + potenzieren(a, b);
                default -> "Ungültige Auswahl!";
            };

            System.out.println("Ergebnis: " + ausgabe);
            // Jede Berechnung wird am Ende der Liste gespeichert
            historie.add(ausgabe);

        } else {
            System.out.println("Ungültige Auswahl! Bitte 0 bis 6, 'h' oder 'c' eingeben.");
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
