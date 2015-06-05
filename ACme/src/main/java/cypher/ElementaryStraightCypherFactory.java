package cypher;

import automata.regular.RegularAutomata;
import automata.regular.RegularAutomataImpl;
import automata.regular.rules.ElementaryRuleFactory;
import cyphermethod.StraightCypherMethod;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by kuro on 05.06.15.
 */
public class ElementaryStraightCypherFactory {
    public Cypher getCypher(final int i) {
        return new Cypher() {

            StraightCypherMethod method = new StraightCypherMethod();
            RegularAutomata automata = new RegularAutomataImpl();
            ElementaryRuleFactory ruleFactory = new ElementaryRuleFactory();

            {
                automata.setRule(ruleFactory.getRule(i));
                method.setAutomata(automata);
            }

            @Override
            public void crypt(InputStream i, OutputStream o) {
                method.crypt(i, o);
            }


            @Override
            public void decrypt(InputStream i, OutputStream o) {
                method.decrypt(i, o);
            }

            @Override
            public String getName() {
                return "Rule " + i + " Straight Cypher";
            }

        };

    }


}
