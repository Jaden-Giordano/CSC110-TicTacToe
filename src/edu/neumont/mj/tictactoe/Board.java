package edu.neumont.mj.tictactoe;

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

    public Square getSquare(Location l) {
        if ((l.x > 2 || l.x < 0) || (l.y > 2 || l.y < 0))
            throw new IllegalArgumentException("Tile selection out of bounds.");

        if (squares == null)
            return null;

        return squares[l.x][l.y];
    }

    public boolean attemptPlaceTile(Location l, Type turn) {
        try  {
            Square s = getSquare(l);
            if (s.getType() == Type.Empty) {
                s.setType(turn);
                return true;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            return false;
        }
    }

    public Type getVictor() {
        if (squares == null)
            return null;

        boolean row0 = countHorizontalSimilar(getSquare(new Location()), 0) == 2;
        boolean row1 = countHorizontalSimilar(getSquare(new Location(0, 1)), 0) == 2;
        boolean row2 = countHorizontalSimilar(getSquare(new Location(0, 2)), 0) == 2;
        boolean column0 = countVerticalSimilar(getSquare(new Location(0, 0)), 0) == 2;
        boolean column1 = countHorizontalSimilar(getSquare(new Location(1, 0)), 0) == 2;
        boolean column2 = countVerticalSimilar(getSquare(new Location(2, 0)), 0) == 2;
        boolean diagonal = countDiagonalSimilar(getSquare(new Location(0, 0)), 0) == 2;

        if (row0 || column0 || diagonal)
            return getSquare(new Location(0, 0)).getType();
        if (row1)
            return getSquare(new Location(0, 1)).getType();
        if (row2)
            return getSquare(new Location(0, 2)).getType();
        if (column1)
            return getSquare(new Location(1, 0)).getType();
        if (column2)
            return getSquare(new Location(2, 0)).getType();

        return null;
    }

    private int countHorizontalSimilar(Square s, int heuristic) {
        Location l = s.getLocation();
        if (l.x == 2)
            return heuristic;
        else {
            Square adjacent = getSquare(l.add(new Location(1, 0)));
            if (adjacent.getType() == s.getType()) {
                int nHeu = heuristic + 1;
                return countHorizontalSimilar(adjacent, nHeu);
            } else {
                return heuristic;
            }
        }
    }

    private int countVerticalSimilar(Square s, int heuristic) {
        Location l = s.getLocation();
        if (l.y == 2)
            return heuristic;
        else {
            Square adjacent = getSquare(l.add(new Location(0, 1)));
            if (adjacent.getType() == s.getType()) {
                int nHeu = heuristic + 1;
                return countVerticalSimilar(adjacent, nHeu);
            } else {
                return heuristic;
            }
        }
    }

    private int countDiagonalSimilar(Square s, int heuristic) {
        Location l = s.getLocation();
        if (l.x == 2 || l.y == 2)
            return heuristic;
        else {
            Square adjacent = getSquare(l.add(new Location(1, 1)));
            if (adjacent.getType() == s.getType()) {
                int nHeu = heuristic + 1;
                return countDiagonalSimilar(adjacent, nHeu);
            } else {
                return heuristic;
            }
        }
    }

}
