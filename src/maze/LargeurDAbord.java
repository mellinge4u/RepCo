package maze;

import java.util.*;

public class LargeurDAbord implements IRecherche {

	private ArrayList<IJeu> alChemin;

	public LargeurDAbord() {
		this.alChemin = new ArrayList<IJeu>();
	}

	public boolean isInList(IJeu iJ) {
		int cpt = 0;
		boolean bool = false;
		while(!bool && cpt < alChemin.size()){
			bool = alChemin.get(cpt).toString().equals(iJ.toString());
			cpt++;
		}
		return bool;
	}

	public boolean existeChemin(IJeu i) {
		boolean chemin = false;
		int cpt = 0;
		if (!this.isInList(i)) {
			this.alChemin.add(i);
			// while (alChemin.iterator().hasNext() && !chemin) {

			
			this.alChemin.add(i.iterator().next());
			
			while (cpt < alChemin.size() && chemin == false) {
				if (alChemin.get(cpt).estFinal()) {
					chemin = true;
				} else {
					for (IJeu jeu : alChemin.get(cpt)) {
						if (!this.isInList(jeu))
							this.alChemin.add(jeu);
					}

				}
				cpt = cpt + 1;

			}
		}
		Historique h = new Historique();
		h.setALIJeu(alChemin);
		return chemin;
	}

	public void setTaquin(Taquin t) {
		this.alChemin.add(t);
	}

//	public static void main(String[] args) {
//
//		LargeurDAbord lad = new LargeurDAbord();
//		Taquin tq1 = new Taquin();
//		Taquin tq2 = new Taquin();
//		Taquin tq3 = new Taquin();
//		Taquin tq4 = new Taquin();
//		int[][] np = { { 2, 3, 6 }, { 1, 5, 0 }, { 4, 7, 8 } };
//		int[][] fini = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 0 } };
//		int[][] preskFini = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 0, 8 } };
//		int[][] taquinchelou = { { 6, 3, 5 }, { 4, 1, 7 }, { 2, 8, 0 } };
//		tq1.setPlateau(np);
//		tq2.setPlateau(np);
//		tq3.setPlateau(preskFini);
//		tq4.setPlateau(taquinchelou);
//		System.out.println("tq4 est final ?" + tq4.estFinal());
//		//lad.setTaquin(tq1);
//		// lad.setTaquin(tq3);
//		// System.out.println(tq1.iterator().next());
//		System.out.println("tq1 = tq2 ? " + tq1.equals(tq2));
//		System.out.println(lad.isInList(tq1));
//		System.out.println(lad.alChemin.contains(tq2.toString()));
//		System.out.println(lad.isInList(tq2));
//		System.out.println(lad.existeChemin(tq1));
//		
//
//	}

}
