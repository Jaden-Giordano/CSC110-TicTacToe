package edu.neumont.mj.tictactoe.player;

import edu.neumont.mj.tictactoe.enums.Type;

/**
 * Created by Jaden-Laptop on 11/7/2016.
 */
public abstract class Player {

    private Type turn;

    public Player(Type turn) {
        this.turn = turn;
    }

    public Type getTurn() {
        return turn;
    }

}
