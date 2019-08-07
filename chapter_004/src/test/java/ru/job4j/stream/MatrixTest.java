package ru.job4j.stream;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MatrixTest {
    @Test
    public void whenMatrixToArrayThanArray() {
        Integer[][] matrix = new Integer[][]{{1, 2}, {3, 4}};
        List<Integer> result = Matrix.toArray(matrix);
        List<Integer> except = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        assertThat(result, is(except));

    }

}


