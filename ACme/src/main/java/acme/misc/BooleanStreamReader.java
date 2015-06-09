package acme.misc;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by kuro on 09.06.15.
 */
public class BooleanStreamReader {
    InputStream input;

    public BooleanStreamReader() {    }


    public BooleanStreamReader(InputStream i) {
        input = i;
    }

    public boolean[] readBlock(int size, boolean hardSize) throws IOException, EndOfDataExpection {

        //reading block of data from stream
        int left = input.available();

        if (left==0) throw new EndOfDataExpection();

        int sizeOfBlock = hardSize? size : Math.min(left,size);
        byte[] datablock = new byte[sizeOfBlock];


        input.read(datablock);

        return Decoder.bytebit(datablock);
    }


    public void setStream(InputStream i) {
        input = i;
    }

    private class EndOfDataExpection extends Exception {
    }
}
