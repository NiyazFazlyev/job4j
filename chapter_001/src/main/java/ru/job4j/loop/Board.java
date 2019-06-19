package ru.job4j.loop;

/**
 * Board.
 *
 * @author Niyaz Fazlyev
 * @since 10.06.2019
 */
public class Board {
    /**
     * Построение шахматной доски.
     *
     * @param width  ширина доски.
     * @param height длина доски.
     * @return строку представляющую шахматную доску.
     */
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ((i + j) % 2 == 0) {
                    screen.append("x");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(ln);
        }
        return screen.toString();
    }
}