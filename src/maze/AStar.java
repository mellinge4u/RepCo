package maze;

import java.util.ArrayList;
import java.util.Iterator;

public class AStar implements IRecherche {
	
	private ArrayList<IJeu> OPEN ; // OPEN la liste des noeuds à étudier
	private Historique CLOSED; // CLOSED la liste des noeuds déjà étudiés, la classe historique est pratique pour ça  
	
	
	@Override
	public boolean existeChemin(IJeu i) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
