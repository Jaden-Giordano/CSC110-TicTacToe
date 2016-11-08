package edu.neumont.mj.tictactoe.player;

import edu.neumont.mj.tictactoe.Game;
import edu.neumont.mj.tictactoe.enums.Type;

/**
 * Created by Jaden-Laptop on 11/7/2016.
 */
public abstract class Player {

    private Game game;
    private Type turn;

    public Player(Game game, Type turn) {
        this.game = game;
        this.turn = turn;
    }

    public Type getTurn() {
        return turn;
    }

}
