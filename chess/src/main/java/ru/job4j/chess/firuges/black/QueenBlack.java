package ru.job4j.chess.firuges.black;

import ru.job4j.chess.Direction;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.exceptions.ImpossibleMoveException;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class QueenBlack implements Figure {
    private final Cell position;

    public QueenBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if ((!Direction.isDiagonal(source, dest) && !Direction.isHorizontal(source, dest) && !Direction.isVertical(source, dest))
                || dest.equals(source)) {
            throw new ImpossibleMoveException("Impossible move");
        }
        int deltaX = dest.x - source.x;
        int deltaY = dest.y - source.y;
        int size = deltaX == 0 ? Math.abs(deltaY) : Math.abs(deltaX);
        Cell[] cells = Cell.values();
        Cell[] step = new Cell[size];
        if (Direction.isDiagonal(source, dest)) {
            for (int index = 1; index <= size; index++) {
                step[index - 1] = cells[
                        8 * (source.x + deltaX / size * index)
                                + source.y + deltaY / size * index
                        ];
            }
        }
        if (Direction.isVertical(source, dest)) {
            int direct = deltaY / size;
            for (int index = 1; index <= size; index++) {
                step[index - 1] = cells[8 * source.x + source.y + direct * index];
            }
        }
        if (Direction.isHorizontal(source, dest)) {
            int direct = deltaX / size;
            for (int index = 1; index <= size; index++) {
                step[index - 1] = cells[8 * (source.x + direct * index) + source.y];
            }
        }
        return step;
    }

    @Override
    public Figure copy(Cell dest) {
        return new QueenBlack(dest);
    }


}
