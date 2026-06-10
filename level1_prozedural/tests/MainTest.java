package level1_prozedural.tests;

import level1_prozedural.Main;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit-Tests für level1_prozedural.Main.
 *
 * Da die gesamte Logik in der main-Methode steckt, werden System.in und
 * System.out vor jedem Test ersetzt und danach wiederhergestellt.
 */
class MainTest {

    private final InputStream originalIn  = System.in;
    private final PrintStream originalOut = System.out;

    private ByteArrayOutputStream capturedOut;

    @BeforeEach
    void setUp() {
        capturedOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(capturedOut));
    }

    @AfterEach
    void tearDown() {
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    // Hilfsmethode: simuliert Tastatureingabe und gibt die Programmausgabe zurück
    private String run(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Main.main(new String[]{});
        return capturedOut.toString();
    }

    // -----------------------------------------------------------------------
    // Addition
    // -----------------------------------------------------------------------

    @Test
    void addition_ganzeZahlen() {
        // Auswahl 1, Zahlen 3 und 5 → Ergebnis 8.0
        String ausgabe = run("1\n3\n5\n");
        assertTrue(ausgabe.contains("3.0 + 5.0 = 8.0"),
                "Erwartet: '3.0 + 5.0 = 8.0', tatsächlich:\n" + ausgabe);
    }

    @Test
    void addition_negativerSummand() {
        String ausgabe = run("1\n-4\n10\n");
        assertTrue(ausgabe.contains("-4.0 + 10.0 = 6.0"),
                "Erwartet: '-4.0 + 10.0 = 6.0', tatsächlich:\n" + ausgabe);
    }

    @Test
    void addition_beideSummandenNull() {
        String ausgabe = run("1\n0\n0\n");
        assertTrue(ausgabe.contains("0.0 + 0.0 = 0.0"),
                "Erwartet: '0.0 + 0.0 = 0.0', tatsächlich:\n" + ausgabe);
    }

    // -----------------------------------------------------------------------
    // Subtraktion
    // -----------------------------------------------------------------------

    @Test
    void subtraktion_normaleZahlen() {
        String ausgabe = run("2\n10\n4\n");
        assertTrue(ausgabe.contains("10.0 - 4.0 = 6.0"),
                "Erwartet: '10.0 - 4.0 = 6.0', tatsächlich:\n" + ausgabe);
    }

    @Test
    void subtraktion_ergebnisNegativ() {
        String ausgabe = run("2\n3\n7\n");
        assertTrue(ausgabe.contains("3.0 - 7.0 = -4.0"),
                "Erwartet: '3.0 - 7.0 = -4.0', tatsächlich:\n" + ausgabe);
    }

    // -----------------------------------------------------------------------
    // Multiplikation
    // -----------------------------------------------------------------------

    @Test
    void multiplikation_normaleZahlen() {
        String ausgabe = run("3\n6\n7\n");
        assertTrue(ausgabe.contains("6.0 * 7.0 = 42.0"),
                "Erwartet: '6.0 * 7.0 = 42.0', tatsächlich:\n" + ausgabe);
    }

    @Test
    void multiplikation_mitNull() {
        String ausgabe = run("3\n99\n0\n");
        assertTrue(ausgabe.contains("99.0 * 0.0 = 0.0"),
                "Erwartet: '99.0 * 0.0 = 0.0', tatsächlich:\n" + ausgabe);
    }

    // -----------------------------------------------------------------------
    // Division
    // -----------------------------------------------------------------------

    @Test
    void division_normaleZahlen() {
        String ausgabe = run("4\n10\n2\n");
        assertTrue(ausgabe.contains("10.0 / 2.0 = 5.0"),
                "Erwartet: '10.0 / 2.0 = 5.0', tatsächlich:\n" + ausgabe);
    }

    @Test
    void division_durchNull_zeigt_Fehlermeldung() {
        String ausgabe = run("4\n8\n0\n");
        assertTrue(ausgabe.contains("Division durch 0 ist nicht erlaubt"),
                "Erwartet: Fehlermeldung für Division durch 0, tatsächlich:\n" + ausgabe);
    }

    @Test
    void division_ergibtKommazahl() {
        String ausgabe = run("4\n1\n3\n");
        // 1 / 3 ≈ 0.333...
        assertTrue(ausgabe.contains("1.0 / 3.0 = 0.3333"),
                "Erwartet: Kommazahl ~0.3333, tatsächlich:\n" + ausgabe);
    }

    // -----------------------------------------------------------------------
    // Ungültige Auswahl
    // -----------------------------------------------------------------------

    @Test
    void ungueltigeAuswahl_zeigt_Fehlermeldung() {
        String ausgabe = run("9\n1\n1\n");
        assertTrue(ausgabe.contains("Ungültige Auswahl"),
                "Erwartet: 'Ungültige Auswahl', tatsächlich:\n" + ausgabe);
    }
}
