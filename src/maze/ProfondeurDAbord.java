package maze;

import java.util.*;

public class ProfondeurDAbord implements IRecherche {

	//private ArrayList<Integer[][]> chemin;

	public ProfondeurDAbord() {
		//this.chemin = new ArrayList<Integer[][]>();
	}

	public Historique existeChemin(IJeu i) {
		boolean chemin = false;
		Historique h = new Historique();
		if (i.estFinal()) {
			chemin = true;
		} else {
			
			Iterator<IJeu> it = i.iterator();
			
			while(it.hasNext() && !chemin) {
				IJeu nIj = it.next();
				h.add(nIj);
				chemin = existeChemin(nIj, h);
			}
		}
		
		return h;
	}

	private boolean existeChemin(IJeu i, Historique h) {
		boolean chemin = false;
		if (i.estFinal()) {
			chemin = true;
		} else {
			Iterator<IJeu> it = i.iterator(); 
			
			while(it.hasNext() && !chemin){
				IJeu nIj = it.next();
				if(!h.contains(nIj)){
					h.add(nIj);
					chemin = existeChemin(nIj, h);
				}
			}
		}
		return chemin;
	}

	
	
}
