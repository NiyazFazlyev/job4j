package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;

public class Direction {
    public static boolean isDiagonal(Cell source, Cell dest) {
        boolean result = false;
        int deltaX = dest.x - source.x;
        int deltaY = dest.y - source.y;
        if (deltaX == deltaY || deltaX == (-deltaY)) {
            result = true;
        }
        return result;
    }

    public static boolean isHorizontal(Cell source, Cell dest) {
        boolean result = false;
        int deltaX = dest.x - source.x;
        int deltaY = dest.y - source.y;
        if (deltaY == 0 && deltaX != 0) {
            result = true;
        }
        return result;
    }

    public static boolean isVertical(Cell source, Cell dest) {
        boolean result = false;
        int deltaX = dest.x - source.x;
        int deltaY = dest.y - source.y;
        if (deltaX == 0 && deltaY != 0) {
            result = true;
        }
        return result;
    }
}
