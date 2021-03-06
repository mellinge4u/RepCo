package maze;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/*
 * Class labyrinthe
 */
public class Labyrinthe implements IJeu {

	private ArrayList<Cell> jeu; // pour garder les actions possibles sous le
									// coude, voir taquin
	private Cell[][] cells;
	private int size;
	private Cell init;

	/*
	 * Cr�ation d'un labyrinthe en prenant en param�tre la taille de celui ci ;
	 * i x i
	 */
	public Labyrinthe(int i) {
		size = i;
		cells = new Cell[i][i];
		jeu = new ArrayList<>();
		init = new Cell(null);
		init.setColor(4);
		// on initialise les valeurs du tableau cells
		//cells[0][0] = init;
		for (int j = 1; j < i; j++) {
			for (int k = 1; k < i; k++) {
				Cell c = new Cell(null); // on ne s'occupe du p�re que plus tard
				c.setCoor(j, k);
				c.setG(j + k); // le cout augmente avec la profondeur
				int volDoiseau = (int) (Math.pow(i - j, 2) + Math.pow(i - k, 2));
				c.setH(volDoiseau); // heuristique, prenons la distance en vol
									// d'oiseau de la destination
				cells[j][k] = c;
			}
		}
		cells[0][0].setColor(4);
		init = cells[0][0];
		cells[i-1][i-1].setColor(3);
		buildWall(6);
	}
	
	public Labyrinthe() {
		int i = 10;
		size = i;
		cells = new Cell[i][i];
		jeu = new ArrayList<>();
		// on initialise les valeurs du tableau cells
		for (int j = 0; j < i; j++) {
			for (int k = 0; k < i; k++) {
				Cell c = new Cell(null); // on ne s'occupe du p�re que plus tard
				c.setCoor(j, k);
				c.setG(j + k); // le cout augmente avec la profondeur
				int volDoiseau = (int) (Math.pow(i - j, 2) + Math.pow(i - k, 2));
				c.setH(volDoiseau); // heuristique, prenons la distance en vol
									// d'oiseau de la destination
				cells[j][k] = c;
			}
		}
		cells[4][4].setColor(4);
		init = cells[4][4];
		cells[i-1][i-1].setColor(3);
		buildWall(6);
	}

	/*
	 * GETTER AND SETTERS
	 */

	public ArrayList<Cell> getJeu() {
		return jeu;
	}

	public void setJeu(ArrayList<Cell> jeu) {
		this.jeu = jeu;
	}

	public Cell[][] getCells() {
		return cells;
	}

	public void setCells(Cell[][] cells) {
		this.cells = cells;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	/*
	 * fonction pour r�cup�rer l'�tat initiale
	 */
	public Cell getInit(){
		//Cell c = new Cell(null);
		//c.setColor(4);
		return init;
	}
	
	
	/*
	 * fonction qui permet de construire les murs dans le labyrinthe
	 */
	public void buildWall(int i) {
		int randX, randY, j;
		Random r = new Random();
		Random r2 = new Random();
		for (j = 0; j < i; j++) {
			randX = r.nextInt(size - 3) + 1; // entre 1 et size-2
			randY = r2.nextInt(size - 3) + 1;
			Cell c = new Cell(null);
			c.setColor(1); // 1 pour noir
			if (cells[randX][randY].getColor() != 1) {
				cells[randX][randY] = c;
			} else {
				cells[randY][randX] = c;
			}
		}
	}

	public boolean enBas(Cell c) {
		boolean bas = true;
		int x = c.getX();
		int y = c.getY();
		if (y == size - 1) {
			bas = false;
		}
		return bas;
	}

	public boolean enHaut(Cell c) {
		int x = c.getX();
		int y = c.getY();
		boolean haut = true;
		if (y == 0) {
			haut = false;
		}
		return haut;
	}

	public boolean aDroite(Cell c) {
		int x = c.getX();
		int y = c.getY();
		boolean dr = true;
		if (x == size - 1) {
			dr = false;
		}
		return dr;
	}

	public boolean aGauche(Cell c) {
		int x = c.getX();
		int y = c.getY();
		boolean gc = true;
		if (x == 0) {
			gc = false;
		}
		return gc;
	}

		public Cell cellLeft(Cell c) {
			Cell nc = cells[c.getX()-1][c.getY()];
			return nc;
		}

		public Cell cellRight(Cell c) {
			Cell nc = cells[c.getX()+1][c.getY()];
			return nc;
		}

		public Cell cellUp(Cell c) {
			Cell nc = cells[c.getX()][c.getY()-1];
			return nc;
		}

		public Cell cellDown(Cell c) {
			Cell nc = cells[c.getX()][c.getY()+1];
			return nc;
		}
	
	public Iterator<Cell> iterator(Cell c) {
		if (aDroite(c)) {
			jeu.add(cellRight(c));
		}
		if (aGauche(c)) {
			jeu.add(cellLeft(c));
		}
		if (enBas(c)) {
			jeu.add(cellDown(c));
		}
		if (enHaut(c)) {
			jeu.add(cellUp(c));
		}

		return jeu.iterator();
	}

	
	@Override
	public Iterator<IJeu> iterator() {
		
		return null;
	}

	@Override
	public boolean estFinal() {
		// TODO Auto-generated method stub
		return false;
	}

	
	public static void main(String[] args) {
		Labyrinthe l = new Labyrinthe(10);
		int i, j;
		for (i = 0; i < l.getSize(); i++) {
			for (j = 0; j < l.getSize(); j++) {
				System.out.println(l.getCells()[i][j]);
			}
		}
	}

	@Override
	public void setFather(IJeu pere) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IJeu getFather() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getF() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getG() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getH() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setF(int f) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setG(int g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setH(int h) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int costTOneighbor() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}

}
