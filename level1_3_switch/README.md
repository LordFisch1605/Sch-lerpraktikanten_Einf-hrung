# Level 1.3 – Switch-Expression

## Neu
- **Switch-Ausdruck (Switch-Expression)** mit Pfeil-Syntax (`case 1 -> ...`) –
  liefert direkt einen Wert zurück, kein `break` nötig
- **`yield`** – gibt in einem mehrzeiligen `case`-Block den Wert des Switch-Ausdrucks zurück
  (entspricht `return`, aber nur innerhalb eines `switch`)
- **Switch-Anweisung vs. Switch-Ausdruck** – der Ausdruck ist kompakter und
  fehlerunanfälliger, weil kein versehentliches "Durchfallen" (fall-through) möglich ist

## Vergleiche mit dem vorherigen Level

Im Diff zu Level 1.2 ersetzt der Switch-Ausdruck die `if / else if`-Kette, die die
Rechenart ausgewählt hat. Der Rumpf der Schleife und das `try/catch` bleiben unverändert.
Suche im Diff nach dem Block, der vorher `if (auswahl == 1) { ... } else if ...` war –
er ist jetzt `String ausgabe = switch (auswahl) { ... };`.

## Aufgabe für dich

Füge den Operator `%` (Modulo/Rest einer Division) als neuen `case 5` im Switch-Ausdruck
hinzu und ergänze das Menü entsprechend. Beispiel: `7 % 3 = 1`.
