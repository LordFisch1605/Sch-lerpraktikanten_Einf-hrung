package level4_gui;

import javax.swing.*;
import java.awt.*;

/**
 * LEVEL 4 â€“ Klasse: TaschenrechnerFenster
 *
 * Diese Klasse ist das HerzstÃ¼ck der GUI. Sie erbt von JFrame ("extends JFrame"),
 * wodurch sie selbst ein Fenster ist und alle Fenster-Funktionen mitbringt.
 *
 * Aufbau des Fensters (BorderLayout):
 *
 *   +-----------------------------+
 *   |  Eingabefelder  (NORTH)    |
 *   +-----------------------------+
 *   |  OperationsknÃ¶pfe (CENTER) |
 *   +-----------------------------+
 *   |  Ergebnisanzeige (SOUTH)  |
 *   +-----------------------------+
 *
 * Die Rechen-Logik liegt weiterhin in Grundrechenarten und ErweiterteOperationen â€“
 * genau wie in Level 3. TaschenrechnerFenster ersetzt nur die Klasse Taschenrechner
 * und tauscht Scanner/println durch grafische Komponenten aus.
 */
public class TaschenrechnerFenster extends JFrame {

    // Eingabefelder, in die der Benutzer Zahlen tippt
    private JTextField eingabe1;
    private JTextField eingabe2;

    // Label, das das Ergebnis anzeigt (nicht bearbeitbar)
    private JLabel ergebnisLabel;

    // Die Rechen-Objekte â€“ identisch zu Level 3
    private Grundrechenarten grundrechenarten;
    private ErweiterteOperationen erweiterteOperationen;

    // Der Konstruktor baut das gesamte Fenster auf
    public TaschenrechnerFenster() {
        grundrechenarten = new Grundrechenarten();
        erweiterteOperationen = new ErweiterteOperationen();

        setTitle("Taschenrechner");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Programm endet beim SchlieÃŸen des Fensters
        setLayout(new BorderLayout(10, 10));             // 10px Abstand zwischen den Bereichen

        // Die drei Bereiche werden in eigenen Methoden gebaut und dann ins Fenster eingefÃ¼gt
        add(erstelleEingabePanel(), BorderLayout.NORTH);
        add(erstelleButtonPanel(), BorderLayout.CENTER);
        add(erstelleErgebnisPanel(), BorderLayout.SOUTH);

        pack();                        // FenstergrÃ¶ÃŸe automatisch an den Inhalt anpassen
        setMinimumSize(new Dimension(380, 260));
        setLocationRelativeTo(null);   // Fenster in der Mitte des Bildschirms anzeigen
    }

    // Baut den oberen Bereich mit den zwei Eingabefeldern
    private JPanel erstelleEingabePanel() {
        // GridLayout(2, 2): 2 Zeilen, 2 Spalten â€“ links das Label, rechts das Textfeld
        JPanel panel = new JPanel(new GridLayout(2, 2, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10)); // Innenabstand

        panel.add(new JLabel("Erste Zahl:"));
        eingabe1 = new JTextField();
        panel.add(eingabe1);

        panel.add(new JLabel("Zweite Zahl:  (nicht nÃ¶tig bei âˆš)"));
        eingabe2 = new JTextField();
        panel.add(eingabe2);

        return panel;
    }

    // Baut den mittleren Bereich mit allen OperationsknÃ¶pfen
    private JPanel erstelleButtonPanel() {
        // GridLayout(2, 3): 2 Zeilen, 3 Spalten â†’ 6 KnÃ¶pfe gleichmÃ¤ÃŸig angeordnet
        JPanel panel = new JPanel(new GridLayout(2, 3, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        // FÃ¼r jeden Knopf: erstellen, ActionListener hinzufÃ¼gen, zum Panel hinzufÃ¼gen.
        // Der ActionListener ist ein Lambda (e -> { ... }), der beim Klick ausgefÃ¼hrt wird.

        JButton addButton = new JButton("+ Addieren");
        addButton.addActionListener(e -> {
            double a = leseZahl(eingabe1);
            double b = leseZahl(eingabe2);
            zeigeErgebnis(a + " + " + b + " = " + grundrechenarten.addieren(a, b));
        });

        JButton subButton = new JButton("âˆ’ Subtrahieren");
        subButton.addActionListener(e -> {
            double a = leseZahl(eingabe1);
            double b = leseZahl(eingabe2);
            zeigeErgebnis(a + " âˆ’ " + b + " = " + grundrechenarten.subtrahieren(a, b));
        });

        JButton mulButton = new JButton("Ã— Multiplizieren");
        mulButton.addActionListener(e -> {
            double a = leseZahl(eingabe1);
            double b = leseZahl(eingabe2);
            zeigeErgebnis(a + " Ã— " + b + " = " + grundrechenarten.multiplizieren(a, b));
        });

        JButton divButton = new JButton("Ã· Dividieren");
        divButton.addActionListener(e -> {
            double a = leseZahl(eingabe1);
            double b = leseZahl(eingabe2);
            if (b == 0) {
                zeigeErgebnis("Fehler: Division durch 0 ist nicht erlaubt!");
            } else {
                zeigeErgebnis(a + " Ã· " + b + " = " + grundrechenarten.dividieren(a, b));
            }
        });

        JButton potButton = new JButton("xÊ¸ Potenz");
        potButton.addActionListener(e -> {
            double a = leseZahl(eingabe1);
            double b = leseZahl(eingabe2);
            zeigeErgebnis(a + " ^ " + b + " = " + erweiterteOperationen.potenzieren(a, b));
        });

        JButton wurzelButton = new JButton("âˆš Wurzel");
        wurzelButton.addActionListener(e -> {
            double a = leseZahl(eingabe1);
            if (a < 0) {
                zeigeErgebnis("Fehler: Wurzel aus negativer Zahl nicht erlaubt!");
            } else {
                zeigeErgebnis("âˆš" + a + " = " + erweiterteOperationen.wurzel(a));
            }
        });

        panel.add(addButton);
        panel.add(subButton);
        panel.add(mulButton);
        panel.add(divButton);
        panel.add(potButton);
        panel.add(wurzelButton);

        return panel;
    }

    // Baut den unteren Bereich, der das Ergebnis anzeigt
    private JPanel erstelleErgebnisPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));
        ergebnisLabel = new JLabel("Ergebnis: â€“");
        panel.add(ergebnisLabel);
        return panel;
    }

    // Liest eine Zahl aus einem Textfeld aus.
    // Falls die Eingabe keine gÃ¼ltige Zahl ist, wird ein Fehlerfenster angezeigt.
    // try/catch fÃ¤ngt den Fehler ab, damit das Programm nicht abstÃ¼rzt.
    private double leseZahl(JTextField feld) {
        try {
            return Double.parseDouble(feld.getText().replace(",", "."));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                "Bitte eine gÃ¼ltige Zahl eingeben (z.B. 3 oder 3.14)!",
                "UngÃ¼ltige Eingabe",
                JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }

    // Aktualisiert den Ergebnis-Text im unteren Bereich des Fensters
    private void zeigeErgebnis(String text) {
        ergebnisLabel.setText("Ergebnis: " + text);
    }
}
