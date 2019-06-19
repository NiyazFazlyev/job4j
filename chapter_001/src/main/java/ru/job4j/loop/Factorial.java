package ru.job4j.loop;

public class Factorial {
    /**
     * Вычисление факторила.
     *
     * @param n Число для которого вычислить факториал.
     * @return Факториал.
     */
    public int calc(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * i;
        }
        return result;
    }
}