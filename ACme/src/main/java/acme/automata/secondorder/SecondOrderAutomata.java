package acme.automata.secondorder;

import acme.automata.secondorder.rules.SecondOrderRule;

/**
 * Created by kuro on 06.06.15.
 */
public interface SecondOrderAutomata {
    void setState(boolean[] init);
    void setPreviousState(boolean[] prevInit);
    boolean[] getPreviousState();
    boolean[] getState();
    boolean[] step();
    boolean[] step(int n);
    boolean[] stepback();
    boolean[] stepback(int n);
    void setRule(SecondOrderRule r);
}
