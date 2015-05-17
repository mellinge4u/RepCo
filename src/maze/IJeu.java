package maze;

import java.util.*;

public interface IJeu extends Iterable<IJeu>{

    // public Iterator<IJeu> iterator();
    public boolean estFinal();
    public void setFather(IJeu pere);
    public IJeu getFather();
    public IJeu getInit();
    public int getF();
    public int getG();
    public int getH();
    public void setF(int f);
    public void setG(int g);
    public void setH(int h);
}
