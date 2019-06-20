package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {
    @Test
    public void whenMax1To2Then2() {
        Max max = new Max();
        int result = max.max(1, 2);
        assertThat(result, is(2));
    }

    @Test
    public void whenMax2To1Then2() {
        Max max = new Max();
        int result = max.max(2, 1);
        assertThat(result, is(2));
    }

    @Test
    public void whenMax2To2Then2() {
        Max max = new Max();
        int result = max.max(2, 2);
        assertThat(result, is(2));
    }

    @Test
    public void whenMax154Then5() {
        Max max = new Max();
        int result = max.max(1, 5, 4);
        assertThat(result, is(5));
    }

    @Test
    public void whenMax3268To2Then8() {
        Max max = new Max();
        int result = max.max(3, 4, 6, 8);
        assertThat(result, is(8));
    }

}
