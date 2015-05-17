package maze;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorTaquin implements Iterator{

	private int cpt;
    private ArrayList<IJeu> lp;

    public IteratorTaquin(ArrayList<IJeu> lp){
	cpt = 0;
	this.lp = lp;
    }
	
	@Override
	public boolean hasNext() {
		return cpt > lp.size();
	}

	@Override
	public IJeu next() {
		return lp.get(cpt++);
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}

}
