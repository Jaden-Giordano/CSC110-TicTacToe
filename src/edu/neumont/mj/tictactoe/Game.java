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

        if (getVictor() != null)
            setState(GameState.Won);

        return success;
    }

    public Type getTypeAtSquare(int x, int y) {
        try {
            Square s = board.getSquare(x, y);
            return s.getType();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            return null;
        }
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
