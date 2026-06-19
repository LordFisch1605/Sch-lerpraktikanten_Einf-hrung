package level4_0_gui_basis;

import javax.swing.*;
import java.awt.*;

/**
 * LEVEL 4.0 – Klasse: TaschenrechnerFenster (Basis-Version)
 *
 * Dies ist die einfachstmögliche GUI: ein Fenster mit zwei Eingabefeldern,
 * einem Button und einem Ergebnis-Label. Genau ein ActionListener reagiert
 * auf genau einen Klick – der "Aha, es reagiert!"-Moment.
 *
 * JFRAME
 * ──────
 * JFrame ist das Fenster selbst. "extends JFrame" bedeutet, dass diese Klasse
 * ein JFrame IST und alle seine Fähigkeiten erbt (Titel, Größe, Schließen-Button…).
 *
 * GUI-KOMPONENTEN
 * ────────────────
 *   JTextField  – ein Eingabefeld, in das der Benutzer tippt
 *   JButton     – ein klickbarer Knopf
 *   JLabel      – ein Text, der nur angezeigt wird (nicht editierbar)
 *   JPanel      – unsichtbare Fläche, die andere Komponenten gruppiert
 *
 * BORDERLAYOUT
 * ─────────────
 * Das Fenster ist in drei Bereiche aufgeteilt:
 *
 *   +------------------------+
 *   |  Eingabefelder (NORTH) |
 *   +------------------------+
 *   |  Button      (CENTER)  |
 *   +------------------------+
 *   |  Ergebnis    (SOUTH)   |
 *   +------------------------+
 *
 * ACTIONLISTENER MIT LAMBDA
 * ──────────────────────────
 * Statt einer Schleife wartet das Programm auf Benutzeraktionen (ereignisgesteuert).
 * Der ActionListener wird als Lambda-Ausdruck geschrieben:
 *   button.addActionListener(e -> { ... });
 * Das "e" steht für das Klick-Ereignis (event) – wir brauchen es hier nicht, aber
 * Java verlangt den Parameter.
 */
public class TaschenrechnerFenster extends JFrame {

    private JTextField eingabe1;
    private JTextField eingabe2;
    private JLabel ergebnisLabel;

    public TaschenrechnerFenster() {
        setTitle("Taschenrechner – Basis");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Eingabefelder (NORTH)
        JPanel eingabePanel = new JPanel(new GridLayout(2, 2, 5, 5));
        eingabePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
        eingabePanel.add(new JLabel("Erste Zahl:"));
        eingabe1 = new JTextField();
        eingabePanel.add(eingabe1);
        eingabePanel.add(new JLabel("Zweite Zahl:"));
        eingabe2 = new JTextField();
        eingabePanel.add(eingabe2);
        add(eingabePanel, BorderLayout.NORTH);

        // Button (CENTER) – der ActionListener reagiert auf den Klick
        JButton addButton = new JButton("+ Addieren");
        addButton.addActionListener(e -> {
            // try/catch kennen wir aus Level 1.2 – hier für String → double-Umwandlung
            try {
                double a = Double.parseDouble(eingabe1.getText().replace(",", "."));
                double b = Double.parseDouble(eingabe2.getText().replace(",", "."));
                ergebnisLabel.setText("Ergebnis: " + a + " + " + b + " = " + (a + b));
            } catch (NumberFormatException ex) {
                ergebnisLabel.setText("Bitte gültige Zahlen eingeben!");
            }
        });
        add(addButton, BorderLayout.CENTER);

        // Ergebnisanzeige (SOUTH)
        ergebnisLabel = new JLabel("Ergebnis: –");
        ergebnisLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));
        add(ergebnisLabel, BorderLayout.SOUTH);

        pack();
        setMinimumSize(new Dimension(320, 180));
        setLocationRelativeTo(null);
    }
}
