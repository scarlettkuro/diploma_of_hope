package acme.automata.block;

import acme.automata.block.rules.iBlockLocalRule;

/**
 * Created by kuro on 05.06.15.
 */
public interface BlockAutomata {

    void setState(boolean[] init);
    boolean[] getState();
    boolean[] step();
    boolean[] step(int n);
    boolean[] stepbackFrom(int step);
    boolean[] stepbackFrom(int step, int n);
    void setRule(iBlockLocalRule r);
}
