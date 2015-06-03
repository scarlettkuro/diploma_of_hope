package domain.automata;

/**
 * Created by kuro on 31.05.15.
 */
public interface ReversibleAutomata extends Automata {
    boolean[] stepback() ;
    boolean[] stepback(int n) ;
}
