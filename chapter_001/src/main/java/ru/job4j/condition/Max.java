package ru.job4j.condition;

/**
 * Max
 *
 * @author Niyaz Fazlyev
 * @since 10.06.2019
 */
public class Max {
    /**
     * Максимум двух чисел.
     * @param left Первое число.
     * @param right Второе число.
     * @return Максимум двух чисел.
     */
    public int max(int left, int right) {
        return right > left ? right : left;
    }
}