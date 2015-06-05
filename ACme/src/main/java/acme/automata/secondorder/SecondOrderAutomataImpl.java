package acme.automata.secondorder;

import acme.automata.regular.rules.iRegularLocalRule;
import acme.automata.secondorder.rules.SecondOrderRule;

/**
 * Created by kuro on 06.06.15.
 */
public class SecondOrderAutomataImpl implements SecondOrderAutomata {
    private boolean[] _prev; //previous state of automata
    private boolean[] _cur; //current layer of elements
    private boolean[] _next; //layer  where we put new values of elemets
    private SecondOrderRule rule;

    @Override
    public void setState(boolean[] init) {
        _cur = init;
        _next = _cur.clone();
    }

    @Override
    public void setPreviousState(boolean[] prevInit) {
        _prev = prevInit;
    }

    @Override
    public boolean[] getPreviousState() {
        return _prev;
    }

    @Override
    public boolean[] getState() {
        return _cur;
    }

    @Override
    public boolean[] step() {
        return new boolean[0];
    }

    @Override
    public boolean[] step(int n) {
        return new boolean[0];
    }

    @Override
    public boolean[] stepback() {
        return new boolean[0];
    }

    @Override
    public boolean[] stepback(int n) {
        return new boolean[0];
    }

    @Override
    public void setRule(SecondOrderRule r) {
        rule = r;
    }
}
