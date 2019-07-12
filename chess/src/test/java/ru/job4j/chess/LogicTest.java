package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.PawnBlack;
import ru.job4j.chess.firuges.black.RookBlack;
import ru.job4j.chess.firuges.exceptions.FigureNotFoundException;
import ru.job4j.chess.firuges.exceptions.ImpossibleMoveException;
import ru.job4j.chess.firuges.exceptions.OccupiedWayException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class LogicTest {
    @Test
    public void whenSuccessMove() {
        Logic logic = new Logic();
        PawnBlack pawn = new PawnBlack(Cell.E7);
        logic.add(pawn);
        boolean result = logic.move(Cell.E7, Cell.E6);
        assertThat(result, is(true));
    }

    @Test(expected = FigureNotFoundException.class)
    public void whenFigureNotFound() {
        Logic logic = new Logic();
        PawnBlack pawn = new PawnBlack(Cell.F7);
        logic.add(pawn);
        boolean result = logic.move(Cell.E7, Cell.E6);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenFigureMovesWrong() {
        Logic logic = new Logic();
        PawnBlack pawn = new PawnBlack(Cell.F7);
        logic.add(pawn);
        boolean result = logic.move(Cell.F7, Cell.E6);
    }

    @Test(expected = OccupiedWayException.class)
    public void whenOccupiedWay() {
        Logic logic = new Logic();
        PawnBlack pawn = new PawnBlack(Cell.H7);
        logic.add(pawn);
        RookBlack rook = new RookBlack(Cell.H8);
        logic.add(rook);
        boolean result = logic.move(Cell.H8, Cell.H5);
    }


}
