package acme.cypher;

import acme.automata.block.BlockAutomata;
import acme.automata.block.BlockAutomataImpl;
import acme.automata.block.rules.BlockRuleFactory;
import acme.cyphermethod.FiniteBlockMethod;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by kuro on 07.06.15.
 */
public class FiniteBlockCypherFactory {
    public Cypher getCypher(final int stepsNumber, final int[] states) {
        return new Cypher() {
            FiniteBlockMethod method = new FiniteBlockMethod(stepsNumber);
            BlockRuleFactory factory = new BlockRuleFactory();
            BlockAutomata automata = new BlockAutomataImpl();
            {
                automata.setRule(factory.getRule(states));
                method.setAutomata(automata);
            }
            @Override
            public void encrypt(InputStream i, OutputStream o, String key) {
                method.encrypt(i,o,key);
            }

            @Override
            public void decrypt(InputStream i, OutputStream o, String key) {
                method.decrypt(i, o, key);
            }

            @Override
            public String getName() {
                String id ="";
                for(int s:states)
                    id += s;
                return id + " Block Cypher with " + stepsNumber + " steps";
            }
        };
    }
}
