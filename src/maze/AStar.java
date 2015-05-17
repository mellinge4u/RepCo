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
		IJeu s = s0;
		while (!OPEN.isEmpty() && !OPEN.get(0).estFinal()) { // y a pas un soucis là ?
			CLOSED.add(s);
			OPEN.remove(s);
			Iterator<IJeu> it = jeu.iterator();
			while(it.hasNext()){
				IJeu nij = it.next();
				if((!OPEN.contains(nij) && !CLOSED.contains(nij)) || nij.getG() > s.getG()){
					nij.setG(s.getG());
					nij.setF(nij.getH() + nij.getG());
					nij.setFather(s);
					arrange(nij);
				}
				if(CLOSED.contains(nij)){
					// CLOSED = CLOSED{nij}
				}
			}
			// SI OPEN = ? alors s = tete(OPEN)
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

	//public ArrayList<IJeu> path(){
		
	//}
	
	@Override
	public boolean existeChemin(IJeu i) {
		// TODO Auto-generated method stub
		return false;
	}

	public static void main(String[] args){
		Labyrinthe l = new Labyrinthe(5);
		AStar as = new AStar(l);
		as.aStarAlgo();
		//while(l.getCells()[9][9])
	}
}
