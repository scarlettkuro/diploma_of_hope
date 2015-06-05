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
        BlockAutomata automata = new BlockAutomataImpl();
        automata.setRule(new BlockLocalRuleA());
        method.setAutomata(automata);
    }

    @Override
    public void encrypt(InputStream i, OutputStream o) {
        method.encrypt(i,o);
    }

    @Override
    public void decrypt(InputStream i, OutputStream o) {
        method.decrypt(i,o);
    }

    @Override
    public String getName() {
        return "Some Block Cypher";
    }
}
