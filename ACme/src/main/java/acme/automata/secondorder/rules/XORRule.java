package acme.automata.secondorder.rules;

import acme.automata.regular.rules.iRegularLocalRule;

/**
 * Created by kuro on 06.06.15.
 */
public class XORRule implements SecondOrderRule {
    iRegularLocalRule regularRule;

    public XORRule(iRegularLocalRule rule) {
        regularRule = rule;
    }

    @Override
    public boolean step(int n, boolean prev, boolean[] matrix) {

        return regularRule.step(n,matrix) ^ prev;
    }
}
