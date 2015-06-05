package acme.automata.regular;

import acme.automata.regular.rules.iRegularLocalRule;

/**
 * Created by kuro on 05.06.15.
 */
public interface RegularAutomata {

    void setState(boolean[] init);
    boolean[] getState();
    boolean[] step() ;
    boolean[] step(int n) ;
    void setRule(iRegularLocalRule r);
}
