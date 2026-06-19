# Level 2.5 – Unit-Tests mit JUnit 5

## Neu
- **Unit-Tests** – automatisierte Prüfungen einzelner Methoden; das Programm selbst
  muss dafür nicht gestartet werden
- **`@Test`** – markiert eine Methode als Testfall; JUnit führt alle `@Test`-Methoden
  automatisch aus
- **`assertEquals(erwartet, tatsächlich, delta)`** – prüft, ob zwei Werte gleich sind;
  `delta` ist die erlaubte Abweichung für `double`-Vergleiche (nötig wegen
  Fließkomma-Ungenauigkeiten)
- **`assertThrows`** – prüft, dass eine bestimmte Exception geworfen wird
- **Testfreundliche Implementierung** – `dividieren()` wirft jetzt `ArithmeticException`
  statt den Fehler nur im Aufrufer abzufangen; das macht den Fehlerfall direkt testbar

## Build-System

Dieses Level verwendet **kein separates Build-System** (kein Maven, kein Gradle).
Das JUnit-5-JAR liegt bereits im Projekt unter `lib/junit-platform-console-standalone-1.11.4.jar`
und ist in `.classpath` eingetragen – Eclipse erkennt es automatisch.

**Tests in Eclipse ausführen:**
Rechtsklick auf `RechnerTest.java` → *Run As* → *JUnit Test*

**Tests im Terminal ausführen** (aus dem Projektordner, nach `javac`-Kompilierung):
```
java -jar lib/junit-platform-console-standalone-1.11.4.jar ^
     --class-path bin --select-class level2_5_tests.RechnerTest
```

## Vergleiche mit dem vorherigen Level

Die Dateien `Main.java` und die Rechen-Methoden sind fast identisch zu Level 2.0.
Die einzige Code-Änderung: `dividieren()` wirft jetzt eine `ArithmeticException`.
Neu dazugekommen ist `RechnerTest.java` – die eigentliche Neuerung dieses Levels.

## Aufgabe für dich

Schreibe einen Test `wurzelNegativeZahl()`, der prüft, was `wurzel(-1)` zurückgibt.
Was erwartest du? Was gibt die Methode aktuell zurück?

Wenn du magst: Ändere `wurzel()` so, dass sie `Double.NaN` zurückgibt statt `0`,
und passe den Test entsprechend an. (`Double.isNaN(wert)` prüft auf NaN.)
