package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.junit.Assert.assertThat;

public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate duplicate = new ArrayDuplicate();
        String[] input = {"1", "1", "2", "2", "3", "3"};
        String[] result = duplicate.remove(input);
        String[] expect = {"1", "2", "3"};
        assertThat(result, arrayContainingInAnyOrder(expect));
    }

    @Test
    public void whenArrayContainSameElementsThenRemainOneElement() {
        ArrayDuplicate duplicate = new ArrayDuplicate();
        String[] input = {"1", "1", "1", "1"};
        String[] result = duplicate.remove(input);
        String[] expect = {"1"};
        assertThat(result, arrayContainingInAnyOrder(expect));
    }

}