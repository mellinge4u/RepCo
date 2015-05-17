package maze;

import java.util.*;

public class ProfondeurDAbord implements IRecherche {

	private ArrayList<IJeu> chemin;

	public ProfondeurDAbord() {
		this.chemin = new ArrayList<IJeu>();
	}

	public boolean existeChemin(IJeu i) {
		boolean Echemin = false;
		Historique h = new Historique();
		if (i.estFinal()) {
			Echemin = true;
			this.chemin(i);
		} else {
			
			Iterator<IJeu> it = i.iterator();
			
			while(it.hasNext() && !Echemin) {
				IJeu nIj = it.next();
				nIj.setFather(i);
				h.add(nIj);
				Echemin = existeChemin(nIj, h);
			}
		}
		
		return Echemin;
	}

	private boolean existeChemin(IJeu i, Historique h) {
		boolean Echemin = false;
		if (i.estFinal()) {
			Echemin = true;
		} else {
			Iterator<IJeu> it = i.iterator(); 
			
			while(it.hasNext() && !Echemin){
				IJeu nIj = it.next();
				if(!h.contains(nIj)){
					h.add(nIj);
					Echemin = existeChemin(nIj, h);
				}
			}
		}
		return Echemin;
	}

	public void chemin(IJeu i){
		while(i.getFather() != null){
			chemin.add(i);
			i = i.getFather();
		}
	}
	
	public ArrayList<IJeu> getChemin(){
		return chemin;
	}
	
}
