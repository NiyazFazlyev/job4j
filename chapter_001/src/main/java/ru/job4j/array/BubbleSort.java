package ru.job4j.array;

/**
 * Сортировка пузырьком.
 *
 * @author Niyaz Fazlyev
 * @since 12.06.2019
 */
public class BubbleSort {
    /**
     * Метод сортировки пузырьком.
     *
     * @param array Массив.
     * @return Отсортированный в порядке возрастания массив.
     */
    public int[] sort(int[] array) {
        int temp;
        for (int i = 0; i != array.length; i++) {
            for (int j = 0; j != array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }
}
