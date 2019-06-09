package ru.job4j.loop;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.assertThat;

public class CounterTest {
    @Test
    public void whenSumEvenNumbersFromOneToTenThenThirty() {
        Counter count = new Counter();
        assertThat(count.add(1, 10), Matchers.is(30));
    }
}