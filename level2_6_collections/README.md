# Level 2.6 – for-Schleife und Collections (Rechen-Historie)

## Neu
Zwei neue Konzepte, die hier gemeinsam eingeführt werden, weil das eine das andere motiviert:

- **`ArrayList<String>`** – eine dynamische Liste, die beliebig viele Einträge speichert
  und automatisch wächst (`add()`, `get()`, `size()`, `clear()`, `isEmpty()`)
- **Generics** – der Typ in spitzen Klammern (`<String>`) legt fest, was in der Liste
  gespeichert werden darf
- **for-each-Schleife** – geht automatisch durch alle Elemente einer Liste,
  ohne dass man selbst einen Index-Zähler verwalten muss:
  `for (String eintrag : liste) { ... }`

## Vergleiche mit dem vorherigen Level

Im Diff zu Level 2.5 fallen drei Dinge auf:
1. Neue Klassenvariable `ArrayList<String> historie` ganz oben in `Main`
2. In `verarbeiteAuswahl()` wird nach jeder Rechnung `historie.add(ausgabe)` aufgerufen
3. Neue Methode `zeigeHistorie()` mit der for-each-Schleife

Der Rest – Rechen-Methoden, Tests, try/catch – ist identisch zu Level 2.5.

## Aufgabe für dich

Ergänze einen Befehl `"n"` (Anzahl), der ausgibt, wie viele Berechnungen bisher
in der Historie gespeichert sind. Nutze dafür `historie.size()`.
