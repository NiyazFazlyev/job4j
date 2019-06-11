package ru.job4j.array;

public class Check {
    /**
     * Проверка всех элементов на истинность.
     *
     * @param data Массив.
     * @return true - все элементы true, false - имеется хоть один false.
     */
    public boolean mono(boolean[] data) {
        boolean result = false;
        for (int i = 0; i != data.length; i++) {
            result = true;
            if (!data[i]) {
                result = false;
                break;
            }

        }
        return result;
    }
}