package ru.job4j.chessBoard;

public class Bishop extends Figure {
    public Bishop(Cell dest) {
        super(dest);
    }

    @Override
    Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        int sourceX = source.x;
        int sourceY = source.y;
        int destX = dest.x;
        int destY = dest.y;
        for (int i = 1; i < 9; i++) {
            if ((sourceX == destX + i) && (sourceY == destY + i)) {
                Cell[] result = new Cell[sourceX - destX];
                for (int j = sourceX; j > destX; j--) {
                    result[j] = new Cell(j, j);
                }
                return result;
            }
            if ((sourceX == destX - i) && (sourceY == destY - i)) {
                Cell[] result = new Cell[destX - sourceX];
                for (int j = sourceX; j < destX; j++) {
                    result[j] = new Cell(j, j);
                }
                return result;
            }
        }
        throw new ImpossibleMoveException("Impossible move!");
    }

    @Override
    Figure copy(Cell dest) {
        return new Bishop(dest);
    }
}
