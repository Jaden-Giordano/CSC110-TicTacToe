package edu.neumont.mj.tictactoe.helpers;

import edu.neumont.mj.tictactoe.Board;
import edu.neumont.mj.tictactoe.enums.Square;

/**
 * Created by Jaden-Laptop on 11/6/2016.
 */
public class BoardHelper {

    public static Board generateNewEmptyBoard() {
        Board b = new Board();
        Square[][] squares = new Square[3][3];
        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; i < squares[i].length; j++) {
                squares[i][j] = new Square(b, i, j);
            }
        }
        b.setSquares(squares);
        return b;
    }

}
