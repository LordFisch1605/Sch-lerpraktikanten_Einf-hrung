# Level 4.0 – GUI Basis

> **Hinweis zur Struktur:**
> Das GUI-Level wurde in zwei Stufen aufgeteilt, um den Einstieg zu erleichtern.
> Dieser Ordner (`level4_0_gui_basis/`) enthält die minimale Version –
> der vollständige Taschenrechner mit allen Buttons und Historie folgt in
> `level4_1_gui_vollausbau/`.

## Neu
- **`JFrame`** – das Programmfenster; `extends JFrame` erbt alle Fenster-Fähigkeiten
- **GUI-Komponenten** – `JTextField` (Eingabefeld), `JButton` (Knopf), `JLabel` (Text),
  `JPanel` (Gruppierung)
- **`BorderLayout`** – teilt das Fenster in Bereiche: NORTH, CENTER, SOUTH
- **`GridLayout`** – ordnet Komponenten in einem Raster an (hier: 2×2 für die Eingaben)
- **ActionListener mit Lambda** – `button.addActionListener(e -> { ... })` reagiert auf
  den Klick; das Programm läuft nicht mehr von oben nach unten, sondern wartet auf
  Ereignisse (ereignisgesteuerte Programmierung)
- **`SwingUtilities.invokeLater`** – startet das Fenster im korrekten GUI-Thread (EDT)
- **`Double.parseDouble()`** + `NumberFormatException` – liest Zahlen aus dem Textfeld

## Vergleiche mit dem vorherigen Level

In Level 3.5 gab es `Scanner` und `System.out.println` – beides ist jetzt weg.
Im Diff siehst du, dass `Taschenrechner.java` komplett durch `TaschenrechnerFenster.java`
ersetzt wird. Die Rechen-Logik (hier: nur Addition direkt im Lambda) bleibt die gleiche.

## Aufgabe für dich

1. Ändere den Fenstertitel (zweite Zeile im Konstruktor) und die Startgröße (`setMinimumSize`).
2. Füge einen zweiten Button `"- Subtrahieren"` hinzu, der die Differenz anzeigt.
   (Tipp: Du brauchst einen zweiten `JButton` mit eigenem `addActionListener`.)
