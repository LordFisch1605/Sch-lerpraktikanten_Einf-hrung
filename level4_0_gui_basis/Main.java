package level4_0_gui_basis;

import javax.swing.SwingUtilities;

/**
 * LEVEL 4.0 – Taschenrechner mit grafischer Benutzeroberfläche (Basis)
 *
 * Aufbauend auf Level 3.5 (Interface, Polymorphie):
 * Die Rechen-Logik bleibt gleich; neu ist die Benutzeroberfläche.
 *
 * SwingUtilities.invokeLater
 * ───────────────────────────
 * Swing-Fenster müssen im "Event Dispatch Thread" (EDT) gestartet werden –
 * einem speziellen Thread, der allein für die GUI zuständig ist.
 * `invokeLater()` stellt sicher, dass der Fenster-Code im richtigen Thread läuft.
 * Ohne das könnte es zu schwer reproduzierbaren Fehlern kommen.
 *
 * Das Fenster selbst ist in TaschenrechnerFenster.java beschrieben.
 *
 * Hinweis zur Aufteilung:
 *   level4_0_gui_basis/    → dieser Ordner: minimalste GUI (ein Button, ein Listener)
 *   level4_1_gui_vollausbau/ → alle Buttons, Layout-Manager, Rechen-Historie
 */
public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TaschenrechnerFenster fenster = new TaschenrechnerFenster();
            fenster.setVisible(true);
        });
    }
}
