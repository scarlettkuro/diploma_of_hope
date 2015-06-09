package acme.misc;

import junit.framework.TestCase;

import java.util.Arrays;

/**
 * Created by kuro on 09.06.15.
 */
public class DecoderTest extends TestCase {

    public void testByteBit() throws Exception {
        assertTrue(Arrays.equals(
                Decoder.bitbyte(Decoder.bytebit("SMASH THIS CODE".getBytes())),
                "SMASH THIS CODE".getBytes()
        ));
    }

    public void testArrayXOR() throws Exception {
        assertTrue(Arrays.equals(
                Decoder.arrayXOR(new boolean[]{false, false}, new boolean[]{true, false}),
                new boolean[]{true,false}
        ));
    }

    public void testArrayDoubleXOR() throws Exception {
        boolean[] a = new boolean[]{true,false};
        boolean[] b = new boolean[] {false,true};
        assertTrue(Arrays.equals(
                Decoder.arrayXOR(Decoder.arrayXOR(a,b),a),
                b
        ));
    }
}