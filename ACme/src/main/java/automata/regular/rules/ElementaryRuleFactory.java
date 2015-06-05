package automata.regular.rules;

/**
 * Created by kuro on 05.06.15.
 */
public class ElementaryRuleFactory {
    public iRegularLocalRule getRule(final int i) {
        return new iRegularLocalRule() {
            @Override
            public boolean step(int n, boolean[] matrix) {
                int state = 0;
                if (matrix[n-1]) state+=4;
                if ( matrix[n] ) state+=2;
                if (matrix[n+1]) state+=1;

                return ((i >> state) & 1)==1;
            }
        };
    }
}
