package ru.job4j.array;

/**
 * @author Niyaz Fazlyev
 * @since 12.06.2019
 */

public class Matrix {
    /**
     * Построение таблицы умножения.
     * @param size Размер таблицы.
     * @return Таблицу умножедия.
     */
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 0; i != size; i++) {
            for (int j = 0; j != size; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }
        return table;
    }
}