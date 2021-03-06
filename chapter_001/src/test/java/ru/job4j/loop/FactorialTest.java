package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FactorialTest {
    @Test
    public void whenCalculateFactorialForFiveThenOneHundredTwenty() {
        Factorial fact = new Factorial();
        assertThat(fact.calc(5), is(120));
        //напишите здесь тест, проверяющий, что факториал для числа 5 равен 120.
    }

    @Test
    public void whenCalculateFactorialForZeroThenOne() {
        Factorial fact = new Factorial();
        assertThat(fact.calc(0), is(1));
        //напишите здесь тест, проверяющий, что факториал для числа 0 равен 1.
    }
}