package level4;

import javax.swing.SwingUtilities;

/**
 * LEVEL 4 – Taschenrechner mit grafischer Benutzeroberfläche (GUI)
 *
 * Neu im Vergleich zu Level 3:
 *
 * 1) JFRAME – DAS PROGRAMMFENSTER
 *    In den vorherigen Levels lief das Programm im Terminal (Konsole).
 *    Hier wird ein echtes Fenster angezeigt – dafür verwendet Java die Klasse JFrame.
 *    JFrame stammt aus dem Paket javax.swing, das Java's eingebaute GUI-Bibliothek ist.
 *    Die Klasse TaschenrechnerFenster erweitert JFrame (extends JFrame), d.h. sie
 *    erbt alle Fähigkeiten eines Fensters und fügt eigene Inhalte hinzu.
 *
 * 2) GUI-KOMPONENTEN
 *    Statt System.out.println() und Scanner gibt es jetzt visuelle Elemente:
 *      - JTextField  – ein Eingabefeld, in das der Benutzer eine Zahl tippt
 *      - JButton     – ein klickbarer Knopf
 *      - JLabel      – ein Text, der nur angezeigt wird (nicht bearbeitbar)
 *      - JPanel      – eine unsichtbare Fläche, die andere Komponenten gruppiert
 *
 * 3) LAYOUT-MANAGER
 *    Damit Komponenten automatisch angeordnet werden, verwendet Swing Layout-Manager:
 *      - BorderLayout  – teilt das Fenster in Bereiche: NORTH, CENTER, SOUTH usw.
 *      - GridLayout    – ordnet Komponenten in einem Raster (Zeilen × Spalten) an
 *      - FlowLayout    – reiht Komponenten nebeneinander auf wie Wörter in einem Text
 *
 * 4) EREIGNISSTEUERUNG (Event-driven Programming)
 *    In Level 1–3 lief das Programm Schritt für Schritt von oben nach unten.
 *    Hier wartet das Programm, bis der Benutzer etwas tut (z.B. einen Knopf drückt).
 *    Das nennt man ereignisgesteuerte Programmierung.
 *    Jeder JButton bekommt einen ActionListener: eine Aktion, die beim Klick ausgeführt wird.
 *    Geschrieben wird das mit einem Lambda-Ausdruck:
 *      button.addActionListener(e -> { ... });   ← das "e" steht für das Klick-Ereignis
 *
 * 5) SwingUtilities.invokeLater
 *    Swing-Fenster müssen im sogenannten "Event Dispatch Thread" gestartet werden –
 *    das ist ein spezieller Thread, der allein für die GUI zuständig ist.
 *    SwingUtilities.invokeLater(...) stellt sicher, dass das Fenster korrekt geöffnet wird.
 *
 * Die Rechen-Logik (Grundrechenarten, ErweiterteOperationen) ist identisch zu Level 3 –
 * nur die Benutzeroberfläche wurde von Konsole auf Fenster umgestellt.
 */
public class Main {

    public static void main(String[] args) {
        // Das Fenster wird im richtigen GUI-Thread geöffnet
        SwingUtilities.invokeLater(() -> {
            TaschenrechnerFenster fenster = new TaschenrechnerFenster();
            fenster.setVisible(true);
        });
    }
}
