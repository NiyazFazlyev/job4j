package ru.job4j.array;

public class ArrayMerge {
    /**
     * Метод объединяет два отсортированных массива, так что получившийся массив
     * так же будет отсортрован
     *
     * @param first  Певый массив
     * @param second Второй массив
     * @return Объединненый массив
     */

    public int[] MergeSortArrays(int[] first, int[] second) {
        int[] merged = new int[first.length + second.length];
        int i = 0, j = 0;
        while ((i < first.length) && (j < second.length)) {
            if (first[i] > second[j]) {
                merged[i + j] = second[j];
                j++;
            } else {
                merged[i + j] = first[i];
                i++;
            }
        }
        while (i < first.length) {
            merged[i + j] = first[i];
            i++;
        }
        while (j < second.length) {
            merged[i + j] = second[i];
            j++;
        }
        return merged;
    }

}
