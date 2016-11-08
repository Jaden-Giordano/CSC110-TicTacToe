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
        Play,
        Won
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
        playerOne = new PlayablePlayer(this, Type.X);
        playerTwo = new PlayablePlayer(this, Type.O);
        setState(GameState.Play);
    }

    public boolean attemptPlaceTile(Location l) {
        if ((l.x > 2 || l.x < 0) || (l.y > 2 || l.y < 0))
            return false;

        boolean success = board.attemptPlaceTile(l, turn);
        if (success) {
            flipTurn();
        }

        if (getVictor() != null)
            setState(GameState.Won);

        return success;
    }

    public Type getTypeAtSquare(Location l) {
        try {
            Square s = board.getSquare(l);
            return s.getType();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Type getTurn() {
        return turn;
    }

    public GameState getState() {
        return state;
    }

    private Player getVictor() {
        switch (board.getVictor()) {
            case X:
                return playerOne;
            case O:
                return playerTwo;
        }
        return null;
    }

    private void flipTurn() {
        turn = (turn == Type.X)?Type.O:Type.X;
    }

    private void setTurn(Type turn) {
        this.turn = turn;
    }

    private Player getCurrentPlayer() {
        switch (turn) {
            case X:
                return playerOne;
            case O:
                return playerTwo;
        }
        return null;
    }

    private void setState(GameState state) {
        this.state = state;
    }

}
