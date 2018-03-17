import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    Calculator calc;

    @Before
    public void setUp() throws Exception {
        calc = new Calculator();
    }

    @Test
    public final void whenAnyNumberOfNumbersIsUsedThenReturnValuesAreTheirSums() {
        assertEquals(3+6+15+18+46+33, calc.Add("3,6,15,18,46,33"));
    }

    @Test
    public final void whenDelimiterIsSpecifiedThenItIsUsedToSeparateNumbers() {
        assertEquals(3+6+15, calc.Add("//;n3;6;15"));
    }

    @Test
    public final void whenNewLineIsUsedBetweenNumbersThenReturnValuesAreTheirSums() {
        assertEquals(3+6+15, calc.Add("3,6n15"));
    }

    @Test
    public final void when2NumbersAreUsedThenNoExceptionIsThrown() {
        calc.Add("1,2");
        assertTrue(true);
    }

    @Test(expected = RuntimeException.class)
    public final void whenNonNumberIsUsedThenExceptionIsThrown() {
        calc.Add("1,X");
    }

    @Test
    public final void whenEmptyStringIsUsedThenReturnValueIs0() {
        assertEquals(0, calc.Add(""));
    }

    @Test
    public final void whenOneNumberIsUsedThenReturnValueIsThatSameNumber() {
        assertEquals(3, calc.Add("3"));
    }

    @Test
    public final void whenTwoNumbersAreUsedThenReturnValueIsTheirSum() {
        assertEquals(3+6, calc.Add("3,6"));
    }

    @Test(expected = RuntimeException.class)
    public final void whenNegativeNumberIsUsedThenRuntimeExceptionIsThrown() {
        calc.Add("3,-6,15,18,46,33");
    }
    @Test
    public final void whenNegativeNumbersAreUsedThenRuntimeExceptionIsThrown() {
        RuntimeException exception = null;
        try {
            calc.Add("3,-6,15,-18,46,33");
        } catch (RuntimeException e) {
            exception = e;
        }
        assertNotNull(exception);
        assertEquals("Negatives not allowed: [-6, -18]", exception.getMessage());
    }

}