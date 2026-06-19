# Level 3.0 – Objektorientierung

## Neu
- **Klassen in eigenen Dateien** – der Code ist auf drei Dateien aufgeteilt, jede mit einer
  klar abgegrenzten Aufgabe: `Main.java`, `Taschenrechner.java`, `Grundrechenarten.java`,
  `ErweiterteOperationen.java`
- **Objekte erstellen (Instanziierung)** – `new Taschenrechner()` erzeugt ein Objekt;
  der **Konstruktor** (Methode mit demselben Namen wie die Klasse) wird dabei automatisch
  aufgerufen
- **`public` und `private`** – steuern, von wo aus auf Methoden und Felder zugegriffen
  werden darf; `zeigeMenu()` ist `private`, weil nur die Klasse selbst sie braucht
- **Komposition** – `Taschenrechner` hält Objekte von `Grundrechenarten` und
  `ErweiterteOperationen` als Felder – eine Klasse nutzt andere Klassen

**Hinweis zu Kapselung:** Die ausführliche Klasse mit privaten Feldern und
Getter-Methoden wird hier bewusst gezeigt, um den Sinn der Kapselung zu vermitteln.
Eine kürzere Java-Schreibweise für solche Daten-Klassen sind `record`s –
sie kommen in Level 3.5.

## Vergleiche mit dem vorherigen Level

Im Diff zu Level 2.0 fällt auf: `main` ist jetzt nur noch 2 Zeilen lang.
Die gesamte Logik lebt in `Taschenrechner.java`. Schau dir auch an, wie
`Grundrechenarten` als Objekt (`new Grundrechenarten()`) erzeugt wird,
statt wie in Level 2.0 als Sammlung statischer Methoden zu existieren.

## Aufgabe für dich

Füge in `Grundrechenarten.java` eine Methode `modulo(double a, double b)` hinzu,
die den Rest einer Division (`a % b`) zurückgibt. Ergänze dann das Menü in
`Taschenrechner.java` um Option 7 für Modulo.

Beobachte dabei: Wie viele Stellen im Code musst du anfassen?
