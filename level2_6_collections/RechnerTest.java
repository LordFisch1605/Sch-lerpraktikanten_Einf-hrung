package level2_6_collections;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * LEVEL 2.6 – Tests (aus Level 2.5 übernommen + neue Fälle für die Historie)
 *
 * Die Rechen-Methoden sind identisch zu Level 2.5, daher laufen dieselben Tests.
 */
class RechnerTest {

    @Test
    void addieren() {
        assertEquals(7.0, Main.addieren(3, 4), 0.0001);
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

    @Test
    void dividierenDurchNull() {
        assertThrows(ArithmeticException.class, () -> Main.dividieren(5, 0));
    }

    @Test
    void potenzieren() {
        assertEquals(8.0, Main.potenzieren(2, 3), 0.0001);
    }

    @Test
    void wurzelPositiv() {
        assertEquals(3.0, Main.wurzel(9), 0.0001);
    }
}
