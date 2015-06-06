package acme.automata.secondorder;

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

        //apply local rule to each element
        for(int i=0; i<_next.length; i++)
            _next[i] = rule.step(i, _prev[i], _cur);

        swapLayers();

        return _cur;
    }

    @Override
    public boolean[] step(int n) {
        for(int i=0; i<n;i++)
            step();
        return getState();
    }

    @Override
    public void reverse() {
        boolean[] temp = _prev;
        _prev = _cur;
        _cur = temp;

    }

    private void swapLayers() {
        boolean[] temp = _prev;
        _prev = _cur;
        _cur = _next;
        _next = temp;
    }



    @Override
    public void setRule(SecondOrderRule r) {
        rule = r;
    }
}
