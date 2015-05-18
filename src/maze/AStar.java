package maze;

import java.util.ArrayList;
import java.util.Iterator;

public class AStar implements IRecherche {

	private ArrayList<IJeu> OPEN; // OPEN la liste des noeuds à étudier
	private ArrayList<IJeu> path; // chemin que l'on aura trouvé
	private Historique CLOSED; // CLOSED la liste des noeuds déjà étudiés, la
								// classe historique est pratique pour ça
	private IJeu s0; // state 0 , état initiale
	private IJeu jeu; // Ici ce sera un labyrinthe
	
	public AStar(IJeu ij) {
		OPEN = new ArrayList<>();
		path = new ArrayList<>();
		CLOSED = new Historique();
		s0 = ij.getInit();
		OPEN.add(s0);
		this.jeu = ij;
	}

	/*
	 * Algo AStar utilisant plusieurs fonctions
	 */
	public void aStarAlgo() {
		IJeu current ; // l'état courant
		while (!OPEN.isEmpty() ) { 
			current = OPEN.get(0); // on prend le premier dans OPEN, celui que devrai avoir le f le plus petit
			if(current.estFinal()){
				path.add(current);
			}
			CLOSED.add(current);
			OPEN.remove(current);
			Iterator<IJeu> it = jeu.iterator();
			while(it.hasNext()){ // pour chaque voisin
				IJeu nij = it.next(); // le voisin
				if(CLOSED.contains(nij)){
					
				}
				System.out.println(nij);
				int DBCandNij; // Distance Between Current & nij, le nouveau cout
				DBCandNij = nij.getG() - current.getG();
				if(!OPEN.contains(nij) || DBCandNij < nij.getG()){
					nij.setG(DBCandNij);
					nij.setF(nij.getH() + nij.getG());
					nij.setFather(current);
					if(!OPEN.contains(nij)){
						arrange(nij); // si jamais le voisin n'est pas dans OPEN, on l'y range
					}
					System.out.println("ok");
				}
			}
		}
		if(OPEN.isEmpty()){
			System.out.println(" le système n'admet pas de solutions");
		} else {
			System.out.println("Chemin trouvé ");
		}
	}

	/*
	 * Fonction arrange, range une case dans ouvert dans l'ordre de f croissant
	 */
	private void arrange(IJeu ij) {
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
	public ArrayList<IJeu> path(){
		IJeu ij = CLOSED.getALIJeu().get(CLOSED.getALIJeu().size());
		path.add(ij);
		while(ij.getFather()!=null){
			path.add(ij.getFather());
			ij = ij.getFather();
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
		AStar as = new AStar(l);
		as.aStarAlgo();
		ArrayList<IJeu> alIJ = as.path();
		for(IJeu ij : alIJ){
			System.out.println(ij);
		}
	}
}
