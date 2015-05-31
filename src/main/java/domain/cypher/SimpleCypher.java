package domain.cypher;

import domain.automata.Automata;
import domain.automata.ReversibleAutomata;
import domain.automata.trivial.TrivialAutomata;
import domain.cyphermethod.ReversibleAutomataMethod;
import domain.cyphermethod.StraightCypherMethod;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by kuro on 31.05.15.
 */
public class SimpleCypher implements  Cypher{
    ReversibleAutomata automata = new TrivialAutomata();
    ReversibleAutomataMethod method = new StraightCypherMethod();

    public SimpleCypher() {
        method.setAutomata(automata);
    }

    public void crypt(InputStream i, OutputStream o) {
        method.crypt(i,o);
    }

    public void decrypt(InputStream i, OutputStream o) {
        method.decrypt(i,o);
    }

    public String getName() {
        return "Simple cypher";
    }
}
