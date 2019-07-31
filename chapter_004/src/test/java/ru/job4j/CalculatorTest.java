package ru.job4j;

import org.junit.Test;
import ru.job4j.lambda.Calculator;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CalculatorTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        Calculator function = new Calculator();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        Calculator function = new Calculator();
        List<Double> result = function.diapason(5, 8, x -> x * x + 1);
        List<Double> expected = Arrays.asList(26D, 37D, 50D);
        assertThat(result, is(expected));
    }

//    @Test
//    public void whenLogarithmicFunctionThenLogarithmicResults() {
//        Calculator function = new Calculator();
//        List<Double> result = function.diapason(5, 8, x -> Math.log10(x));
//        List<Double> expected = Arrays.asList(0.7D, 0.78D, 0.85D);
//
//        assertThat(result, closeTo(expected, 0.01));
//    }
}
