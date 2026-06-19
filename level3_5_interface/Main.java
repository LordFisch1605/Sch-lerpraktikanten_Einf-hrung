package level3_5_interface;

/**
 * LEVEL 3.5 – Taschenrechner mit Interface und Polymorphie
 *
 * Aufbauend auf Level 3.0 (Klassen, Objekte, Komposition):
 * Die Klassenstruktur bleibt erhalten – neu ist das Konzept Interface und Polymorphie.
 *
 * 1) INTERFACE
 *    Ein Interface ist ein Vertrag: jede Klasse, die ihn unterschreibt
 *    (= "implements"), muss bestimmte Methoden anbieten.
 *    Hier: `Operation` schreibt die Methode `berechne(double a, double b)` vor.
 *
 * 2) POLYMORPHIE
 *    Alle konkreten Klassen (Addition, Subtraktion, …) sind vom Typ `Operation`.
 *    Eine Variable vom Typ `Operation` kann zur Laufzeit jede dieser Klassen halten.
 *    Das ermöglicht es, Operationen in einer Map<Integer, Operation> zu verwalten
 *    und ohne if/else-Kette aufzurufen: `operationen.get(auswahl).berechne(a, b)`.
 *
 * 3) OPEN/CLOSED-PRINZIP
 *    Eine neue Rechenart hinzufügen = neue Klasse anlegen + in der Map registrieren.
 *    Keine bestehende Klasse wird dabei verändert.
 *
 * 4) RECORD (optional, didaktischer Kommentar)
 *    Wenn man Daten-Klassen mit privaten Feldern und Gettern schreibt (wie in Level 3.0),
 *    kann man das in Java seit Version 16 mit `record` abkürzen:
 *      record Ergebnis(double wert, String formel) {}
 *    Das erzeugt automatisch Konstruktor, Getter, equals(), hashCode() und toString().
 *    Hier wird kein record verwendet, um den Fokus auf Interface/Polymorphie zu halten.
 */
public class Main {

    public static void main(String[] args) {
        Taschenrechner taschenrechner = new Taschenrechner();
        taschenrechner.starten();
    }
}
