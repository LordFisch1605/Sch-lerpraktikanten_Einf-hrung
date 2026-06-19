package level4_1_gui_vollausbau;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * LEVEL 4.1 – Klasse: TaschenrechnerFenster (Vollausbau)
 *
 * Aufbauend auf Level 4.0 (Basis-GUI):
 * Das Basis-Fenster wird um alle Operationen und eine Rechen-Historie erweitert.
 *
 * NEU GEGENÜBER LEVEL 4.0
 * ──────────────────────────
 * 1) MEHRERE LAYOUT-MANAGER
 *    Das Fenster verwendet jetzt drei verschiedene Layout-Manager kombiniert:
 *      - BorderLayout  (Haupt-Fenster): NORTH / CENTER / SOUTH
 *      - GridLayout    (Button-Panel):  gleichmäßiges Raster für 6 Buttons
 *      - FlowLayout    (History-Panel): Knopf + Label nebeneinander
 *
 * 2) RECHEN-HISTORIE IN DER GUI (roter Faden zu Level 2.6)
 *    In Level 2.6 haben wir die Historie in einer ArrayList<String> gespeichert
 *    und per for-each in der Konsole ausgegeben. Hier zeigen wir sie in einer
 *    JTextArea – einem mehrzeiligen Textbereich – im Fenster an.
 *    Das schließt den roten Faden: Console (2.6) → GUI (4.1).
 *
 * 3) JSCROLLPANE
 *    Eine JScrollPane umhüllt die JTextArea und fügt automatisch Scrollbalken hinzu,
 *    sobald der Inhalt zu lang wird.
 *
 * Aufbau des Fensters:
 *
 *   +-------------------------------------+
 *   |  Eingabefelder           (NORTH)    |
 *   +-------------------------------------+
 *   |  [+Add] [-Sub] [*Mul]    (CENTER)   |
 *   |  [/Div] [^Pot] [√Wur]               |
 *   |  Ergebnis-Label                     |
 *   +-------------------------------------+
 *   |  [Historie löschen]      (SOUTH)    |
 *   |  ┌──────────────────────────────┐   |
 *   |  │ 3.0 + 4.0 = 7.0            │   |
 *   |  │ 9.0 / 3.0 = 3.0            │   |
 *   |  └──────────────────────────────┘   |
 *   +-------------------------------------+
 */
public class TaschenrechnerFenster extends JFrame {

    private JTextField eingabe1;
    private JTextField eingabe2;
    private JLabel ergebnisLabel;
    private JTextArea historieArea;

    private final Grundrechenarten grundrechenarten;
    private final ErweiterteOperationen erweiterteOperationen;

    // Die Historie – identisch zu Level 2.6, nur die Ausgabe ist jetzt GUI statt Konsole
    private final ArrayList<String> historie;

    public TaschenrechnerFenster() {
        grundrechenarten = new Grundrechenarten();
        erweiterteOperationen = new ErweiterteOperationen();
        historie = new ArrayList<>();

        setTitle("Taschenrechner");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        add(erstelleEingabePanel(), BorderLayout.NORTH);
        add(erstelleMittePanel(), BorderLayout.CENTER);
        add(erstelleHistoriePanel(), BorderLayout.SOUTH);

        pack();
        setMinimumSize(new Dimension(420, 460));
        setLocationRelativeTo(null);
    }

    private JPanel erstelleEingabePanel() {
        JPanel panel = new JPanel(new GridLayout(2, 2, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));

        panel.add(new JLabel("Erste Zahl:"));
        eingabe1 = new JTextField();
        panel.add(eingabe1);

        panel.add(new JLabel("Zweite Zahl:  (nicht nötig bei √x)"));
        eingabe2 = new JTextField();
        panel.add(eingabe2);

        return panel;
    }

    private JPanel erstelleMittePanel() {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(0, 10, 5, 10));

        // GridLayout(2,3): 6 Buttons gleichmäßig in 2 Zeilen × 3 Spalten
        JPanel buttonPanel = new JPanel(new GridLayout(2, 3, 5, 5));

