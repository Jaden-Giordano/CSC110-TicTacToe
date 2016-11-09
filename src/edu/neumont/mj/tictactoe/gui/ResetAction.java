package edu.neumont.mj.tictactoe.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetAction implements ActionListener{
	
	private GUI f;
	
	public ResetAction(GUI f){
		this.f = f;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		f.resetPVP();
	}

}
