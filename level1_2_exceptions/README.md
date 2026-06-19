# Level 1.2 – Exception Handling

## Neu
- **`try`-Block** – umschließt Code, der einen Fehler auslösen könnte
- **`catch`-Block** – reagiert auf einen bestimmten Fehlertyp, ohne dass das Programm abstürzt
- **`InputMismatchException`** – wird vom Scanner geworfen, wenn die Eingabe nicht zum
  erwarteten Typ passt (z. B. Buchstabe statt Zahl)
- **Eingabe-Puffer leeren** – `scanner.nextLine()` im `catch`-Block entfernt die fehlerhafte
  Eingabe, damit die nächste Runde sauber startet

## Vergleiche mit dem vorherigen Level

Im Vergleich zu Level 1.1 ändert sich nur der Bereich, in dem `scanner.nextInt()` aufgerufen
wird: Er ist jetzt von `try { ... } catch (InputMismatchException e) { ... }` umgeben.
Der Rest des Codes bleibt komplett gleich.

## Aufgabe für dich

Das Programm fängt jetzt `InputMismatchException` ab. Was ist der Unterschied zwischen
einer **geprüften Exception** (checked) und einer **ungeprüften Exception** (unchecked)?
Zu welcher Kategorie gehört `InputMismatchException`?

(Tipp: Schau in die Java-Dokumentation unter `java.util.InputMismatchException`.)
