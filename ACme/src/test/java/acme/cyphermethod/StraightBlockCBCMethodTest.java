package acme.cyphermethod;

import acme.automata.block.BlockAutomata;
import acme.automata.block.BlockAutomataImpl;
import acme.automata.block.rules.BlockRuleFactory;
import junit.framework.TestCase;

import java.io.*;
import java.util.Arrays;

/**
 * Created by kuro on 09.06.15.
 */
public class StraightBlockCBCMethodTest extends TestCase {

    public void testEncryptDecrypt() throws Exception {

        String INPUTDATA = "no";

        StraightBlockCBCMethod method = new StraightBlockCBCMethod(10);
        InputStream en_inputStream = new ByteArrayInputStream(INPUTDATA.getBytes());
        OutputStream en_outputStream = new ByteArrayOutputStream();
        BlockAutomata automata = new BlockAutomataImpl();
        BlockRuleFactory factory = new BlockRuleFactory();

        automata.setRule(factory.getRule(new int[]{0, 1}));
        method.setAutomata(automata);
        /*
        System.out.println("Source:");
        System.out.println(new String("nope".getBytes(), "Cp1252"));
*/

        method.encrypt(en_inputStream, en_outputStream, "s");
/*
        System.out.println("Encrypted:");
        System.out.println(new String(((ByteArrayOutputStream) en_outputStream).toByteArray(), "Cp1252"));
*/
        InputStream de_inputStream = new ByteArrayInputStream(((ByteArrayOutputStream)en_outputStream).toByteArray());
        OutputStream de_outputStream = new ByteArrayOutputStream();

        method.encrypt(de_inputStream, de_outputStream, "s");
/*
        System.out.println("Decrypted:");
        System.out.println(new String(((ByteArrayOutputStream) de_outputStream).toByteArray(), "Cp1252"));
*/
        assertTrue(Arrays.equals(
                ((ByteArrayOutputStream) de_outputStream).toByteArray(),
                INPUTDATA.getBytes()
        ));

        //assertTrue(true);
    }

}