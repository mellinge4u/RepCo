package maze;

import java.util.ArrayList;
import java.util.Iterator;

/*
 * Iterative Deeping A star pour le labyrinthe
 */

public class IDAStarForMaze implements IRecherche {

	private ArrayList<Cell> OPEN; // OPEN la liste des noeuds à étudier
	private ArrayList<Cell> path; // chemin que l'on aura trouvé
	private ArrayList<Cell> CLOSED; // CLOSED la liste des noeuds déjà étudiés,
									// la
	// classe historique est pratique pour ça
	private Cell s0; // state 0 , état initiale
	private Labyrinthe jeu; // Ici ce sera un labyrinthe

	public IDAStarForMaze(Labyrinthe ij) {
		OPEN = new ArrayList<>();
		path = new ArrayList<>();
		CLOSED = new ArrayList<>();
		s0 = ij.getInit();
		OPEN.add(s0);
		this.jeu = ij;
	}

	public void IDAStarAlgo() {
		Cell current; // l'état courant
		int limite = s0.getF(); // la limite pour f
		boolean possible = true;
		while (possible) {
			OPEN = new ArrayList<>();
			OPEN.add(s0);
			CLOSED = new ArrayList<>();
			while (!OPEN.isEmpty()) {
				System.out.println("ok");
				current = OPEN.get(0); // on prend le premier dans OPEN, celui
										// que
										// devrai avoir le f le plus petit
//				if (limite > current.getF()) { // si jamais la limite est plus
//												// grande que
//					limite = current.getF(); // le noeud courrant le plus
//												// efficace
//				}
				if (current.estFinal()) {
					CLOSED.add(current);
					possible = false;
					break;
				}
				CLOSED.add(current);
				OPEN.remove(current);
				Iterator<Cell> it = jeu.iterator(current);
				while (it.hasNext()) { // pour chaque voisin
					Cell nij = it.next(); // le voisin
					if (CLOSED.contains(nij)) {
						System.out.println("ok1");
						continue;
					}
					if (nij.getF() > limite) {
						System.out.println("ok2");
						continue;
					}
					// System.out.println(nij);
					int DBCandNij; // Distance Between Current & nij, le nouveau
									// cout
					DBCandNij = current.getG() + 1;
					if (!OPEN.contains(nij) || DBCandNij < nij.getG()) {
						nij.setG(DBCandNij);
						nij.setF(nij.getH() + nij.getG());
						nij.setFather(current);
						if (!OPEN.contains(nij)) {
							arrange(nij); // si jamais le voisin n'est pas dans
											// OPEN, on l'y range
						}
						// System.out.println("ok");
					}
				}
			}
			limite++;
			if(limite > 500){
				possible = false;
			}
		}
		if (OPEN.isEmpty()) {
			System.out.println(" le système n'admet pas de solutions");
		} else {

			System.out.println("Chemin trouvé ");
		}
	}

	private void arrange(Cell ij) {
		if (OPEN.isEmpty()) {
			OPEN.add(ij);
		} else if (ij.getF() < OPEN.get(0).getF()) {
			OPEN.add(0, ij);
		} else {
			for (int index = 1; index < OPEN.size(); index++) {
				if (ij.getF() < OPEN.get(index).getF()) {
					OPEN.add(index, ij);
					break;
				}
				if (index == OPEN.size() - 1) {
					OPEN.add(ij);
					break;
				}
			}
		}
	}
	
	@Override
	public boolean existeChemin(IJeu i) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * fonction qui retrouve le chemin
	 */
	public ArrayList<Cell> path() {
		Cell ij = CLOSED.get(CLOSED.size() - 1);
		path.add(ij);
		while (ij.getFather() != null) {
			path.add((Cell) ij.getFather());
			ij = (Cell) ij.getFather();
		}
		return path;
	}

	public static void main(String[] args) {
		Labyrinthe l = new Labyrinthe();
		IDAStarForMaze as = new IDAStarForMaze(l);
		as.IDAStarAlgo();
		ArrayList<Cell> alIJ = as.path();
		for (Cell ij : as.path) {
			System.out.println(ij);
		}
	}

}
