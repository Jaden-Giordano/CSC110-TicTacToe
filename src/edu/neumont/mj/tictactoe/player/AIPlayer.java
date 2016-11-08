package edu.neumont.mj.tictactoe.player;

import edu.neumont.mj.tictactoe.Game;
import edu.neumont.mj.tictactoe.Location;
import edu.neumont.mj.tictactoe.enums.Type;

/**
 * Created by Jaden-Laptop on 11/7/2016.
 */
public class AIPlayer extends Player {

    enum Difficulty {
        Easy,
        Medium,
        Hard
    }

    private Difficulty difficulty;
    private Game game;

    public AIPlayer(Game game, Type turn, Difficulty difficulty) {
        super(game, turn);
        this.difficulty = difficulty;
    }

    public void handleTurn() {
        if (shouldMakeStupidMove()) {
            boolean valid = false;
            for (int i = 0; i < 3 && !valid; i++) {
                for (int j = 0; j < 3 && !valid; j++) {
                    valid = game.attemptPlaceTile(new Location(i, j));
                }
            }
        } else {

        }
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    private boolean shouldMakeStupidMove() {
        switch (difficulty) {
            case Easy:
                return (Math.random() <= .8);
            case Medium:
                return (Math.random() <= .5);
            case Hard:
                return (Math.random() <= .2);
        }
        return true;
    }

}
