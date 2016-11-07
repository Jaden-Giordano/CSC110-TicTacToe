package edu.neumont.mj.tictactoe;

import edu.neumont.mj.tictactoe.enums.Square;
import edu.neumont.mj.tictactoe.enums.Type;

/**
 * Created by Jaden-Laptop on 11/6/2016.
 */
public class Board {

    private Square[][] squares;

    public Board() {

    }

    public void setSquares(Square[][] squares) {
        this.squares = squares;
    }

    public Square getTile(int x, int y) {
        if ((x > 2 || x < 0) || (y > 2 || y < 0))
            throw new IllegalArgumentException("Tile selection out of bounds.");

        if (squares == null)
            return null;

        return squares[x][y];
    }

    public Type getVictor() {
        if (squares == null)
            return null;

        boolean row0 = countHorizontalSimilar(getTile(0, 0), 0) == 2;
        boolean row1 = countHorizontalSimilar(getTile(0, 1), 0) == 2;
        boolean row2 = countHorizontalSimilar(getTile(0, 2), 0) == 2;
        boolean column0 = countVerticalSimilar(getTile(0, 0), 0) == 2;
        boolean column1 = countHorizontalSimilar(getTile(1, 0), 0) == 2;
        boolean column2 = countVerticalSimilar(getTile(2, 0), 0) == 2;
        boolean diagonal = countDiagonalSimilar(getTile(0, 0), 0) == 2;

        if (row0 || column0 || diagonal)
            return getTile(0, 0).getType();
        if (row1)
            return getTile(0, 1).getType();
        if (row2)
            return getTile(0, 2).getType();
        if (column1)
            return getTile(1, 0).getType();
        if (column2)
            return getTile(2, 0).getType();

        return null;
    }

    private int countHorizontalSimilar(Square s, int heuristic) {
        if (s.getXPosition() == 2)
            return heuristic;
        else {
            Square adjacent = getTile(s.getXPosition()+1, s.getYPosition());
            if (adjacent.getType() == s.getType()) {
                int nHeu = heuristic + 1;
                return countHorizontalSimilar(adjacent, nHeu);
            } else {
                return heuristic;
            }
        }
    }

    private int countVerticalSimilar(Square s, int heuristic) {
        if (s.getYPosition() == 2)
            return heuristic;
        else {
            Square adjacent = getTile(s.getXPosition(), s.getYPosition()+1);
            if (adjacent.getType() == s.getType()) {
                int nHeu = heuristic + 1;
                return countVerticalSimilar(adjacent, nHeu);
            } else {
                return heuristic;
            }
        }
    }

    private int countDiagonalSimilar(Square s, int heuristic) {
        if (s.getYPosition() == 2 || s.getXPosition() == 2)
            return heuristic;
        else {
            Square adjacent = getTile(s.getXPosition()+1, s.getYPosition()+1);
            if (adjacent.getType() == s.getType()) {
                int nHeu = heuristic + 1;
                return countDiagonalSimilar(adjacent, nHeu);
            } else {
                return heuristic;
            }
        }
    }

}
