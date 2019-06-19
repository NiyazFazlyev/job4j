package ru.job4j.loop;

public class Counter {
    /**
     * Сумма четных чисел в промежутке.
     *
     * @param start  Начала промежутка.
     * @param finish Конец промежутка.
     * @return Сумма.
     */
    public int add(int start, int finish) {
        int sum = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}