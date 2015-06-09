package acme.automata.block2D;

import acme.automata.block2D.rules.iBlock2DLocalRule;

/**
 * Created by kuro on 05.06.15.
 */
public interface Block2DAutomata {

    void setFirstLine(boolean[] init);
    void setSecondLine(boolean[] init);
    boolean[] getFirstLine();
    boolean[] getSecondLine();
    boolean[][] step();
    boolean[][] step(int n);
    boolean[][] stepbackFrom(int step);
    boolean[][] stepbackFrom(int step, int n);
    void setRule(iBlock2DLocalRule r);
    int blockSize();
}
