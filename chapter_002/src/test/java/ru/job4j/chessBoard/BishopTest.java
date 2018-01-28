package ru.job4j.chessBoard;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BishopTest {
    @Test
    public void firstTest() {
        boolean result = false;
        Cell dest = new Cell(7, 7);
        Board board = new Board();
        Figure bishop = new Bishop(new Cell(0,0));
        board.add(bishop);
        result = board.move(bishop, dest);
        if (result) {
            bishop = bishop.copy(dest);
        }
        assertThat(bishop.position.x, is(7));
        assertThat(bishop.position.y, is(7));
    }
}
