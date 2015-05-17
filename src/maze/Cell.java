package maze;

import java.util.Iterator;

/*
 * Class Cell, correspondant au case du labi
 */
public class Cell implements IJeu {

	private int x; // coordonnée en x
	private int y; // coordonnée en y
	private int h;
	private int g;
	private int f; // f = g + h
	private int color; // code pour les couleurs
	private IJeu father;
	
	/*
	 * On instancie une cellule avec son pere
	 */
	// TODO trouver un moyen pour ne pas instancier que des père null
	public Cell(Cell father) {
		x = 0;
		y = 0;
		h = 0;
		g = 0;
		f = 0;
		color = 0; //0 pour blanc
		this.father = father;
	}

	
	/*
	 * GENERATION DES GETTER ET DES SETTERS
	 */
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setCoor(int x , int y ){
		this.x = x;
		this.y = y;
	}
	
	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
	}

	public int getF() {
		return h + g;
	}

	public void setF(int f) {
		this.f = f;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public IJeu getFather() {
		return father;
	}

	public void setFather(IJeu pere) {
		this.father = pere;
	}

	
	/*
	 * FONCTION DE L'INTERFACE IJEU
	 */
	
	
	/*
	 * C'était surtout utile pour taquin et crypta
	 */
	public Iterator<IJeu> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * on va créer des lab de longueurs variables
	 */
	public boolean estFinal() {
		return color == 3; // 3 pour le rouge 
	}


	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("CELL("+getX()+","+getY()+")\n");
		sb.append("-COLOR: "+getColor()+"\n");
		sb.append("-COST: "+getG()+"\n");
		sb.append("-HEURISTIQUE: "+getH()+"\n");
		sb.append("-F : "+getF()+"\n");
		return sb.toString();
	}


	@Override
	public IJeu getInit() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
