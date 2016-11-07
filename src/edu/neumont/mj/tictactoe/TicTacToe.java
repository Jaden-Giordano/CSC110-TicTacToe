package edu.neumont.mj.tictactoe;

/**
 * Created by Jaden-Laptop on 11/5/2016.
 */
public class TicTacToe {

    private static TicTacToe myInstance;

    public static TicTacToe getInstance() {
        return myInstance;
    }

    enum MenuState {
        Main,
        Running,
        Quit
    }

    private Game game;

    private MenuState state = MenuState.Main;

    public void run() {
        boolean running = true;
        while (running) {
            switch (state) {
                case Main:

                    break;
                case Running:

                    break;
                case Quit:
                    running = false;
                    break;
            }
        }
    }

    public static void main(String[] args) {
        myInstance = new TicTacToe();
        myInstance.run();
    }

}
