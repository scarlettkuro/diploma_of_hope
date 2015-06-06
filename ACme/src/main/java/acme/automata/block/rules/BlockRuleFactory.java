package acme.automata.block.rules;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kuro on 07.06.15.
 */
public class BlockRuleFactory {
    public iBlockLocalRule getRule(final int[] states) {


        return new iBlockLocalRule() {
            List<Integer> stateset = new ArrayList<Integer>();
            int size;

            {
                for(int intValue : states)
                    stateset.add(intValue);
                size = (int)Math.floor(Math.log(states.length)/Math.log(2));
            }

            @Override
            public boolean[] step(int n, boolean[] matrix) {
                int state = stateOfB(n,matrix);
                int indexOfNextState = stateset.indexOf(state) + 1 < stateset.size()?
                        stateset.indexOf(state) + 1 : 0;
                return stateOfI(stateset.get(indexOfNextState));
            }

            private int stateOfB(int n, boolean[] matrix) {
                int state = 0;
                for(int i=0; i<size;i++)
                    if (matrix[n+i]) state+=Math.pow(2,i);
                return state;
            }

            private boolean[] stateOfI(int state) {
                boolean[] bits = new boolean[size];
                for (int i = size; i >= 0; i--)
                    bits[i] = (state & (1 << i)) != 0;

                return bits;
            }

            @Override
            public boolean[] stepback(int n, boolean[] matrix) {
                int state = stateOfB(n,matrix);
                int indexOfNextState = stateset.indexOf(state) - 1 >= 0?
                        stateset.indexOf(state) - 1 : stateset.size()-1;
                return stateOfI(stateset.get(indexOfNextState));
            }

            @Override
            public int blockSize() {
                return size;
            }
        };
    }
}
