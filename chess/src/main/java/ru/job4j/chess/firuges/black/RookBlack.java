package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.ImpossibleMoveException;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class RookBlack implements Figure {
    private final Cell position;

    public RookBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        int deltaX = dest.x - source.x;
        int deltaY = dest.y - source.y;
        if (((deltaX != 0) && (deltaY != 0)) || dest.equals(source)) {
            throw new ImpossibleMoveException("Impossible move");
        }
        int size = deltaX == 0 ? Math.abs(deltaY) : Math.abs(deltaX);
        int direct = deltaX == 0 ? deltaY / size : deltaX / size;
        Cell[] step = new Cell[size];
        if (deltaX == 0) {
            for (int index = 1; index <= size; index++) {
                step[index - 1] = Cell.values()[8 * source.x + source.y + direct * index];
            }
        }
        if (deltaY == 0) {
            for (int index = 1; index <= size; index++) {
                step[index - 1] = Cell.values()[8 * (source.x + direct * index) + source.y];
            }
        }
        return step;
    }

    @Override
    public Figure copy(Cell dest) {
        return new RookBlack(dest);
    }
}
