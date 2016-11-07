package edu.neumont.mj.tictactoe.enums;

import edu.neumont.mj.tictactoe.Board;

/**
 * Created by Jaden-Laptop on 11/6/2016.
 */
public class Square {

    private Type type;

    private Board board;
    private int x, y;

    public Square(Board board, int x, int y) {
        this.type = Type.Empty;

        this.board = board;

        this.x = x;
        this.y = y;
    }

    public Type getType() {
        return this.type;
    }

    public boolean setType(Type t) {
        if (this.type != Type.Empty)
            return false;

        this.type = t;
        return true;
    }

    public int getXPosition() {
        return this.x;
    }

    public int getYPosition() {
        return this.y;
    }

}
