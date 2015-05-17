package maze;

import java.util.*;


public class Historique{

    private ArrayList<IJeu> histoIJeu;

    public Historique(){
	this.histoIJeu = new ArrayList<IJeu>();
    }

    public ArrayList<IJeu> getALIJeu(){
	return this.histoIJeu;
    }

    public void setALIJeu( ArrayList <IJeu> alij){
    	this.histoIJeu = alij;
    }
    
    public void add(IJeu ij){
	this.histoIJeu.add(ij);
    }

    public boolean contains(IJeu i){
	boolean contient = false;
	for(IJeu hi : histoIJeu){
	    if(hi.equals(i)){
		contient = true;
	    }
	}
	return contient;
    }

    public String toString(){
    	StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < histoIJeu.size() ; i++){
			sb.append(histoIJeu.get(i).toString());
			sb.append("\n");
		}
    	return sb.toString();
    }
    
//    public static void main(String[] args){
//	
//	Historique h = new Historique();
//	Taquin t1 = new Taquin();
//	Taquin t2 = new Taquin();
//	int[][] np = {{3,6,7},{8,4,1},{2,0,5}};
//	int[][] fini = {{1,2,3},{4,0,6},{7,8,0}};
//	t1.setPlateau(np);
//	t2.setPlateau(np);
//	System.out.println(t1.equals(t2));
//	h.add(t1);
//	System.out.println(h.contains(t1));
//	System.out.println(h.contains(t2));
//	h.add(t2);
//	System.out.println(h.contains(t2));
//    }

}
