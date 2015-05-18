package maze;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* CryptArithmetique */

public class CryptArithmetique implements IJeu {

	private String m1;
	private String m2;
	private String fin;
	private int[] val = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	private HashMap<Character, Integer> hmSI;
	ArrayList<IJeu> alIJeu = new ArrayList<IJeu>();

	public CryptArithmetique(String a, String b, String c) {
		this.m1 = a;
		this.m2 = b;
		this.fin = c;

		hmSI = new HashMap<Character, Integer>();
		// this.retenu = false;
		this.alIJeu = new ArrayList<IJeu>();
	}

	/* getteur des différents champs */

	public String ope1() {
		return m1;
	}

	public String ope2() {
		return m2;
	}

	public String res() {
		return fin;
	}

	/* donne un a chaque lettre un chiffre de 0 à 9 */
	public HashMap<Character, Integer> initVal() {
		HashMap<Character, Integer> shm = new HashMap<>();
		int a = this.m1.length();
		int b = this.m2.length();
		int c = this.fin.length();
		int cpt = 0;
		for (int i = 0; i < a; i++) {
			if (!shm.containsKey(this.m1.charAt(i))) {
				shm.put(m1.charAt(i), val[cpt]);
				cpt++;
			}
		}
		for (int i = 0; i < b; i++) {
			if (!shm.containsKey(this.m2.charAt(i))) {
				shm.put(m2.charAt(i), val[cpt]);
				cpt++;
			}
		}
		for (int i = 0; i < c; i++) {
			if (!shm.containsKey(this.fin.charAt(i))) {
				shm.put(fin.charAt(i), val[cpt]);
				cpt++;
			}
		}
		return shm;

	}

	/* iterator de Crypto */
	public Iterator<IJeu> iterator() {
		for (int i = 1; i < 10; i++) {
			CryptArithmetique cpNew = new CryptArithmetique(this.m1, this.m2,
					this.fin);
			cpNew.val = this.val.clone();
			int tmp = cpNew.val[0];
			cpNew.val[0] = cpNew.val[i];
			cpNew.val[i] = tmp;
			alIJeu.add(cpNew);
		}
		return alIJeu.iterator();
	}

	/* estFinal de cripto 
	 * gere uniquement l'addition
	 * 
	 */
	public boolean estFinal() {
		HashMap<Character, Integer> newHM = this.initVal();
		double resAdd = 0;
		double resFinal = 0;

		for (int i = 0; i < m1.length(); i++) {
			resAdd = resAdd + newHM.get(m1.charAt(i))
					* Math.pow(10, m1.length() - 1 - i);
		}
		for (int i = 0; i < m2.length(); i++) {
			resAdd = resAdd + newHM.get(m2.charAt(i))
					* Math.pow(10, m2.length() - 1 - i);
		}
		for (int i = 0; i < fin.length(); i++) {
			resFinal = resFinal + newHM.get(fin.charAt(i))
					* Math.pow(10, fin.length() - 1 - i);
		}

		return resAdd == resFinal;

	}

	/* n'est pas utilisée */
	public boolean equals(Object o) {

		return this.toString().equals(((CryptArithmetique) o).toString());

	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(hmSI);
		return sb.toString();
	}

	
	/* fonction de test 
	 */
	public static void main(String[] args) {
		CryptArithmetique c1 = new CryptArithmetique("abc", "def", "eik");
		System.out.println(c1);
		System.out.println("taille " + c1.alIJeu.size());
		for (IJeu i : c1) {
			System.out.println(i);
		}
		System.out.println(c1.estFinal());

	}


	@Override
	public IJeu getInit() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setFather(IJeu pere) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IJeu getFather() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getF() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getG() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getH() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setF(int f) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setG(int g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setH(int h) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int costTOneighbor() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}

}
