package hope;

import automata.block.BlockAutomata;
import automata.block.rules.*;
import cypher.StraightCypher;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class _Main {

	public static void main(String[] args) {
		/*byte[] b = new byte[42];
		for(int i=0;i<b.length;i++)
			b[i] = 'a';
		BlockAutomata a = new BlockAutomata(Decoder.bytebit(b));
		a.setRule(new BlockLocalRuleB());
		printMatrix(Decoder.bitbyte(a.getMatrix()));
		for(int i=0; i<100; i++)
			printMatrix(Decoder.bitbyte(a.step()));
		*/
		StraightCypher crypt = new StraightCypher();
		BlockAutomata a = new BlockAutomata();
		a.setRule(new BlockLocalRuleA());
		crypt.setAutomata(a);
		try {
			FileInputStream fi = new FileInputStream("suka");
			System.out.println("hello");
			FileOutputStream fo = new FileOutputStream("sukad");
			crypt.crypt(fi, fo);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void printMatrix(byte[] b) {
		for(int i=0;i<b.length;i++)
			System.out.print(String.format("%02X ", b[i]));

		System.out.println("");
	}

}
