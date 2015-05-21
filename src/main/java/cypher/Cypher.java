package cypher;

import automata.Automata;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by kuro on 22.05.15.
 */
public interface Cypher {
    void crypt(InputStream i,OutputStream o);
    void setAutomata(Automata a);
}
