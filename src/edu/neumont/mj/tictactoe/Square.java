package edu.neumont.mj.tictactoe;

import edu.neumont.mj.tictactoe.enums.Type;

/**
 * Created by Jaden-Laptop on 11/6/2016.
 */
public class Square {

    private Type type;

    private Board board;
    private Location location;

    public Square(Board board, Location location) {
        this.type = Type.Empty;

        this.board = board;

        this.location = location;
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

    public Location getLocation() {
        return location;
    }

    public String toString() {
        return "Square: {Type: "+getType()+", Location: "+getLocation().toString()+"}";
    }

}
