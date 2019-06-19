package ru.job4j.condition;

public class Point {
    /**
     * Вычисление расстояния между двумя точками.
     *
     * @param x1 x-координата первой точки.
     * @param y1 y-координата первой точки.
     * @param x2 x-координата второй точки.
     * @param y2 y-координата второй точки.
     * @return Расстояние.
     */
    public double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
}