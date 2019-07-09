package ru.job4j.chess.figures;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class BishopBlackTest {
    @Test
    public void whenBishopMoveThanGiveWay() {
        BishopBlack bishop = new BishopBlack(Cell.F8);
        Cell[] way = bishop.way(Cell.F8, Cell.H6);
        Cell[] expect = new Cell[]{Cell.G7, Cell.H6};
        assertThat(way, is(expect));
    }


}
