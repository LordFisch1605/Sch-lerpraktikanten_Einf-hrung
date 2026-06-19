package level4_1_gui_vollausbau;

import javax.swing.SwingUtilities;

/**
 * LEVEL 4.1 – Taschenrechner mit GUI (Vollausbau)
 *
 * Aufbauend auf Level 4.0 (GUI-Basis):
 * Das Basis-Fenster wird um alle Operationen, mehrere Layout-Manager
 * und die Rechen-Historie aus Level 2.6 erweitert.
 *
 * Alle Details stehen in TaschenrechnerFenster.java.
 */
public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TaschenrechnerFenster fenster = new TaschenrechnerFenster();
            fenster.setVisible(true);
        });
    }
}
