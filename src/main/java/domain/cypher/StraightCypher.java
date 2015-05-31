package domain.cypher;

/**
 * Created by kuro on 21.05.15.
 */

import domain.automata.Automata;
import domain.misc.Decoder;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StraightCypher implements  Cypher  {

    InputStream input;
    OutputStream output;
    Automata automata;

    protected boolean cryptBlock() {
        try {
            int left = input.available();
            if (left==0) return false;
            byte[] hey = new byte[Math.min(left,8)];
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
        while(cryptBlock());
    }

    public void setAutomata(Automata a) {
        automata = a;
    }

    public String getName() {
        return "Straight";
    }
}