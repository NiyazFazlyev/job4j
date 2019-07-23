package ru.job4j.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvertList {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = (int) (Math.ceil(
                (double) list.size() / (double) rows)
        );
        int[][] array = new int[rows][cells];
        int index = 0;
        for (int value : list) {
            int i = index / cells;
            int j = index % cells;
            array[i][j] = value;
            index++;
        }
        return array;
    }

    public List<Integer> convert(List<Integer[]> list) {
        List<Integer> result = new ArrayList<Integer>();
        for (Integer[] array : list) {
            result.addAll(Arrays.asList(array));
        }
        return result;
    }
}