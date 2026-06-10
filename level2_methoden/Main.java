package level2;

import java.util.Scanner;

/**
 * LEVEL 2 – Taschenrechner mit Methoden und Schleife
 *
 * Neu im Vergleich zu Level 1:
 *
 * 1) METHODEN
 *    In Level 1 stand der gesamte Code in der main-Methode.
 *    Hier wurde der Code in mehrere kleinere Methoden aufgeteilt:
 *      - verarbeiteAuswahl(...) kümmert sich darum, was nach der Eingabe passiert
 *      - addieren(), subtrahieren(), multiplizieren(), dividieren() führen je eine Rechnung durch
 *    Vorteil: Jede Methode hat eine klare Aufgabe. Das macht den Code leichter lesbar
 *    und man kann einzelne Teile leichter verändern oder wiederverwenden.
 *
 * 2) WHILE-SCHLEIFE
 *    In Level 1 konnte man nur eine einzige Rechnung durchführen, danach war das Programm fertig.
 *    Hier läuft das Programm in einer Schleife (while), die sich so lange wiederholt,
 *    bis der Benutzer "0" eingibt. So kann man beliebig viele Rechnungen hintereinander machen.
 *
 * 3) PARAMETER & RÜCKGABEWERTE
 *    Die Rechenmethoden (z.B. addieren) bekommen zwei Zahlen übergeben (Parameter: a und b)
 *    und liefern das Ergebnis zurück (Rückgabetyp: double).
 *    In Level 1 wurden die Zahlen direkt an Ort und Stelle berechnet und in einer Variable gespeichert.
 *
 * 4) ERWEITERTE OPERATIONEN & DIE KLASSE Math
 *    Zusätzlich zu den vier Grundrechenarten gibt es jetzt:
 *      - Potenz (x^y): berechnet z.B. 2^10 = 1024 – dafür wird Math.pow() verwendet
 *      - Wurzel (√x):  berechnet z.B. √9 = 3   – dafür wird Math.sqrt() verwendet
 *    Math ist eine fertige Java-Klasse mit vielen nützlichen Mathematik-Methoden.
 *    Man ruft sie auf wie eine normale Methode, nur mit dem Klassennamen davor: Math.pow(...)
 *    Hinweis: Die Wurzel braucht nur eine Zahl, keine zweite Eingabe.
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int auswahl = -1;

        // Die Schleife läuft solange, bis der Benutzer 0 eingibt
        while (auswahl != 0) {

            System.out.println("\n=== Taschenrechner ===");
            System.out.println("1) Addition       (+)");
            System.out.println("2) Subtraktion    (-)");
            System.out.println("3) Multiplikation (*)");
            System.out.println("4) Division       (/)");
            System.out.println("5) Potenz         (x^y)");
            System.out.println("6) Wurzel         (√x)");
            System.out.println("0) Beenden");
            System.out.print("Deine Auswahl: ");

            auswahl = scanner.nextInt();

            verarbeiteAuswahl(auswahl, scanner);
        }

        scanner.close();
    }




    // Verarbeitet die gewählte Operation und gibt das Ergebnis aus
    static void verarbeiteAuswahl(int auswahl, Scanner scanner) {

        if (auswahl == 0) {
            System.out.println("Taschenrechner beendet. Auf Wiedersehen!");

        } else if (auswahl == 6) {
            // Wurzel braucht nur eine Zahl, deshalb wird hier separat abgefragt
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
                if (b == 0) {
                    System.out.println("Fehler: Division durch 0 ist nicht erlaubt!");
                } else {
                    System.out.println("Ergebnis: " + a + " / " + b + " = " + dividieren(a, b));
                }
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

    static double dividieren(double a, double b) {
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
