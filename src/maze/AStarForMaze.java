package maze;

import java.util.ArrayList;
import java.util.Iterator;

/*
 * AStar créé spécialement pour le labyrinthe vu les difficulté que j'ai 
 * à l'implémenté de façon générique
 */

public class AStarForMaze implements IRecherche {
	private ArrayList<Cell> OPEN; // OPEN la liste des noeuds à étudier
	private ArrayList<Cell> path; // chemin que l'on aura trouvé
	private ArrayList<Cell> CLOSED; // CLOSED la liste des noeuds déjà étudiés, la
								// classe historique est pratique pour ça
	private Cell s0; // state 0 , état initiale
	private Labyrinthe jeu; // Ici ce sera un labyrinthe
	
	public AStarForMaze(Labyrinthe ij) {
		OPEN = new ArrayList<>();
		path = new ArrayList<>();
		CLOSED = new ArrayList<>();
		s0 = ij.getInit();
		OPEN.add(s0);
		this.jeu = ij;
		aStarAlgo();
	}

	/*
	 * Algo AStar utilisant plusieurs fonctions
	 */
	public void aStarAlgo() {
		Cell current ; // l'état courant
		while (!OPEN.isEmpty() ) { 
			current = OPEN.get(0); // on prend le premier dans OPEN, celui que devrai avoir le f le plus petit
			if(current.estFinal()){
				CLOSED.add(current);
				break;
			}
			CLOSED.add(current);
			OPEN.remove(current);
			Iterator<Cell> it = jeu.iterator(current);
			while(it.hasNext()){ // pour chaque voisin
				Cell nij = it.next(); // le voisin
				jeu.getCells()[nij.getX()][nij.getY()].setColor(2);
				if(CLOSED.contains(nij)){
					continue;
				}
				//System.out.println(nij);
				int DBCandNij; // Distance Between Current & nij, le nouveau cout
				DBCandNij = current.getG() +1 ;
				if(!OPEN.contains(nij) || DBCandNij < nij.getG()){
					nij.setG(DBCandNij);
					nij.setF(nij.getH() + nij.getG());
					nij.setFather(current);
					if(!OPEN.contains(nij)){
						arrange(nij); // si jamais le voisin n'est pas dans OPEN, on l'y range
					}
					//System.out.println("ok");
				}
			}
		}
		if(OPEN.isEmpty()){
			System.out.println(" le système n'admet pas de solutions");
		} else {
			path();
			System.out.println("Chemin trouvé ");
		}
	}

	/*
	 * Fonction arrange, range une case dans ouvert dans l'ordre de f croissant
	 */
	private void arrange(Cell ij) {
		if(OPEN.isEmpty()){
			OPEN.add(ij);
		} else if (ij.getF() < OPEN.get(0).getF()) {
			OPEN.add(0, ij);
		} else {
			for (int index = 1; index < OPEN.size() ; index++){
				if(ij.getF() < OPEN.get(index).getF()){					
					OPEN.add(index,ij);
					break;
				}
				if(index == OPEN.size()-1){
					OPEN.add(ij);
					break;
				}
			}
		}
	}

	
	/*
	 * fonction qui retrouve le chemin 
	 */
	public ArrayList<Cell> path(){
		Cell ij = CLOSED.get(CLOSED.size()-1);
		path.add(ij);
		while(ij.getFather()!=null){
			jeu.getCells()[ij.getX()][ij.getY()].setColor(5);
			path.add((Cell) ij.getFather());
			ij = (Cell) ij.getFather();
		}
		return path;
	}
	
	@Override
	public boolean existeChemin(IJeu i) {
		// TODO Auto-generated method stub
		return false;
	}

	public static void main(String[] args){
		Labyrinthe l = new Labyrinthe(5);
		AStarForMaze as = new AStarForMaze(l);
		as.aStarAlgo();
		ArrayList<Cell> alIJ = as.path();
		for(Cell ij : as.path){
			System.out.println(ij);
		}
	}
}


