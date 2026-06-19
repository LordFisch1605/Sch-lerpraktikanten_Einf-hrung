package level2_5_tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * LEVEL 2.5 – Automatisierte Tests mit JUnit 5
 *
 * WAS SIND UNIT-TESTS?
 * ────────────────────
 * Ein Unit-Test prüft automatisch, ob eine einzelne Methode das richtige
 * Ergebnis liefert. Statt das Programm zu starten und selbst nachzurechnen,
 * lässt man das der Computer tun – schnell, wiederholbar und fehlerfrei.
 *
 * AUFBAU EINES TESTS (@Test-Methode)
 * ────────────────────────────────────
 *   @Test          → markiert die Methode als Test; JUnit führt sie automatisch aus
 *   assertEquals   → prüft: ist der erwartete Wert gleich dem tatsächlichen Wert?
 *                    3. Parameter (delta): erlaubte Abweichung für double-Vergleiche
 *                    (Fließkommazahlen sind nicht immer 100 % exakt)
 *   assertThrows   → prüft, dass eine bestimmte Exception geworfen wird
 *
 * WIE LAUFEN DIE TESTS?
 * ─────────────────────
 * In Eclipse: Rechtsklick auf RechnerTest.java → Run As → JUnit Test
 * Im Terminal (mit dem JAR aus lib/):
 *   java -jar lib/junit-platform-console-standalone-1.11.4.jar
 *        --class-path bin --select-class level2_5_tests.RechnerTest
 */
class RechnerTest {

    // ── Grundrechenarten ──────────────────────────────────────────────────────

    @Test
    void addierenPositiveZahlen() {
        assertEquals(7.0, Main.addieren(3, 4), 0.0001);
    }

    @Test
    void addierenMitNegativerZahl() {
        assertEquals(1.0, Main.addieren(4, -3), 0.0001);
    }

    @Test
    void subtrahieren() {
        assertEquals(5.0, Main.subtrahieren(9, 4), 0.0001);
    }

    @Test
    void multiplizieren() {
        assertEquals(12.0, Main.multiplizieren(3, 4), 0.0001);
    }

    @Test
    void dividieren() {
        assertEquals(2.5, Main.dividieren(5, 2), 0.0001);
    }

    // assertThrows prüft, dass die Methode eine ArithmeticException wirft
    @Test
    void dividierenDurchNull() {
        assertThrows(ArithmeticException.class, () -> Main.dividieren(5, 0));
    }

    // ── Erweiterte Operationen ────────────────────────────────────────────────

    @Test
    void potenzieren() {
        assertEquals(8.0, Main.potenzieren(2, 3), 0.0001);
    }

    @Test
    void potenzMitExponentNull() {
        // Jede Zahl hoch 0 ergibt 1
        assertEquals(1.0, Main.potenzieren(99, 0), 0.0001);
    }

    @Test
    void wurzelPositiveZahl() {
        assertEquals(3.0, Main.wurzel(9), 0.0001);
    }

    @Test
    void wurzelNull() {
        assertEquals(0.0, Main.wurzel(0), 0.0001);
    }
}
