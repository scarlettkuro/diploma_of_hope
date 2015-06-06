package acme.cypher;

import acme.automata.block.BlockAutomata;
import acme.automata.block.BlockAutomataImpl;
import acme.automata.block.rules.BlockLocalRuleA;
import acme.cyphermethod.StraightBlockMethod;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by kuro on 06.06.15.
 */
public class BlockCypherA implements Cypher{

    StraightBlockMethod method;

    public BlockCypherA() {
        method = new StraightBlockMethod();
        BlockAutomata automata = new BlockAutomataImpl();
        automata.setRule(new BlockLocalRuleA());
        method.setAutomata(automata);
    }

    @Override
    public void encrypt(InputStream i, OutputStream o, String key) {
        method.encrypt(i,o, key);
    }

    @Override
    public void decrypt(InputStream i, OutputStream o, String key) {
        method.decrypt(i,o, key);
    }

    @Override
    public String getName() {
        return "Some Block Cypher";
    }
}
