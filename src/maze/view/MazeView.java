package maze.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JPanel;

import maze.listener.MazeListener;
import maze.model.Model;

public class MazeView extends JPanel implements Observer {

	protected JButton[][] tabJB;
	protected Model mod;

	public MazeView(Model mod) {
		this.setPreferredSize(new Dimension(500, 500));
		this.setLayout(new GridLayout(10, 10));
		this.mod = mod;
		this.tabJB = new JButton[mod.getLab().getSize()][mod.getLab().getSize()];
		int i, j;
		for (i = 0; i < tabJB.length; i++) {
			for (j = 0; j < tabJB.length; j++) {
				tabJB[i][j] = new JButton();
				tabJB[i][j].addActionListener(new MazeListener(mod, i, j, tabJB[i][j]));
				tabJB[i][j].setBackground(Color.LIGHT_GRAY);
				this.add(tabJB[i][j]);
			}
		}
		mod.addObserver(this);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		int i, j;
		for (i = 0; i < tabJB.length; i++) {
			for (j = 0; j < tabJB.length; j++) {
				switch (mod.getLab().getCells()[i][j].getColor()) {
				case 4:// départ
					tabJB[i][j].setBackground(Color.RED);
					tabJB[i][j].setText("D");
					break;
				case 3:// arrivée
					tabJB[i][j].setBackground(Color.GREEN);
					tabJB[i][j].setText("A");
					break;
				case 1:
					tabJB[i][j].setBackground(Color.BLACK);
					tabJB[i][j].setText("");
					break;
				case 2:
					tabJB[i][j].setBackground(Color.PINK);
					tabJB[i][j].setText("");
					break;
				case 5:
					tabJB[i][j].setBackground(Color.BLUE);
					tabJB[i][j].setText("");
					break;
				default:
					tabJB[i][j].setBackground(Color.LIGHT_GRAY);
					int h = mod.getLab().getCells()[i][j].getH();
					tabJB[i][j].setText(""+h);
					break;
				}
			}
		}

	}
}
