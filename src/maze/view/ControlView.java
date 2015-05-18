package maze.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import maze.AStarForMaze;
import maze.IDAStarForMaze;
import maze.listener.LaunchListener;
import maze.listener.ResetListener;
import maze.model.Model;

public class ControlView extends JPanel {

	private JButton launch;
	private JButton reset;
	private JComboBox listAlgo;
	private Model mod;

	public ControlView(Model mod) {
		this.mod = mod;
		this.launch = new JButton("lancer");
		launch.addActionListener(new LaunchListener(mod));
		this.reset = new JButton("reset");
		reset.addActionListener(new ResetListener(mod));
		JButton aS = new JButton("A*");
		JButton iadS = new JButton("IDA*");

		Object[] algo = new Object[] { "A*", "IDA*" };

		listAlgo = new JComboBox(algo);
		listAlgo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (listAlgo.getSelectedItem() == "A*") {
					mod.setAlgo(new AStarForMaze(mod.getLab()));
				} else {
					mod.setAlgo(new IDAStarForMaze(mod.getLab()));
				}
			}
		});
		this.setLayout(new GridLayout(0, 3));
		this.add(launch);
		this.add(reset);
		this.add(listAlgo);
	}

}
