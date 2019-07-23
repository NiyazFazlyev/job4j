package ru.job4j.list;

import java.util.List;

public class ConvertList2Array {
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
}