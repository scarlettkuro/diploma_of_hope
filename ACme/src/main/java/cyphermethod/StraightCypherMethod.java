package cyphermethod;

/**
 * Created by kuro on 21.05.15.
 */

import automata.regular.RegularAutomata;
import misc.Decoder;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StraightCypherMethod {

    InputStream input;
    OutputStream output;
    RegularAutomata automata;

    protected boolean cryptBlock() {
        try {
            //reading block of data from stream
            int left = input.available();
            if (left==0) return false;
            byte[] hey = new byte[Math.min(left,8)];
            input.read(hey);
            //10 step transformation through automata
            automata.setState(Decoder.bytebit(hey));
            automata.step(10);
            //write block to the outputstream
            output.write(Decoder.bitbyte(automata.getMatrix()));
        } catch (IOException e) {
            //end crypting when I/O failed or file ended
            return false;
        }
        //continue crypting
        return true;
    }



    protected boolean decryptBlock() {
        return false;
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

    public void setAutomata(RegularAutomata a) {
        automata = a;
    }
}