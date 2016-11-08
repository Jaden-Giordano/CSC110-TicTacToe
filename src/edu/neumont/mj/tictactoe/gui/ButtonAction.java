package edu.neumont.mj.tictactoe.gui;

import edu.neumont.mj.tictactoe.Game;
import edu.neumont.mj.tictactoe.Location;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Jaden-Laptop on 11/8/2016.
 */
public class ButtonAction implements ActionListener {

    private Location location;
    private Game game;
    private JButton button;

    public ButtonAction(Location location, JButton button, Game game) {
        super();
        this.location = location;
        this.game = game;
        this.button = button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        boolean success = game.attemptPlaceTile(this.location);
        if (success) {
            System.out.println("(" + location.x + ", " + location.y + ") Action");
            edu.neumont.mj.tictactoe.enums.Type t = game.getTypeAtSquare(this.location);
            button.setText((t == null) ? "Broken" : t.toString());
        }

    }
}