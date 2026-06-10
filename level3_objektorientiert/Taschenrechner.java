package level3;

import java.util.Scanner;

/**
 * LEVEL 3 – Klasse: Taschenrechner
 *
 * Diese Klasse steuert das Menü und die Benutzerinteraktion.
 * Sie verwendet Objekte von Grundrechenarten und ErweiterteOperationen –
 * das nennt man "Komposition": eine Klasse nutzt andere Klassen.
 */
public class Taschenrechner {

    // Objekte der anderen Klassen werden als Variable gespeichert
    private Grundrechenarten grundrechenarten;
    private ErweiterteOperationen erweiterteOperationen;
    private Scanner scanner;

    // Der Konstruktor wird aufgerufen, wenn ein Taschenrechner-Objekt erstellt wird
    public Taschenrechner() {
        this.grundrechenarten = new Grundrechenarten();
        this.erweiterteOperationen = new ErweiterteOperationen();
        this.scanner = new Scanner(System.in);
    }

    // Diese Methode startet den Taschenrechner und zeigt das Menü an
    public void starten() {
        int auswahl = -1;

        while (auswahl != 0) {
            zeigeMenu();
            auswahl = scanner.nextInt();
            verarbeiteAuswahl(auswahl);
        }

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
        if (auswahl == 0) {
            System.out.println("Taschenrechner beendet. Auf Wiedersehen!");

        } else if (auswahl == 6) {
            // Wurzel braucht nur eine Zahl, deshalb wird hier separat abgefragt
            System.out.print("Zahl: ");
            double a = scanner.nextDouble();
            System.out.println("Ergebnis: √" + a + " = " + erweiterteOperationen.wurzel(a));

        } else if (auswahl >= 1 && auswahl <= 5) {
            System.out.print("Erste Zahl:  ");
            double a = scanner.nextDouble();
            System.out.print("Zweite Zahl: ");
            double b = scanner.nextDouble();
            rechnen(auswahl, a, b);

        } else {
            System.out.println("Ungültige Auswahl! Bitte 0 bis 6 eingeben.");
        }
    }

    private void rechnen(int auswahl, double a, double b) {
        if (auswahl == 1) {
            System.out.println("Ergebnis: " + a + " + " + b + " = " + grundrechenarten.addieren(a, b));
        } else if (auswahl == 2) {
            System.out.println("Ergebnis: " + a + " - " + b + " = " + grundrechenarten.subtrahieren(a, b));
        } else if (auswahl == 3) {
            System.out.println("Ergebnis: " + a + " * " + b + " = " + grundrechenarten.multiplizieren(a, b));
        } else if (auswahl == 4) {
            System.out.println("Ergebnis: " + a + " / " + b + " = " + grundrechenarten.dividieren(a, b));
        } else if (auswahl == 5) {
            System.out.println("Ergebnis: " + a + " ^ " + b + " = " + erweiterteOperationen.potenzieren(a, b));
        }
    }
}
