import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Test;

public class PersonaTest
{
    private Persona yo = new Persona("Mariona", "Nadal Farre",
            LocalDate.of(1980, Month.JULY, 1));
    private Persona tu = new Persona("Mariona", "Nadal Farre",
            LocalDate.of(1980, Month.JULY, 1));

    private Persona pedro = new Persona("Pedro", "Gomez Lopez",
            LocalDate.of(2000, Month.JULY, 23));
    private Persona juan = new Persona("Juan", "Garcia Lopez",
            LocalDate.of(2010, Month.MAY, 4));
    private Persona luz = new Persona("Luz", "Blazquez Lopez",
            LocalDate.of(1963, Month.OCTOBER, 14));

    private Persona pepe = new Persona("Jose", "Ruiz Zaray",
            LocalDate.of(1994, Month.JUNE, 30));
    private Persona pepa = new Persona("Jose", "Ruiz Zaray",
            LocalDate.of(1994, Month.JUNE, 30));

    @Test
    public void coherenciaEqualsTest() {
        assertEquals(yo, tu);
        assertEquals(0, yo.compareTo(tu));

        assertNotEquals(yo, pedro);
        assertNotEquals(0, yo.compareTo(pedro));
    }

    @Test
    public void coherenciaCadenaTest() {
        assertTrue(pedro.compareTo(juan) > 0);
        assertTrue(juan.compareTo(luz) > 0);
        assertTrue(pedro.compareTo(luz) > 0);
    }

    @Test
    public void coherenciaIgualesTest() {
        assertEquals(0, pepa.compareTo(pepe));
        assertEquals(pepe.compareTo(luz), pepa.compareTo(luz));
    }

    @Test
    public void coherenciaDistintosTest() {
        assertTrue(pedro.compareTo(luz) > 0);
        assertTrue(luz.compareTo(pedro) < 0);
    }
}