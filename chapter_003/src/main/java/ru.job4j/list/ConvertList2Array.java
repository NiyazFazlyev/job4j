package ru.job4j.list;

import java.util.List;
import java.util.ListIterator;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = (int) (Math.ceil(
                (double) list.size() / (double) rows)
        );
        int[][] array = new int[rows][cells];
        ListIterator<Integer> itr = list.listIterator();
        while (itr.hasNext()) {
            int index = itr.nextIndex();
            int i = index / cells;
            int j = index % cells;
            array[i][j] = itr.next();
        }
        return array;
    }
}