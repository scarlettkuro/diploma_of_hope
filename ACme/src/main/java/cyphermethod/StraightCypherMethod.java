package domain.cyphermethod;

/**
 * Created by kuro on 21.05.15.
 */

import domain.automata.ReversibleAutomata;
import domain.misc.Decoder;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StraightCypherMethod implements ReversibleAutomataMethod {

    InputStream input;
    OutputStream output;
    ReversibleAutomata automata;

    protected boolean cryptBlock() {
        try {
            int left = input.available();
            if (left==0) return false;
            byte[] hey = new byte[Math.min(left,8)];
            input.read(hey);
            automata.setState(Decoder.bytebit(hey));
            automata.step(10);
            output.write(Decoder.bitbyte(automata.getMatrix()));
        } catch (IOException e) {
            return false;
        }
        return true;
    }



    protected boolean decryptBlock() {
        try {
            int left = input.available();
            if (left==0) return false;
            byte[] hey = new byte[Math.min(left,8)];
            input.read(hey);
            automata.setState(Decoder.bytebit(hey));
            automata.stepback(10);
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

    public void decrypt(InputStream i, OutputStream o) {
        input = i;
        output = o;
        while(decryptBlock());
    }

    public void setAutomata(ReversibleAutomata a) {
        automata = a;
    }
}