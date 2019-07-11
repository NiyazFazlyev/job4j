package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.ImpossibleMoveException;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        if ((!isDiagonal(source, dest)) || dest.equals(source)) {
            throw new ImpossibleMoveException("No diagonal");
        }
        int deltaX = dest.x - source.x;
        int deltaY = dest.y - source.y;
        int size = Math.abs(deltaX);
        Cell[] cells = Cell.values();
        Cell[] steps = new Cell[size];
        for (int index = 1; index <= size; index++) {
            steps[index - 1] = cells[
                    8 * (source.x + deltaX / size * index)
                            + source.y + deltaY / size * index
                    ];
        }
        return steps;
    }

    private boolean isDiagonal(Cell source, Cell dest) {
        boolean result = false;
        int deltaX = dest.x - source.x;
        int deltaY = dest.y - source.y;
        if (deltaX == deltaY || deltaX == (-deltaY)) {
            result = true;
        }
        return result;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
