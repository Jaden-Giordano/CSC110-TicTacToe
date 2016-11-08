package edu.neumont.mj.tictactoe.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import edu.neumont.mj.tictactoe.*;

import edu.neumont.mj.tictactoe.Game;

public class GUI extends JFrame {
    private static Game game;

    public static boolean restart = false;

    public GUI() {
        setButtons();
    }

    private void setButtons() {
        game = new Game();
        game.startPlayerVPlayer();
        setLayout(new GridLayout(0, 3, 100, 100));
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton button0 = new JButton(game.getTypeAtSquare(new Location(i, j)).toString());
                add(button0);
                button0.addActionListener(new ButtonAction(new Location(i, j), button0, game));
            }

        }
        JButton buttonr = new JButton("Restart PvP");
        add(buttonr);
        buttonr.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Object o = e.getSource();
                if (buttonr == o) {
                    setButtons();
                }
            }
        });
        JButton buttonc = new JButton("Restart Player v. AI");
        add(buttonc);


    }

    public static void main(String[] args) {
        GUI gui = new GUI();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(2560, 1440);
        gui.setVisible(true);
        gui.setTitle("Tic-Tac-Toe");
    }

}
