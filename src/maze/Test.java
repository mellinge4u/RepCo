package maze;

import java.util.*;

public class Test {

	public static void main(String[] argv) {

		/*
		 * Le plateau 1 se déroule assez vite avec les différents algos, avec
		 * le plateau 2 on trouve une solution au bout de 2 min avec
		 * largeurDabort, et stackoverflow avec longueurDAbord
		 */

		Taquin taquin1 = new Taquin(1);
		ProfondeurDAbord prof1 = new ProfondeurDAbord();
		LargeurDAbord larg1 = new LargeurDAbord();

		int[][] plateau1 = { { 2, 3, 6 }, { 1, 0, 5 }, { 4, 7, 8 } };
		int[][] plateau2 = { { 1, 0, 8 }, { 4, 6, 5 }, { 7, 3, 2 } };
		int[][] plateau3 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 0, 8 } };
		int[][] plateau4 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 0, 8 } };

		// ArrayList<IJeu> alIJeu = new ArrayList<IJeu>();

		taquin1.setPlateau(plateau1);
//		System.out.println(taquin1);
//		System.out.println(taquin1.swapLeft());
//		System.out.println("abs:" + taquin1.getAbs(0) + " ord "
//				+ taquin1.getOrd(0) + " en bas ? " + taquin1.enBas()
//				+ " en haut ? " + taquin1.enHaut() + " a Droite ? "
//				+ taquin1.aDroite() + " a Gauche ? " + taquin1.aGauche());
//
//		for (IJeu t : taquin1) {
//			System.out.println(t);
//			;
//		}
//		long start = System.currentTimeMillis();
//		System.out.println("Largeur d'Abord Taquin :"
//				+ larg1.existeChemin(taquin1));
//		long end = System.currentTimeMillis();
//		System.out.println((end - start) + " millisecondes");
		long start1 = System.currentTimeMillis();
		//System.out.println("Prof d'ab Taquin :" + prof1.existeChemin(taquin1));
		System.out.println(prof1.existeChemin(taquin1));
		System.out.println(prof1.getChemin().size());
		long end1 = System.currentTimeMillis();
		System.out.println((end1 - start1) + " millisecondes");

//		CryptArithmetique c1 = new CryptArithmetique("agc", "eff", "eik");
//
//		long start2 = System.currentTimeMillis();
//		System.out.println("Largeur d'Abord Cripto :" + larg1.existeChemin(c1));
//		long end2 = System.currentTimeMillis();
//		System.out.println((end2 - start2) + " millisecondes");
//		long start3 = System.currentTimeMillis();
//		System.out.println("Prof d'ab Cripto :" + prof1.existeChemin(c1));
//		long end3 = System.currentTimeMillis();
//		System.out.println((end3 - start3) + " millisecondes");
	}

}
