package acme.cyphermethod;

import acme.automata.block.BlockAutomata;
import acme.misc.Decoder;
import acme.misc.BooleanStreamReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by kuro on 09.06.15.
 */
public class StraightBlockCBCMethod {
    InputStream input;
    BooleanStreamReader inputReader = new BooleanStreamReader();
    OutputStream output;
    String key;
    BlockAutomata automata;

    int steps = 0;
    int blockSize = 1;
    boolean[] prevState;
   // boolean[] curState;

    public StraightBlockCBCMethod(int stepNumber){
        steps = stepNumber;
    }


    protected boolean encryptNextBlock() {
        try {

            //10 step transformation through automata
            automata.setState(Decoder.arrayXOR(inputReader.readBlock(blockSize, false), prevState));
            //automata.setState(inputReader.readBlock(blockSize,false));
            automata.step(steps);
            prevState = automata.getState().clone();
            //write block to the outputstream

            output.write(Decoder.bitbyte(automata.getState()));
        } catch (Exception e) {
            //end encrypting when I/O failed or file ended
            return false;
        }
        //continue encrypting
        return true;
    }



    protected boolean decryptNextBlock() {
        try {
            //prevState = inputReader.readBlock(blockSize, false);
            //prevState = readBlock();
            boolean[] curState = inputReader.readBlock(blockSize, false);
            automata.setState(curState.clone());
            automata.stepbackFrom(steps, steps);
            //write block to the outputstream

            output.write(Decoder.bitbyte(
                    Decoder.arrayXOR(prevState, automata.getState())
                    //automata.getState()
            ));
            prevState= curState;
        } catch (Exception e) {
            //end decrypting when I/O failed or file ended
            return false;
        }
        //continue decrypting
        return true;
    }

    public void encrypt(InputStream i, OutputStream o, String k) {
        input = i;
        inputReader.setStream(input);
        output = o;
        key = k;
        prevState = Decoder.bytebit(k.getBytes());
        while(encryptNextBlock());
    }

    public void decrypt(InputStream i, OutputStream o, String k) {
        input = i;
        output = o;
        key = k;
        prevState = Decoder.bytebit(k.getBytes());
        while(decryptNextBlock());
    }

    public void setAutomata(BlockAutomata a) {
        automata = a;
    }

    public void setBlockSize(int s) {
        blockSize = s;
    }
}
