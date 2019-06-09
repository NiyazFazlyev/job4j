package ru.job4j.condition;

public class SqArea {
    /**
     * Вычисляем площадь прямоугольника.
     * @param p периметр прямоугольника.
     * @param k отношение ширины прямоугольника к длине.
     * @return площадь прямоугольника.
     */
    public int square(int p, int k) {
        int h = p / 2 / (k + 1);
        return k * h * h;
    }
}
