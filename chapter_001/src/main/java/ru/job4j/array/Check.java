package ru.job4j.array;

public class Check {
    /**
     * Проверка всех элементов на истинность.
     *
     * @param data Массив.
     * @return true - все элементы true, false - имеется хоть один false.
     */
    public boolean mono(boolean[] data) {
        boolean result = true;
        for (int i = 1; i != data.length; i++) {
            if (data[i] != data[0]) {
                result = false;
                break;
            }
        }
        return result;
    }
}