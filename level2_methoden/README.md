# Level 2.0 – Methoden

## Neu
- **Eigene Methoden** – der Code wird in benannte Einzelfunktionen aufgeteilt
  (`addieren`, `subtrahieren`, `multiplizieren`, `dividieren`, `potenzieren`, `wurzel`)
- **Parameter & Rückgabewerte** – Methoden bekommen Werte übergeben und liefern ein
  Ergebnis zurück (`double addieren(double a, double b)`)
- **Klasse `Math`** – Java-Standardbibliothek für mathematische Funktionen:
  `Math.pow()` für Potenzen, `Math.sqrt()` für Wurzeln
- **Neue Operationen** – Potenz (`x^y`) und Wurzel (`√x`) kommen dazu

**Synthese-Moment:** Die Methoden aus diesem Level fassen `while`-Schleife,
`try/catch` und die Rechen-Logik in einer sauberen Struktur zusammen.
Besonders `verarbeiteAuswahl(int auswahl, Scanner scanner)` zeigt, wie man
eine längere Aufgabe aus `main` auslagern kann – das Prinzip, das in Level 3
konsequent auf Klassen ausgeweitet wird.

## Vergleiche mit dem vorherigen Level

In Level 1.2 stand die gesamte Logik in `main`. Im Diff zu diesem Level siehst du,
dass `main` jetzt sehr kurz ist – sie delegiert die eigentliche Arbeit an eigene Methoden.

## Aufgabe für dich

Die Methoden `addieren`, `subtrahieren` usw. sind als `static` deklariert.
Was bedeutet `static`? Und warum fehlt das Schlüsselwort `static` in Level 3,
wo dieselben Methoden in einer Klasse stehen?
