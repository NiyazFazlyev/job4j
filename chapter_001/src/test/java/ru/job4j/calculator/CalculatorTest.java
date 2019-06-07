package ru.job4j.calculator;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Tests for calculator.
 *
 * @author Niyaz Fazlyev
 * @version 1
 * @since 07.06.2019
 */
public class CalculatorTest  {
    /**
     * Test add.
     */
    @Test
    public void whenAddOnePlusOneThenTwo()  {
        Calculator calc = new Calculator();
        double result = calc.add(1D, 1D);
        double expected = 2D;
        assertThat(result, is(expected));
    }

    /**
     * Test subtract.
     */
    @Test
    public void whenSubtractThreeMinusOneThenTwo()  {
        Calculator calc = new Calculator();
        double result = calc.subtract(3D, 1D);
        double expected = 2D;
        assertThat(result, is(expected));
    }

    /**
     * Test div.
     */
    @Test
    public void whenDivSixDivideThreeThenTwo()  {
        Calculator calc = new Calculator();
        double result = calc.div(6D, 3D);
        double expected = 2D;
        assertThat(result, is(expected));
    }

    /**
     * Test multiple.
     */
    @Test
    public void whenMultipleTwoMultiplyFiveThenTen()  {
        Calculator calc = new Calculator();
        double result = calc.multiple(2D, 5D);
        double expected = 10D;
        assertThat(result, is(expected));
    }
}
