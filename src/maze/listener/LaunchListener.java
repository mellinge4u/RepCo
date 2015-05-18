package maze.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import maze.AStarForMaze;
import maze.model.Model;

public class LaunchListener implements ActionListener {

	private Model mod;

	public LaunchListener(Model mod) {
		this.mod = mod;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int i, j;
		for (i = 0; i < mod.getLab().getCells().length; i++) {
			for (j = 0; j < mod.getLab().getCells().length; j++) {
				if (mod.getLab().getCells()[i][j].getColor() != 3
						&& mod.getLab().getCells()[i][j].getColor() != 4
						&& mod.getLab().getCells()[i][j].getColor() != 1) {
					mod.getLab().getCells()[i][j].setColor(0);
				}
			}
		}
		new AStarForMaze(mod.getLab());
		mod.update();
	}

}
