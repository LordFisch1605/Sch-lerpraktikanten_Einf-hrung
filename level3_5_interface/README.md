# Level 3.5 – Interface und Polymorphie

## Neu
- **Interface** – definiert einen Vertrag (`Operation.java`): jede Klasse, die ihn
  implementiert (`implements Operation`), muss `berechne(double a, double b)` anbieten
- **Polymorphie** – eine Variable vom Typ `Operation` kann zur Laufzeit verschiedene
  konkrete Objekte (Addition, Division, …) halten; `op.berechne(a, b)` ruft automatisch
  die richtige Implementierung auf
- **`HashMap<Integer, Operation>`** – bildet Menü-Nummern auf Operationsobjekte ab;
  ersetzt die if/else- bzw. switch-Kette vollständig
- **Open/Closed-Prinzip** – neue Operationen werden als neue Klasse hinzugefügt, ohne
  bestehende Klassen zu ändern
- **`@Override`** – markiert, dass eine Methode aus einem Interface (oder einer
  Elternklasse) überschrieben wird; der Compiler prüft, ob die Signatur stimmt
- **`record` (Kommentar in `Main.java`)** – Java-Kurzform für Daten-Klassen;
  nicht verwendet, aber erklärt, um den Bezug zu Level 3.0 herzustellen

## Vergleiche mit dem vorherigen Level

Im Diff zu Level 3.0 fällt auf:
- `Grundrechenarten.java` und `ErweiterteOperationen.java` sind verschwunden –
  ersetzt durch je eine Klasse pro Operation (`Addition.java`, `Subtraktion.java`, …)
- `Taschenrechner.java` hat keine if/else-Kette mehr für die Operationsauswahl;
  stattdessen steht dort `operationen.get(auswahl).berechne(a, b)` – eine Zeile
- Neu ist `Operation.java` (das Interface) als gemeinsamer Typ aller Operationsklassen

## Aufgabe für dich

Füge eine neue Operation **Modulo** (`%`, Rest einer Division) hinzu:
1. Lege `Modulo.java` an, die `Operation` implementiert.
2. Registriere sie in `Taschenrechner.java`: `operationen.put(7, new Modulo());`
3. Ergänze das Menü.

Beobachte dabei: Welche **bestehende** Datei wurde **nicht** verändert?
Das ist das Open/Closed-Prinzip in der Praxis.
