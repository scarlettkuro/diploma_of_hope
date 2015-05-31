package domain.automata;

/**
 * Created by kuro on 21.05.15.
 */
public interface Automata {

    void setState(boolean[] init);
    boolean[] step() ;
    boolean[] step(int n) ;
    boolean[] getMatrix();
}
