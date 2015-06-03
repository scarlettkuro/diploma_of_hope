package domain.automata.trivial;

import domain.automata.Automata;
import domain.automata.ReversibleAutomata;

/**
 * Created by kuro on 22.05.15.
 */
public class TrivialAutomata implements ReversibleAutomata {
    boolean[] state;
    public void setState(boolean[] init) {
        state = init;
    }

    public boolean[] step() {
        return state;
    }

    public boolean[] step(int n) {
        return state;
    }

    public boolean[] getMatrix() {
        return state;
    }

    public boolean[] stepback() {
        return state;
    }

    public boolean[] stepback(int n)  {
        return state;
    }
}
