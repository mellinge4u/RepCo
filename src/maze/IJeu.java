package maze;

import java.util.*;

public interface IJeu extends Iterable<IJeu>{

    // public Iterator<IJeu> iterator();
    public boolean estFinal();
    public void setPere(IJeu pere);
    public IJeu getPere();
    
}
