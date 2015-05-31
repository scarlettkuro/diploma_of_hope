package domain.cyphermethod;

import domain.automata.Automata;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by kuro on 31.05.15.
 */
public interface CypherMethod {
    void crypt(InputStream i,OutputStream o);
    void decrypt(InputStream i,OutputStream o);
    void setAutomata(Automata a);
}
