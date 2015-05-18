package maze.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import maze.Labyrinthe;
import maze.model.Model;

public class ResetListener implements ActionListener {

	public Model mod;
	
	public ResetListener(Model mod){
		this.mod = mod;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		
		mod.setLab(new Labyrinthe());

	}

}
