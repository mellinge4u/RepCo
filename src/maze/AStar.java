package maze;

import java.util.ArrayList;
import java.util.Iterator;

public class AStar implements IRecherche {
	
	private ArrayList<IJeu> OPEN ; // OPEN la liste des noeuds � �tudier
	private Historique CLOSED; // CLOSED la liste des noeuds d�j� �tudi�s, la classe historique est pratique pour �a  
	
	
	@Override
	public boolean existeChemin(IJeu i) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
