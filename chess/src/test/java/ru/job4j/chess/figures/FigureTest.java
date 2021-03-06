package ru.job4j.chess.figures;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.*;
import ru.job4j.chess.firuges.exceptions.ImpossibleMoveException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class FigureTest {
    @Test
    public void whenPawnMoves() {
        PawnBlack pawn = new PawnBlack(Cell.F7);
        Cell[] way = pawn.way(Cell.F7, Cell.F6);
        Cell[] expect = new Cell[]{Cell.F6};
        assertThat(way, is(expect));
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenPawnMovesWrong() {
        PawnBlack pawn = new PawnBlack(Cell.F7);
        Cell[] way = pawn.way(Cell.F7, Cell.E6);
    }

    @Test
    public void whenBishopMovesDiag() {
        BishopBlack bishop = new BishopBlack(Cell.F8);
        Cell[] way = bishop.way(Cell.F8, Cell.H6);
        Cell[] expect = new Cell[]{Cell.G7, Cell.H6};
        assertThat(way, is(expect));
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenBishopMovesNoDiag() {
        BishopBlack bishop = new BishopBlack(Cell.F8);
        Cell[] way = bishop.way(Cell.F8, Cell.H4);
    }

    @Test
    public void whenKingMoves() {
        KingBlack king = new KingBlack(Cell.F7);
        Cell[] way = king.way(Cell.F7, Cell.E8);
        Cell[] expect = new Cell[]{Cell.E8};
        assertThat(way, is(expect));
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenKingMovesWrong() {
        KingBlack king = new KingBlack(Cell.F7);
        Cell[] way = king.way(Cell.F7, Cell.A8);
    }

    @Test
    public void whenRookMovesVertical() {
        RookBlack king = new RookBlack(Cell.F7);
        Cell[] way = king.way(Cell.F7, Cell.F1);
        Cell[] expect = new Cell[]{Cell.F6, Cell.F5, Cell.F4, Cell.F3, Cell.F2, Cell.F1};
        assertThat(way, is(expect));
    }

    @Test
    public void whenRookMovesHorizontal() {
        RookBlack king = new RookBlack(Cell.F6);
        Cell[] way = king.way(Cell.F6, Cell.A6);
        Cell[] expect = new Cell[]{Cell.E6, Cell.D6, Cell.C6, Cell.B6, Cell.A6};
        assertThat(way, is(expect));
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenRookMovesWrong() {
        RookBlack king = new RookBlack(Cell.F6);
        Cell[] way = king.way(Cell.F6, Cell.A4);
    }

    @Test
    public void whenKnightMove() {
        KnightBlack knight = new KnightBlack(Cell.F6);
        Cell[] way = knight.way(Cell.F6, Cell.E4);
        Cell[] expect = new Cell[]{Cell.E4};
        assertThat(way, is(expect));
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenKnightMovesWrong() {
        KnightBlack knight = new KnightBlack(Cell.F6);
        Cell[] way = knight.way(Cell.F6, Cell.E2);
    }

    @Test
    public void whenQueenMovesVertical() {
        QueenBlack queen = new QueenBlack(Cell.F7);
        Cell[] way = queen.way(Cell.F7, Cell.F1);
        Cell[] expect = new Cell[]{Cell.F6, Cell.F5, Cell.F4, Cell.F3, Cell.F2, Cell.F1};
        assertThat(way, is(expect));
    }

    @Test
    public void whenQueenMovesHorizontal() {
        QueenBlack queen = new QueenBlack(Cell.F6);
        Cell[] way = queen.way(Cell.F6, Cell.A6);
        Cell[] expect = new Cell[]{Cell.E6, Cell.D6, Cell.C6, Cell.B6, Cell.A6};
        assertThat(way, is(expect));
    }

    @Test
    public void whenQueenMovesDiag() {
        QueenBlack queen = new QueenBlack(Cell.F8);
        Cell[] way = queen.way(Cell.F8, Cell.H6);
        Cell[] expect = new Cell[]{Cell.G7, Cell.H6};
        assertThat(way, is(expect));
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenQueenMovesWrong() {
        QueenBlack queen = new QueenBlack(Cell.F8);
        Cell[] way = queen.way(Cell.F8, Cell.H5);
    }
}
