package ru.job4j.array;

public class Turn {
    /**
     * Переворачивает входящий массив.
     *
     * @param array Массив.
     * @return Перевернутый массив.
     */
    public int[] back(int[] array) {
        int size = array.length;
        int term;
        for (int i = 0; i < size / 2; i++) {
            term = array[i];
            array[i] = array[size - i - 1];
            array[size - i - 1] = term;
        }
        return array;
    }
}