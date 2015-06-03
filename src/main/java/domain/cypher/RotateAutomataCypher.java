package domain.cypher;

import domain.automata.ReversibleAutomata;
import domain.automata.block.BlockAutomata;
import domain.automata.block.rules.BlockLocalRuleA;
import domain.cyphermethod.ReversibleAutomataMethod;
import domain.cyphermethod.StraightCypherMethod;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by kuro on 03.06.15.
 */
public class RotateAutomataCypher implements Cypher {
    BlockLocalRuleA rule;
    ReversibleAutomata automata;
    ReversibleAutomataMethod cypher;

    public RotateAutomataCypher() {
        rule = new BlockLocalRuleA();
        automata = new BlockAutomata();
        ((BlockAutomata)automata).setRule(rule);
        cypher = new StraightCypherMethod();
        cypher.setAutomata(automata);
    }

    public void crypt(InputStream i, OutputStream o) {
        cypher.crypt(i,o);
    }

    public void decrypt(InputStream i, OutputStream o) {
        cypher.decrypt(i,o);
    }

    public String getName() {
        return "Rotate Cypher";
    }
}
