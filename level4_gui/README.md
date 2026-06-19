# Level 4.0 / 4.1 – Grafische Benutzeroberfläche (GUI)

> **Hinweis zur Struktur:** Dieses Level (`level4_gui/`) war ursprünglich das einzige
> GUI-Level. Es wurde nachträglich in zwei Stufen aufgeteilt:
> - `level4_0_gui_basis/` – zeigt den "Aha, es reagiert!"-Moment mit minimalem Code
> - `level4_1_gui_vollausbau/` – der vollständige Taschenrechner mit Layout, Buttons
>   und Rechen-Historie
>
> Dieser Ordner (`level4_gui/`) bleibt unverändert als historische Referenz erhalten.

## Neu (vollständige Liste beider GUI-Level)
- **`JFrame`** – das Programmfenster; `TaschenrechnerFenster extends JFrame` erbt alle
  Fenster-Funktionen
- **GUI-Komponenten** – `JTextField` (Eingabefeld), `JButton` (Knopf), `JLabel` (Text),
  `JTextArea` (mehrzeiliger Text), `JPanel` (unsichtbare Gruppierung)
- **Layout-Manager** – `BorderLayout` (Bereiche NORTH/CENTER/SOUTH), `GridLayout` (Raster),
  `FlowLayout` (Zeile)
- **Ereignissteuerung** – `ActionListener` mit Lambda (`e -> { ... }`); das Programm
  wartet auf Benutzeraktionen statt Schritt für Schritt durchzulaufen
- **`SwingUtilities.invokeLater`** – startet das Fenster im korrekten GUI-Thread
- **`Double.parseDouble()`** + `NumberFormatException` – liest Zahlen aus Textfeldern

## Vergleiche mit dem vorherigen Level

Die Klassen `Grundrechenarten` und `ErweiterteOperationen` sind identisch zu Level 3.0 –
nur `Taschenrechner.java` wird durch `TaschenrechnerFenster.java` ersetzt.
`Scanner` und `println` verschwinden vollständig; an ihre Stelle treten Swing-Komponenten.

## Aufgabe für dich

Ändere den Fenstertitel und die Fenstergröße in `TaschenrechnerFenster.java`.
Füge danach einen weiteren Button hinzu, z. B. für Modulo (`%`).
