package ru.job4j.condition;

public class Point {
    /**
     * x и y координаты точки.
     */
    private int x;
    private int y;

    /**
     * Конструктор для установки начальных координат точки.
     *
     * @param first  x координата.
     * @param second y координата.
     */
    public Point(int first, int second) {
        this.x = first;
        this.y = second;
    }
    /**
     * Вычисление расстояния между двумя точками.
     * @param that точка до которой вычисляем расстояние.
     * @return Расстояние.
     */
    public double distance(Point that) {
        return Math.sqrt(Math.pow(that.x - this.x, 2) + Math.pow(that.y - this.y, 2));
    }

    /**
     * Вывод на экран координат точки.
     */
    public void info() {
        System.out.println(String.format("Point[%s, %s]", this.x, this.y));
    }
}