        JButton addButton = new JButton("+ Addieren");
        addButton.addActionListener(e -> {
            double a = leseZahl(eingabe1);
            double b = leseZahl(eingabe2);
            String ausgabe = a + " + " + b + " = " + grundrechenarten.addieren(a, b);
            zeigeUndSpeichere(ausgabe);
        });

        JButton subButton = new JButton("- Subtrahieren");
        subButton.addActionListener(e -> {
            double a = leseZahl(eingabe1);
            double b = leseZahl(eingabe2);
            String ausgabe = a + " - " + b + " = " + grundrechenarten.subtrahieren(a, b);
            zeigeUndSpeichere(ausgabe);
        });

        JButton mulButton = new JButton("* Multiplizieren");
        mulButton.addActionListener(e -> {
            double a = leseZahl(eingabe1);
            double b = leseZahl(eingabe2);
            String ausgabe = a + " * " + b + " = " + grundrechenarten.multiplizieren(a, b);
            zeigeUndSpeichere(ausgabe);
        });

        JButton divButton = new JButton("/ Dividieren");
        divButton.addActionListener(e -> {
            double a = leseZahl(eingabe1);
            double b = leseZahl(eingabe2);
            double ergebnis = grundrechenarten.dividieren(a, b);
            if (Double.isNaN(ergebnis)) {
                ergebnisLabel.setText("Ergebnis: Fehler – Division durch 0!");
            } else {
                zeigeUndSpeichere(a + " / " + b + " = " + ergebnis);
            }
        });

        JButton potButton = new JButton("^ Potenz");
        potButton.addActionListener(e -> {
            double a = leseZahl(eingabe1);
            double b = leseZahl(eingabe2);
            String ausgabe = a + " ^ " + b + " = " + erweiterteOperationen.potenzieren(a, b);
            zeigeUndSpeichere(ausgabe);
        });

        JButton wurzelButton = new JButton("√ Wurzel");
        wurzelButton.addActionListener(e -> {
            double a = leseZahl(eingabe1);
            double ergebnis = erweiterteOperationen.wurzel(a);
            if (Double.isNaN(ergebnis)) {
                ergebnisLabel.setText("Ergebnis: Fehler – Wurzel aus negativer Zahl!");
            } else {
                zeigeUndSpeichere("√" + a + " = " + ergebnis);
            }
        });

        buttonPanel.add(addButton);
        buttonPanel.add(subButton);
        buttonPanel.add(mulButton);
        buttonPanel.add(divButton);
        buttonPanel.add(potButton);
        buttonPanel.add(wurzelButton);

        ergebnisLabel = new JLabel("Ergebnis: –");
        panel.add(buttonPanel, BorderLayout.CENTER);
        panel.add(ergebnisLabel, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel erstelleHistoriePanel() {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEmptyBorder(0, 10, 10, 10), "Rechen-Historie"));

        // FlowLayout für die Knopfleiste über der Historie
        JPanel steuerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton loeschenButton = new JButton("Historie löschen");
        loeschenButton.addActionListener(e -> {
            historie.clear();
            historieArea.setText("");
        });
        steuerPanel.add(loeschenButton);

        // JTextArea: mehrzeiliger Textbereich – wird über eine for-each-Schleife befüllt
        historieArea = new JTextArea(6, 30);
        historieArea.setEditable(false);
        historieArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));

        // JScrollPane fügt automatisch Scrollbalken hinzu, wenn der Text zu lang wird
        JScrollPane scrollPane = new JScrollPane(historieArea);

        panel.add(steuerPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    // Zeigt das Ergebnis im Label und speichert es in der Historie (wie in Level 2.6)
    private void zeigeUndSpeichere(String ausgabe) {
        ergebnisLabel.setText("Ergebnis: " + ausgabe);
        historie.add(ausgabe);
        // for-each aus Level 2.6 – hier baut es den Inhalt der JTextArea auf
        StringBuilder sb = new StringBuilder();
        for (String eintrag : historie) {
            sb.append(eintrag).append("\n");
        }
        historieArea.setText(sb.toString());
    }

    private double leseZahl(JTextField feld) {
        try {
            return Double.parseDouble(feld.getText().replace(",", "."));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Bitte eine gültige Zahl eingeben (z. B. 3 oder 3.14)!",
                    "Ungültige Eingabe",
                    JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }
}
