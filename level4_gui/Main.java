package level4_gui;

import javax.swing.SwingUtilities;

/**
 * LEVEL 4 â€“ Taschenrechner mit grafischer BenutzeroberflÃ¤che (GUI)
 *
 * Neu im Vergleich zu Level 3:
 *
 * 1) JFRAME â€“ DAS PROGRAMMFENSTER
 *    In den vorherigen Levels lief das Programm im Terminal (Konsole).
 *    Hier wird ein echtes Fenster angezeigt â€“ dafÃ¼r verwendet Java die Klasse JFrame.
 *    JFrame stammt aus dem Paket javax.swing, das Java's eingebaute GUI-Bibliothek ist.
 *    Die Klasse TaschenrechnerFenster erweitert JFrame (extends JFrame), d.h. sie
 *    erbt alle FÃ¤higkeiten eines Fensters und fÃ¼gt eigene Inhalte hinzu.
 *
 * 2) GUI-KOMPONENTEN
 *    Statt System.out.println() und Scanner gibt es jetzt visuelle Elemente:
 *      - JTextField  â€“ ein Eingabefeld, in das der Benutzer eine Zahl tippt
 *      - JButton     â€“ ein klickbarer Knopf
 *      - JLabel      â€“ ein Text, der nur angezeigt wird (nicht bearbeitbar)
 *      - JPanel      â€“ eine unsichtbare FlÃ¤che, die andere Komponenten gruppiert
 *
 * 3) LAYOUT-MANAGER
 *    Damit Komponenten automatisch angeordnet werden, verwendet Swing Layout-Manager:
 *      - BorderLayout  â€“ teilt das Fenster in Bereiche: NORTH, CENTER, SOUTH usw.
 *      - GridLayout    â€“ ordnet Komponenten in einem Raster (Zeilen Ã— Spalten) an
 *      - FlowLayout    â€“ reiht Komponenten nebeneinander auf wie WÃ¶rter in einem Text
 *
 * 4) EREIGNISSTEUERUNG (Event-driven Programming)
 *    In Level 1â€“3 lief das Programm Schritt fÃ¼r Schritt von oben nach unten.
 *    Hier wartet das Programm, bis der Benutzer etwas tut (z.B. einen Knopf drÃ¼ckt).
 *    Das nennt man ereignisgesteuerte Programmierung.
 *    Jeder JButton bekommt einen ActionListener: eine Aktion, die beim Klick ausgefÃ¼hrt wird.
 *    Geschrieben wird das mit einem Lambda-Ausdruck:
 *      button.addActionListener(e -> { ... });   â† das "e" steht fÃ¼r das Klick-Ereignis
 *
 * 5) SwingUtilities.invokeLater
 *    Swing-Fenster mÃ¼ssen im sogenannten "Event Dispatch Thread" gestartet werden â€“
 *    das ist ein spezieller Thread, der allein fÃ¼r die GUI zustÃ¤ndig ist.
 *    SwingUtilities.invokeLater(...) stellt sicher, dass das Fenster korrekt geÃ¶ffnet wird.
 *
 * Die Rechen-Logik (Grundrechenarten, ErweiterteOperationen) ist identisch zu Level 3 â€“
 * nur die BenutzeroberflÃ¤che wurde von Konsole auf Fenster umgestellt.
 */
public class Main {

    public static void main(String[] args) {
        // Das Fenster wird im richtigen GUI-Thread geÃ¶ffnet
        SwingUtilities.invokeLater(() -> {
            TaschenrechnerFenster fenster = new TaschenrechnerFenster();
            fenster.setVisible(true);
        });
    }
}
