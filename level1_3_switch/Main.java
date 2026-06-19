package level1_3_switch;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * LEVEL 1.3 – Taschenrechner mit Switch-Expression
 *
 * Aufbauend auf Level 1.2 (while-Schleife + Exception Handling):
 * Die Schleife und Fehlerbehandlung laufen weiter wie bekannt.
 * Neu ist, wie die Auswahl der Rechenart ausgedrückt wird.
 *
 * SWITCH-ANWEISUNG vs. SWITCH-AUSDRUCK
 * ──────────────────────────────────────
 * Früher gab es nur die switch-ANWEISUNG (statement):
 *
 *   switch (auswahl) {
 *       case 1:
 *           ergebnis = a + b;
 *           break;          // ohne break fällt Java in den nächsten case durch!
 *       case 2:
 *           ergebnis = a - b;
 *           break;
 *       ...
 *   }
 *
 * Seit Java 14 gibt es den switch-AUSDRUCK (expression) mit Pfeil-Syntax:
 *
 *   String ausgabe = switch (auswahl) {
 *       case 1 -> a + " + " + b + " = " + (a + b);
 *       case 2 -> a + " - " + b + " = " + (a - b);
 *       default -> "Ungültige Auswahl!";
 *   };
 *
 * Der Unterschied:
 *   - Der switch-AUSDRUCK LIEFERT EINEN WERT zurück (hier: einen String).
 *   - Kein `break` nötig – jeder Pfeil (→) ist automatisch eine eigene Einheit.
 *   - `default` ist Pflicht, damit Java sicher ist, dass immer ein Wert geliefert wird.
 *   - Bei mehrzeiligen Fällen steht `yield` statt `return`, um den Wert zurückzugeben.
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean weitermachen = true;

        System.out.println("=== Taschenrechner ===");
        System.out.println("Tipp: Gib 0 ein, um das Programm zu beenden.");

        while (weitermachen) {

            System.out.println();
            System.out.println("Welche Rechenart möchtest du verwenden?");
            System.out.println("1) Addition       (+)");
            System.out.println("2) Subtraktion    (-)");
            System.out.println("3) Multiplikation (*)");
            System.out.println("4) Division       (/)");
            System.out.println("0) Beenden");
            System.out.print("Deine Auswahl (0-4): ");

            try {
                int auswahl = scanner.nextInt();

                if (auswahl == 0) {
                    weitermachen = false;

                } else {
                    System.out.print("Erste Zahl:  ");
                    double a = scanner.nextDouble();
                    System.out.print("Zweite Zahl: ");
                    double b = scanner.nextDouble();

                    // Switch-Ausdruck: liefert den fertigen Ausgabe-Text als Wert zurück.
                    // Jeder case-Zweig mit "->" gibt direkt einen String zurück.
                    // Beim mehrzeiligen case 4 wird "yield" verwendet (wie return im switch).
                    String ausgabe = switch (auswahl) {
                        case 1 -> a + " + " + b + " = " + (a + b);
                        case 2 -> a + " - " + b + " = " + (a - b);
                        case 3 -> a + " * " + b + " = " + (a * b);
                        case 4 -> {
                            if (b == 0) {
                                yield "Fehler: Division durch 0 ist nicht erlaubt!";
                            } else {
                                yield a + " / " + b + " = " + (a / b);
                            }
                        }
                        default -> "Ungültige Auswahl! Bitte 0, 1, 2, 3 oder 4 eingeben.";
                    };

                    System.out.println(ausgabe);
                }

            } catch (InputMismatchException e) {
                System.out.println("Fehler: Bitte nur Zahlen eingeben!");
                scanner.nextLine();
            }
        }

        System.out.println("Taschenrechner beendet. Auf Wiedersehen!");
        scanner.close();
    }
}
