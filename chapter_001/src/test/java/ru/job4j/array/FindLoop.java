package ru.job4j.array;

public class FindLoop {
    /**
     * Поиск перебора элемента в массиве.
     *
     * @param data Массив в котором производится поиск.
     * @param el   Значение, которое необходимо найти.
     * @return Индекс под которым находится элемент в массиве, -1 если элемент не найден.
     */
    public int indexOf(int[] data, int el) {
        int rst = -1; // если элемента нет в массиве, то возвращаем -1.
        for (int index = 0; index != data.length; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}