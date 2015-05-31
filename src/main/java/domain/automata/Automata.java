package domain.automata;

/**
 * Created by kuro on 21.05.15.
 */
public interface Automata {

    public void setState(boolean[] init);
    public boolean[] step() ;
    public boolean[] step(int n) ;
    public boolean[] getMatrix();
}
