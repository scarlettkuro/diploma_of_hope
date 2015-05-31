package domain.automata;

/**
 * Created by kuro on 22.05.15.
 */
public class TrivialAutomata implements Automata {
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
}
