package cypher;

import automata.regular.RegularAutomata;
import automata.regular.rules.ElementaryFactory;
import cyphermethod.StraightCypherMethod;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by kuro on 05.06.15.
 */
public class StraightCypher implements Cypher {
    StraightCypherMethod method;
    RegularAutomata automata;
    ElementaryFactory ruleFactory;

    public StraightCypher() {
        method = new StraightCypherMethod();
        automata = new RegularAutomata();
        ruleFactory = new ElementaryFactory();

        automata.setRule(ruleFactory.getRule(43));
        method.setAutomata(automata);
    }

    @Override
    public void crypt(InputStream i, OutputStream o) {
        method.crypt(i,o);
    }

    @Override
    public void decrypt(InputStream i, OutputStream o) {
        method.decrypt(i,o);
    }

    @Override
    public String getName() {
        return "Rule 43 Straight Cypher";
    }
}
