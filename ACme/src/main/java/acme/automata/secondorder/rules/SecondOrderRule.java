package acme.automata.secondorder.rules;

/**
 * Created by kuro on 06.06.15.
 */
public interface SecondOrderRule {
    boolean step(int n, boolean prev, boolean[] matrix);
}
