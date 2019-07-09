package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;

public class test {
    public static void main(String[] args) {
        Cell[] cells = Cell.values();
        System.out.println(String.format("x = %s, y = %s", cells[8].x, cells[8].y));

    }

}
