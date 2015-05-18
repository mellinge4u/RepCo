package maze.model;

import java.util.Observable;

import maze.AStarForMaze;
import maze.IRecherche;
import maze.Labyrinthe;

public class Model extends Observable{

	private IRecherche algo;
	private Labyrinthe lab;
	
	public Model(){
		this.lab = new Labyrinthe();
		this.algo = new AStarForMaze(lab);
		update();
	}

	public IRecherche getAlgo() {
		return algo;
	}

	public void setAlgo(IRecherche algo) {
		this.algo = algo;
		update();
	}

	public Labyrinthe getLab() {
		return lab;
	}

	public void setLab(Labyrinthe lab) {
		this.lab = lab;
		update();
	}
	
	public void launchAlgo(){
		new AStarForMaze(lab);
		update();
	}
	
	public void update(){
		//launchAlgo();
		setChanged();
		notifyObservers();
	}
	
	public void setCell(int x, int y){
		if(lab.getCells()[x][y].getColor()!=1){
			lab.getCells()[x][y].setColor(1);
		} else {
			lab.getCells()[x][y].setColor(0);
		}
		update();
	}
}
