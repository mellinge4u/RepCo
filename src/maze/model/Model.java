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
	}

	public Labyrinthe getLab() {
		return lab;
	}

	public void setLab(Labyrinthe lab) {
		this.lab = lab;
	}
	
	public void update(){
		setChanged();
		notifyObservers();
	}
}
