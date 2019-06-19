package ru.job4j.condition;

/**
 * MultiMax
 *
 * @author Niyaz Fazlyev
 */
public class MultiMax {
    /**
     * Поиск максимального числа из трех.
     * @param first первое число
     * @param second второе число
     * @param third третье число
     * @return максимальное число
     */
    public int max(int first, int second, int third) {
        int result = first > second ? first : second;
        result = result > third ? result : third;
        return result;
    }
}