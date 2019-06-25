package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayMergeTest {

    @Test
    public void whenFirstLargeThanSecond() {
        ArrayMerge merge = new ArrayMerge();
        int[] firts = {4, 5, 6, 7};
        int[] second = {2, 2, 3};
        int[] expect = {2, 2, 3, 4, 5, 6, 7};
        int[] result = merge.mergeSortArrays(firts, second);
        assertThat(result, is(expect));
    }

    @Test
    public void whenArraysMixed() {
        ArrayMerge merge = new ArrayMerge();
        int[] firts = {2, 5, 6, 7, 9};
        int[] second = {1, 2, 8};
        int[] expect = {1, 2, 2, 5, 6, 7, 8, 9};
        int[] result = merge.mergeSortArrays(firts, second);
        assertThat(result, is(expect));
    }


}
