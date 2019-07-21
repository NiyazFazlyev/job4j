package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class ConvertMatrix2List {
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        int rows = array.length;
        int columns = array[0].length;
        for (int i = 0; i != rows; i++) {
            for (int j = 0; j != columns; j++) {
                list.add(array[i][j]);
            }
        }
        return list;
    }
}
