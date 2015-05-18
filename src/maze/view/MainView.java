package maze.view;


import java.awt.BorderLayout;

import javax.swing.JFrame;

import maze.AStarForMaze;
import maze.model.Model;

public class MainView extends JFrame {

	public MainView(){
		super("Représentation des connaissances");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Model m = new Model();
		MazeView mv = new MazeView(m);
		ControlView cv = new ControlView(m);
		new AStarForMaze(m.getLab());
		this.add(mv,BorderLayout.CENTER);
		this.add(cv,BorderLayout.SOUTH);
		m.update();
		pack() ;
        setVisible(true);
	}
	
	public static void main(String[] args) {
        new MainView() ;
    }
	
}
