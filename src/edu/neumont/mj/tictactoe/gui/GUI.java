package edu.neumont.mj.tictactoe.gui;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import edu.neumont.mj.tictactoe.*;

import edu.neumont.mj.tictactoe.Game;
import edu.neumont.mj.tictactoe.enums.GameState;

public class GUI extends JFrame {
    private static Game game;

    private JLabel winner;

    public GUI() {
        setButtons();
    }
    private List<JButton> buttons = new ArrayList<>();

    private void setButtons() {
        game = new Game();
        game.startPlayerVPlayer();
        setLayout(new GridLayout(0, 3, 100, 100));
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton button0 = new JButton(game.getTypeAtSquare(new Location(j, i)).toString());
                button0.setFont(new Font("Serif", Font.BOLD, 60));
                add(button0);
                buttons.add(button0);
                button0.addActionListener(new ButtonAction(this, new Location(j, i), button0, game));
            }

        }
        JButton buttonr = new JButton("Restart PvP");
        buttonr.setFont(new Font("Serif", Font.BOLD, 60));
        add(buttonr);
        buttonr.addActionListener(new ResetAction(this));
        JButton buttonc = new JButton("AI - Not Implemented");
        buttonc.setFont(new Font("Serif", Font.BOLD, 60));
        add(buttonc);
        
        winner = new JLabel("The winner is: ");
        winner.setFont(new Font("Serif", Font.PLAIN, 60));
        add(winner);
    }
    
    public void resetPVP(){
    	game = new Game();
    	game.startPlayerVPlayer();
    	for(JButton i: buttons){
    		i.setText("Empty");
    		((ButtonAction) i.getActionListeners()[0]).updateGame(game);
    	}
    	winner.setText("The winner is: ");
    }

    public void checkVictory() {
        if (game.getState() == GameState.Won) {
            winner.setText("The winner is: " + game.getVictorType().toString());
        }
    }

    public static void main(String[] args) {
        GUI gui = new GUI();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(2560, 1440);
        gui.setVisible(true);
        gui.setTitle("Tic-Tac-Toe");
    }


}
