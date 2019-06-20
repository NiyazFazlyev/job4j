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
     * @param first Первое число.
     * @param second Второе число.
     * @return Максимум двух чисел.
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }

    /**
     * Максимум трех чисел.
     *
     * @param first  Первое число.
     * @param second Второе число.
     * @param third  Третье число.
     * @return Максимум.
     */
    public int max(int first, int second, int third) {
        return max(
                first,
                max(second, third)
        );
    }

    /**
     * Максимум четырех чисел.
     *
     * @param first  Первое число.
     * @param second Второе число.
     * @param third  Третье число.
     * @param fourth Четвертое число.
     * @return Максимум.
     */
    public int max(int first, int second, int third, int fourth) {
        return max(
                first,
                max(second, third, fourth)
        );
    }
}