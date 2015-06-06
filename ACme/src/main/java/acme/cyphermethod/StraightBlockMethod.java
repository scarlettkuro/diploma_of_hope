package acme.cyphermethod;

import acme.automata.block.BlockAutomata;
import acme.misc.Decoder;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by kuro on 05.06.15.
 */
public class StraightBlockMethod {
    InputStream input;
    OutputStream output;
    BlockAutomata automata;

    protected boolean encryptBlock() {
        try {
            //reading block of data from stream
            int left = input.available();
            if (left==0) return false;
            byte[] datablock = new byte[Math.min(left,8)];
            input.read(datablock);
            //10 step transformation through automata
            automata.setState(Decoder.bytebit(datablock));
            automata.step(10);
            //write block to the outputstream
            output.write(Decoder.bitbyte(automata.getState()));
        } catch (IOException e) {
            //end encrypting when I/O failed or file ended
            return false;
        }
        //continue encrypting
        return true;
    }



    protected boolean decryptBlock() {
        try {
            //reading block of data from stream
            int left = input.available();
            if (left==0) return false;
            byte[] datablock = new byte[Math.min(left,8)];
            input.read(datablock);
            //10 step transformation through automata
            automata.setState(Decoder.bytebit(datablock));
            automata.stepbackFrom(10, 10);
            //write block to the outputstream
            output.write(Decoder.bitbyte(automata.getState()));
        } catch (IOException e) {
            //end decrypting when I/O failed or file ended
            return false;
        }
        //continue decrypting
        return true;
    }

    public void encrypt(InputStream i, OutputStream o, String key) {
        input = i;
        output = o;
        while(encryptBlock());
    }

    public void decrypt(InputStream i, OutputStream o, String key) {
        input = i;
        output = o;
        while(decryptBlock());
    }

    public void setAutomata(BlockAutomata a) {
        automata = a;
    }
}
