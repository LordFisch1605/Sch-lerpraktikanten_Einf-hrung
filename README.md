# Schülerpraktikanten-Einführung

Stufenweises Java-Lernprojekt anhand eines Taschenrechners – von prozedural bis GUI.
Pro Level wird genau ein neues Konzept eingeführt; jedes Level baut auf dem vorherigen auf
und liegt als eigenstänige, lauffähige Kopie in einem eigenen Ordner.

## Level-Übersicht

| Ordner                     | Konzept                                               |
|----------------------------|-------------------------------------------------------|
| `level1_0_prozedural/`     | Variablen, Datentypen, Scanner, if/else               |
| `level1_1_schleife/`       | while-Schleife, boolean als Ein/Aus-Schalter          |
| `level1_2_exceptions/`     | try/catch, InputMismatchException, Puffer leeren      |
| `level1_3_switch/`         | Switch-Expression mit Pfeil-Syntax, yield             |
| `level2_methoden/`         | Eigene Methoden, Parameter/Rückgabewerte, Math-Klasse |
| `level2_5_tests/`          | Unit-Tests mit JUnit 5, assertEquals, assertThrows    |
| `level2_6_collections/`    | ArrayList, for-each-Schleife, Rechen-Historie         |
| `level3_objektorientiert/` | Klassen, Objekte, Konstruktoren, public/private       |
| `level3_5_interface/`      | Interface, Polymorphie, HashMap, Open/Closed-Prinzip  |
| `level4_0_gui_basis/`      | JFrame, JButton, ActionListener, Lambda, BorderLayout |
| `level4_1_gui_vollausbau/` | GridLayout, FlowLayout, JTextArea, JScrollPane        |

## Roter Faden

```
1.0 Prozedural → 1.1 while → 1.2 Exceptions → 1.3 switch
→ 2.0 Methoden → 2.5 Tests → 2.6 for + Collections (Historie)
→ 3.0 OOP → 3.5 Interface/Polymorphie → 4.0 GUI (Basis) → 4.1 GUI (Vollausbau)
```

Jedes Level ist eine vollständige, standalone-lauffähige Kopie des vorherigen –
der Diff zwischen zwei aufeinanderfolgenden Level zeigt genau das neue Konzept.

## Hinweise

- **Tests:** Das Projekt nutzt `lib/junit-platform-console-standalone-1.11.4.jar`
  (bereits in `.classpath` eingetragen). In Eclipse: Rechtsklick auf `RechnerTest.java`
  → *Run As* → *JUnit Test*.
- **GUI-Level:** Erfordern keine externen Abhängigkeiten; Java Swing ist Teil des JDK.
- **Historische Referenz:** `level4_gui/` ist die ursprüngliche, ungeteilt gebliebene
  GUI-Version und wurde durch `level4_0_gui_basis/` und `level4_1_gui_vollausbau/` ersetzt.

## Branch `archiv`

Enthält Entwurfs-Code aus dem `Beispiele/`-Ordner (Interface-Muster, Switch-Expressions),
der als Referenz aufbewahrt wird, aber nicht Teil der Levels ist.
