package maze.view;


import javax.swing.JFrame;

import maze.AStarForMaze;
import maze.model.Model;

public class MainView extends JFrame {

	public MainView(){
		super("Repr�sentation des connaissances");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Model m = new Model();
		MazeView mv = new MazeView(m);
		new AStarForMaze(m.getLab());
		this.add(mv);
		m.update();
		pack() ;
        setVisible(true);
	}
	
	public static void main(String[] args) {
        new MainView() ;
    }
	
}
