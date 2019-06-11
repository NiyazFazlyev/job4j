package ru.job4j.array;

public class Square {
    /**
     * Возводит последовательность натуральных чисел в квадрат.
     *
     * @param bound Максимальное значение, которое нужно возвести в квадрат.
     * @return Последовательность квадратов.
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int i = 0; i != bound; i++) {
            rst[i] = (int) Math.pow(i + 1, 2);
        }
        // заполнить массив через цикл элементами от 1 до bound возведенными в квадрат
        return rst;
    }
}
