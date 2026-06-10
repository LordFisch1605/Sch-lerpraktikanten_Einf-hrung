package level3_objektorientiert;

/**
 * LEVEL 3 â€“ Taschenrechner mit mehreren Klassen (Objektorientierung)
 *
 * Neu im Vergleich zu Level 2:
 *
 * 1) MEHRERE KLASSEN IN EIGENEN DATEIEN
 *    In Level 2 war der gesamte Code in einer einzigen Datei (Main.java).
 *    Hier ist der Code auf drei Dateien aufgeteilt, jede mit einer klaren Aufgabe:
 *      - Main.java            â€“ Startpunkt: erstellt ein Taschenrechner-Objekt und startet es
 *      - Taschenrechner.java  â€“ kÃ¼mmert sich um das MenÃ¼ und die Benutzerinteraktion
 *      - Grundrechenarten.java â€“ enthÃ¤lt nur die vier Rechenoperationen
 *    Vorteil: Wenn man z.B. eine neue Rechenart hinzufÃ¼gen will, Ã¤ndert man nur
 *    Grundrechenarten.java und muss den Rest nicht anfassen.
 *
 * 2) OBJEKTE ERSTELLEN (Instanziierung)
 *    In Level 2 waren die Methoden "static" â€“ sie gehÃ¶rten direkt zur Klasse.
 *    Hier werden echte Objekte erstellt:
 *      Taschenrechner taschenrechner = new Taschenrechner();
 *    Das SchlÃ¼sselwort "new" erstellt ein Objekt. Der sogenannte Konstruktor
 *    (die Methode mit demselben Namen wie die Klasse) wird dabei automatisch aufgerufen.
 *
 * 3) PUBLIC UND PRIVATE
 *    Methoden kÃ¶nnen jetzt "public" (von auÃŸen aufrufbar) oder "private"
 *    (nur innerhalb der eigenen Klasse sichtbar) sein.
 *    Zum Beispiel ist zeigeMenu() private, weil nur die Klasse selbst sie braucht.
 *    Das schÃ¼tzt den Code vor unbeabsichtigter Nutzung von auÃŸen.
 *
 * 4) KOMPOSITION (eine Klasse nutzt eine andere)
 *    Die Klasse Taschenrechner hat ein Objekt der Klasse Grundrechenarten als Variable.
 *    Das nennt man Komposition: Klassen kÃ¶nnen andere Klassen verwenden,
 *    anstatt alles selbst zu machen.
 */
public class Main {

    public static void main(String[] args) {
        // Ein Taschenrechner-Objekt wird erstellt und gestartet
        Taschenrechner taschenrechner = new Taschenrechner();
        taschenrechner.starten();
    }
}
