package maze.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import maze.model.Model;

public class MazeListener implements ActionListener{

	private int x;
	private int y;
	private Model mod;
	private JButton jb;
	
	public MazeListener(Model mod, int x, int y, JButton jb) {
		this.mod = mod;
		this.x = x;
		this.y = y;
		this.jb = jb;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(mod.getLab().getCells()[x][y].getColor()!=4 && mod.getLab().getCells()[x][y].getColor()!=3)
		mod.setCell(x, y);
		
	}
	
	
	
}
