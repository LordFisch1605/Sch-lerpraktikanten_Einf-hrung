package level3_5_interface;

/**
 * LEVEL 3.5 – Interface: Operation
 *
 * Ein Interface definiert einen VERTRAG: jede Klasse, die dieses Interface
 * implementiert, MUSS eine Methode `berechne(double a, double b)` anbieten.
 * Das Interface selbst enthält keinen Code – nur die Signatur (Name, Parameter, Rückgabetyp).
 *
 * Warum ist das nützlich?
 * Weil wir dann eine Variable vom Typ `Operation` haben können, die zur Laufzeit
 * verschiedene konkrete Objekte (Addition, Subtraktion, …) halten kann.
 * Das nennt man POLYMORPHIE: ein Typ, viele Formen.
 */
public interface Operation {

    /**
     * Berechnet ein Ergebnis aus zwei Zahlen.
     * Was genau berechnet wird, legt jede implementierende Klasse selbst fest.
     */
    double berechne(double a, double b);
}
