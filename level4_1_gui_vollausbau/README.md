# Level 4.1 – GUI Vollausbau

## Neu (gegenüber Level 4.0)
- **Mehrere Layout-Manager kombiniert** – `BorderLayout` für das Hauptfenster,
  `GridLayout` für das 2×3-Button-Raster, `FlowLayout` für die Knopfleiste der Historie
- **Alle Rechenarten als Buttons** – Addition, Subtraktion, Multiplikation, Division,
  Potenz, Wurzel; jeder mit eigenem `ActionListener`-Lambda
- **Rechen-Historie in der GUI** – die `ArrayList<String>` aus Level 2.6 lebt jetzt im
  Fenster; `JTextArea` zeigt alle bisherigen Berechnungen, eine for-each-Schleife
  baut den Anzeigetext zusammen (roter Faden: Konsole in 2.6 → GUI hier)
- **`JScrollPane`** – umhüllt die JTextArea und fügt Scrollbalken hinzu, sobald der
  Inhalt zu lang wird
- **`JTitledBorder`** – beschrifteter Rahmen rund um den Historie-Bereich

## Vergleiche mit dem vorherigen Level

Im Diff zu Level 4.0 fällt vor allem das Button-Panel auf: statt einem Button gibt es
jetzt sechs in einem `GridLayout`. Ganz neu ist der `SOUTH`-Bereich mit `historieArea`
und dem „Historie löschen"-Button – der visuelle Abschluss des roten Fadens aus Level 2.6.

## Aufgabe für dich

Füge einen „Historie löschen"-Knopf hinzu (falls noch nicht vorhanden), oder:
erweitere die Historie um eine **Nummerierung** (`1. 3.0 + 4.0 = 7.0`, `2. …`).
Tipp: Nutze dafür den Index beim Befüllen der JTextArea.
