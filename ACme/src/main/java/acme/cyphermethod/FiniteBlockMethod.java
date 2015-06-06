package acme.cyphermethod;

import acme.automata.block.BlockAutomata;
import acme.misc.Decoder;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;

/**
 * Created by kuro on 05.06.15.
 */
public class FiniteBlockMethod {
    InputStream input;
    OutputStream output;
    String key;
    boolean[] keyb;
    BlockAutomata automata;
    Random random = new Random();

    int steps = 0;
    boolean[] prevState;

    public FiniteBlockMethod(int stepNumber){
        steps = stepNumber;
    }

    private boolean[] readBlock() throws IOException {

        //reading block of data from stream
        int left = input.available();
        //if (left==0) return false;
        byte[] datablock =
                //new byte[Math.min(left,8)];
                new byte[8];

        input.read(datablock);
        return Decoder.bytebit(datablock);
    }

    protected boolean encryptNextBlock() {
        try {

            //10 step transformation through automata
            automata.setState(Decoder.arrayXOR(readBlock() , prevState));
            automata.step(steps);
            prevState = automata.getState();
            //write block to the outputstream

            output.write(Decoder.bitbyte(automata.getState()));
        } catch (IOException e) {
            //end encrypting when I/O failed or file ended
            return false;
        }
        //continue encrypting
        return true;
    }



    protected boolean decryptNextBlock() {
        try {
            //10 step transformation through automata
          /*  if  (steps ==0) //int steps = 0;
                while(automata.getState().equals(keyb))
                    for (int dx = automata.blockSize(); dx > 0; dx--) {
                        automata.stepbackFrom(dx);
                        steps++;
                    }
            else {

            }
            */
            boolean[] curState = prevState.clone();
            prevState = readBlock();
            automata.setState(prevState.clone());
            automata.stepbackFrom(steps, steps);
            //write block to the outputstream

            output.write(Decoder.bitbyte(
                    Decoder.arrayXOR(curState,automata.getState())
            ));
        } catch (IOException e) {
            //end decrypting when I/O failed or file ended
            return false;
        }
        //continue decrypting
        return true;
    }

    public void encrypt(InputStream i, OutputStream o, String k) {
        //steps = random.nextInt(100) * automata.blockSize();
        input = i;
        output = o;
        key = k;
        prevState = Decoder.bytebit(key.getBytes());
        while(encryptNextBlock());
    }

    public void decrypt(InputStream i, OutputStream o, String k) {
        input = i;
        output = o;
        key = k;
        //keyb = Decoder.bytebit(key.getBytes());
        prevState = Decoder.bytebit(key.getBytes());
        while(decryptNextBlock());
    }

    public void setAutomata(BlockAutomata a) {
        automata = a;
    }
}
