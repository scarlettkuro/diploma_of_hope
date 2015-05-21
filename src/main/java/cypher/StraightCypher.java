package cypher;

/**
 * Created by kuro on 21.05.15.
 */

import automata.Automata;
import hope.Decoder;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StraightCypher implements  Cypher  {

    InputStream input;
    OutputStream output;
    Automata automata;

    protected boolean cryptBlock() {
        byte[] hey = new byte[8];
        try {
            input.read(hey);
            automata.setState(Decoder.bytebit(hey));
            output.write(Decoder.bitbyte(automata.getMatrix()));
        } catch (IOException e) {
            return false;
        }

        return true;

    }

    public void crypt(InputStream i,OutputStream o) {
        input = i;
        output = o;
        while(cryptBlock()) ;
    }

    public void setAutomata(Automata a) {
        automata = a;
    }
}