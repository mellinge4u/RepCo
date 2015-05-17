package maze;

import java.util.*;

public class Taquin implements IJeu {

	private int[][] plateau;
	private static int[][] etatFinal = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 0 } };
	private ArrayList<IJeu> jeu; // à voir dans iterator
	private IJeu father;
	public int first;
	
	public Taquin(int i) {
		this.plateau = new int[3][3];
		this.jeu = new ArrayList<IJeu>(4);
		this.father = null;
		first = 1;
	}

	public Taquin(int[][] tab) {
		this.plateau = tab;
		this.jeu = new ArrayList<IJeu>(4);
		this.father = new Taquin(0);
		first = 0;
	}

	public int[][] getPlat() {
		return this.plateau;
	}

	public boolean estFinal() {
		boolean ef = Arrays.deepEquals(this.getPlat(), this.etatFinal);
		return ef;
	}

	public String getCase(int i, int j) {
		return "" + plateau[i][j];
	}

	public int getAbs(int k) {
		int abs = 0;
		for (int i = 0; i < plateau.length; i++) {
			for (int j = 0; j < plateau[i].length; j++) {
				if (Integer.parseInt(getCase(i, j)) == k) {
					abs = j;
				}
			}
		}
		return abs;
	}

	public int getOrd(int k) {
		int ord = 0;
		for (int i = 0; i < plateau.length; i++) {
			for (int j = 0; j < plateau[i].length; j++) {
				if (Integer.parseInt(getCase(i, j)) == k) {
					ord = i;
				}
			}
		}
		return ord;
	}

	public boolean enBas() {
		boolean bas = true;
		if (getOrd(0) == 2) {
			bas = false;
		}
		return bas;
	}

	public boolean enHaut() {
		boolean haut = true;
		if (getOrd(0) == 0) {
			haut = false;
		}
		return haut;
	}

	public boolean aDroite() {
		boolean dr = true;
		if (getAbs(0) == 2) {
			dr = false;
		}
		return dr;
	}

	public boolean aGauche() {
		boolean gc = true;
		if (getAbs(0) == 0) {
			gc = false;
		}
		return gc;
	}

	/* Copy le plateau dans un nouveau tableau, pour le clonage */
	public int[][] copyTab() {
		int[][] tab = new int[3][3];
		for (int i = 0; i < plateau.length; i++) {
			for (int j = 0; j < plateau.length; j++) {
				tab[i][j] = plateau[i][j];
			}
		}
		return tab;
	}

	// Fonctions d'échange de cases

	public Taquin swapLeft() {
		int[][] tab = copyTab();
		tab[getOrd(0)][getAbs(0)] = tab[getOrd(0)][getAbs(0) - 1];
		tab[getOrd(0)][getAbs(0) - 1] = 0;
		Taquin tq = new Taquin(tab);
		return tq;
	}

	public Taquin swapRight() {
		int[][] tab = copyTab();
		tab[getOrd(0)][getAbs(0)] = tab[getOrd(0)][getAbs(0) + 1];
		tab[getOrd(0)][getAbs(0) + 1] = 0;
		Taquin tq = new Taquin(tab);
		return tq;
	}

	public Taquin swapUp() {
		int[][] tab = copyTab();
		tab[getOrd(0)][getAbs(0)] = tab[getOrd(0) - 1][getAbs(0)];
		tab[getOrd(0) - 1][getAbs(0)] = 0;
		Taquin tq = new Taquin(tab);
		return tq;
	}

	public Taquin swapDown() {
		int[][] tab = copyTab();
		tab[getOrd(0)][getAbs(0)] = tab[getOrd(0) + 1][getAbs(0)];
		tab[getOrd(0) + 1][getAbs(0)] = 0;
		Taquin tq = new Taquin(tab);
		return tq;
	}

	/* trouve tous les mvmts possibles en partant de la case "vide" */
	public Iterator<IJeu> iterator() {
		// ArrayList<IJeu> jeu = new ArrayList<IJeu>(4);

		if (aGauche()) {
			jeu.add(swapLeft());
		}
		if (aDroite()) {
			jeu.add(swapRight());
		}
		if (enHaut()) {
			jeu.add(swapUp());
		}
		if (enBas()) {
			jeu.add(swapDown());
		}

		return jeu.iterator();

	}

	public void setPlateau(int[][] np) {
		this.plateau = np;
	}

	public String toString() {
		StringBuilder st = new StringBuilder("");
		for (int i = 0; i < plateau.length; i++) {
			for (int j = 0; j < plateau.length; j++) {
				st.append(" " + getCase(i, j));
			}
			st.append("\n");
		}
		return st.toString();
	}

	public boolean equals(Object o) {
		
		return Arrays.deepEquals(plateau,((Taquin) o).getPlat());

	}

	@Override
	public IJeu getInit() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setFather(IJeu pere) {
		// TODO Auto-generated method stub
		this.father = pere;
	}

	@Override
	public IJeu getFather() {
		// TODO Auto-generated method stub
		return father;
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

//	public static void main(String[] argv) {
//		Taquin tq = new Taquin();
//		Taquin tq2 = new Taquin();
//		int[][] np = { { 3, 6, 7 }, { 8, 4, 1 }, { 2, 0, 5 } };
//		int[][] fini = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 0 } };
//		int[][] clone = tq.copyTab();
//		tq.setPlateau(fini);
//		tq2.setPlateau(fini);
//		System.out.println("tq = tq2 ? "+tq.equals(tq2));
//		System.out.println(tq);
//
//		System.out
//				.println("abs:" + tq.getAbs(0) + " ord " + tq.getOrd(0)
//						+ " en bas ? " + tq.enBas() + " en haut ? "
//						+ tq.enHaut() + " a Droite ? " + tq.aDroite()
//						+ " a Gauche ? " + tq.aGauche());
//
//
//		for (IJeu t : tq) {
//			System.out.println(t);
//		}
//
//	}
}
