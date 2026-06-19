package level3_5_interface;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

/**
 * LEVEL 3.5 – Klasse: Taschenrechner
 *
 * Der zentrale Unterschied zu Level 3.0:
 * Statt einer if/else-Kette oder eines switch für die Rechenart verwendet diese
 * Klasse eine MAP (HashMap), die Auswahl-Zahlen auf Operation-Objekte abbildet.
 *
 * MAP (HashMap<Integer, Operation>)
 * ──────────────────────────────────
 * Eine Map speichert Schlüssel-Wert-Paare (wie ein Wörterbuch: Wort → Bedeutung).
 * Hier: Menü-Nummer (Integer) → Rechenart-Objekt (Operation).
 *
 *   operationen.get(1)  → gibt das Addition-Objekt zurück
 *   operationen.get(3)  → gibt das Multiplikation-Objekt zurück
 *
 * POLYMORPHIE
 * ──────────────────────────────────
 * Alle Objekte (Addition, Subtraktion, …) sind vom Typ `Operation`.
 * Deshalb können sie in derselben Map gespeichert werden.
 * Wenn wir `op.berechne(a, b)` aufrufen, entscheidet Java AUTOMATISCH zur
 * Laufzeit, welche konkrete Implementierung ausgeführt wird.
 * Das ist Polymorphie: dieselbe Methode, verschiedenes Verhalten.
 *
 * OPEN/CLOSED-PRINZIP
 * ──────────────────────────────────
 * Um eine neue Rechenart hinzuzufügen (z. B. Modulo), musst du:
 *   1. Eine neue Klasse `Modulo implements Operation` anlegen.
 *   2. Sie unten in der Map registrieren.
 * KEINE bestehende Klasse muss verändert werden – das ist das Open/Closed-Prinzip:
 * offen für Erweiterung, geschlossen für Modifikation.
 */
public class Taschenrechner {

    // Die Map verbindet Menü-Nummern mit den zugehörigen Operation-Objekten
    private final Map<Integer, Operation> operationen;
    private final Wurzel wurzel;
    private final Scanner scanner;

    public Taschenrechner() {
        scanner = new Scanner(System.in);
        wurzel = new Wurzel();

        // Hier werden alle Operationen einmalig registriert
        operationen = new HashMap<>();
        operationen.put(1, new Addition());
        operationen.put(2, new Subtraktion());
        operationen.put(3, new Multiplikation());
        operationen.put(4, new Division());
        operationen.put(5, new Potenz());
    }

    public void starten() {
        boolean weitermachen = true;

        while (weitermachen) {
            zeigeMenu();

            try {
                int auswahl = scanner.nextInt();

                if (auswahl == 0) {
                    weitermachen = false;
                } else {
                    verarbeiteAuswahl(auswahl);
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

    private void zeigeMenu() {
        System.out.println("\n=== Taschenrechner ===");
        System.out.println("1) Addition       (+)");
        System.out.println("2) Subtraktion    (-)");
        System.out.println("3) Multiplikation (*)");
        System.out.println("4) Division       (/)");
        System.out.println("5) Potenz         (x^y)");
        System.out.println("6) Wurzel         (√x)");
        System.out.println("0) Beenden");
        System.out.print("Deine Auswahl: ");
    }

    private void verarbeiteAuswahl(int auswahl) {

        if (auswahl == 6) {
            // Wurzel: nur eine Zahl nötig
            System.out.print("Zahl: ");
            double a = scanner.nextDouble();
            System.out.println("Ergebnis: √" + a + " = " + wurzel.berechne(a, 0));

        } else {
            // Polymorphie: operationen.get(auswahl) liefert das richtige Objekt –
            // welches genau, entscheidet Java erst zur Laufzeit.
            Operation op = operationen.get(auswahl);

            if (op == null) {
                System.out.println("Ungültige Auswahl! Bitte 0 bis 6 eingeben.");
                return;
            }

            System.out.print("Erste Zahl:  ");
            double a = scanner.nextDouble();
            System.out.print("Zweite Zahl: ");
            double b = scanner.nextDouble();

            double ergebnis = op.berechne(a, b);
            System.out.println("Ergebnis: " + a + " op " + b + " = " + ergebnis);
        }
    }
}
