package edu.neumont.mj.tictactoe;

import edu.neumont.mj.tictactoe.enums.Type;
import edu.neumont.mj.tictactoe.helpers.BoardHelper;
import edu.neumont.mj.tictactoe.player.PlayablePlayer;
import edu.neumont.mj.tictactoe.player.Player;

/**
 * Created by Jaden-Laptop on 11/6/2016.
 */
public class Game {

    enum GameState {
        Init,
        Play
    }

    private Board board;

    private Player playerOne;
    private Player playerTwo;

    private Type turn;

    private GameState state;

    public Game() {
        state = GameState.Init;
    }

    public void startPlayerVPlayer() {
        board = BoardHelper.generateNewEmptyBoard();
        playerOne = new PlayablePlayer(Type.X);
        playerTwo = new PlayablePlayer(Type.O);
        setState(GameState.Play);
    }

    public boolean attemptPlaceTile(int x, int y) {
        if ((x > 2 || x < 0) || (y > 2 || y < 0))
            return false;

        boolean success = board.attemptPlaceTile(x, y, turn);
        if (success) {
            flipTurn();
        }

        return success;
    }

    public Player getVictor() {
        switch (board.getVictor()) {
            case X:
                return playerOne;
            case O:
                return playerTwo;
        }
        return null;
    }

    public void flipTurn() {
        turn = (turn == Type.X)?Type.O:Type.X;
    }

    public void setTurn(Type turn) {
        this.turn = turn;
    }

    public Player getCurrentPlayer() {
        switch (turn) {
            case X:
                return playerOne;
            case O:
                return playerTwo;
        }
        return null;
    }

    public GameState getState() {
        return state;
    }

    public void setState(GameState state) {
        this.state = state;
    }

}
