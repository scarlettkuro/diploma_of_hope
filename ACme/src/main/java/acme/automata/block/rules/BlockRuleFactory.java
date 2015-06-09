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
                for(int i=0;i<states.length;i++)
                //for(int intValue : states)
                    stateset.add(i,states[i]);
                size = (int)Math.floor(Math.log(states.length)/Math.log(2));
            }

            @Override
            public boolean[] step(int n, boolean[] matrix) {
                int state = stateOfB(n,matrix);
                int indexOfNextState = stateset.indexOf(state) + 1 < stateset.size()?
                        stateset.indexOf(state) + 1 : 0;
                return stateOfI(stateset.get(indexOfNextState));
            }

            @Override
            public boolean[] stepback(int n, boolean[] matrix) {
                int state = stateOfB(n,matrix);
                System.out.println("was: " + state);
                int indexOfNextState = stateset.indexOf(state) - 1 > 0?
                        stateset.indexOf(state) - 1 : stateset.size()-1;
                        //stateset.indexOf(state) + 1 : 0;
                System.out.println("next: " + indexOfNextState );
                return stateOfI(stateset.get(indexOfNextState));
            }

            private int stateOfB(int n, boolean[] matrix) {
                int state = 0;
                for(int i=0; i<size;i++)
                    if (matrix[n+size-i-1]) state+=Math.pow(2,i);
                System.out.println(state);
                return state;
            }

            private boolean[] stateOfI(int state) {
                boolean[] bits = new boolean[size];
                for (int i = size-1; i >= 0; i--)
                    bits[size-i-1] =
                  //          System.out.println
                                    ((state & (1 << i)) != 0)
                ;
                for (int i=0; i<size;i++)
                    System.out.println(bits[i]);
                return bits;
            }

            @Override
            public int blockSize() {
                return size;
            }
        };
    }
}
