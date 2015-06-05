package automata.regular;

import automata.regular.rules.iRegularLocalRule;

/**
 * Created by kuro on 05.06.15.
 */
public interface RegularAutomata {

    void setState(boolean[] init);
    boolean[] step() ;
    boolean[] step(int n) ;
    boolean[] getMatrix();
    void setRule(iRegularLocalRule r);
}
