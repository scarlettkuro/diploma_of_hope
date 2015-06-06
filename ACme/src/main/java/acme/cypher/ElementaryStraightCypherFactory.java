package acme.cypher;

import acme.automata.regular.RegularAutomata;
import acme.automata.regular.RegularAutomataImpl;
import acme.automata.regular.rules.ElementaryRuleFactory;
import acme.cyphermethod.StraightRegularMethod;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by kuro on 05.06.15.
 */
public class ElementaryStraightCypherFactory {
    public Cypher getCypher(final int i) {
        return new Cypher() {

            StraightRegularMethod method = new StraightRegularMethod();
            RegularAutomata automata = new RegularAutomataImpl();
            ElementaryRuleFactory ruleFactory = new ElementaryRuleFactory();

            {
                automata.setRule(ruleFactory.getRule(i));
                method.setAutomata(automata);
            }

            @Override
            public void encrypt(InputStream i, OutputStream o, String key) {
                method.encrypt(i, o, key);
            }


            @Override
            public void decrypt(InputStream i, OutputStream o, String key) {
                method.decrypt(i, o, key);
            }

            @Override
            public String getName() {
                return "Rule " + i + " Straight Cypher";
            }

        };

    }


}
