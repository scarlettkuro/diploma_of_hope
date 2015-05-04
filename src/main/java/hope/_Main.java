package hope;

import automata.block.BlockAutomata;
import automata.block.rules.BlockLocalRuleA;
import automata.regular.RegularAutomata;
import automata.regular.rules.RegularLocalRuleA;

public class _Main {

	public static void main(String[] args) {
		byte[] b = new byte[4];
		b[0] = 'a';
		b[1] = 'b';
		b[2] = 'c';
		b[3] = 'd';
		BlockAutomata a = new BlockAutomata(Decoder.bytebit(b));
		a.setRule(new BlockLocalRuleA());
		/*RegularAutomata a = new RegularAutomata(Decoder.bytebit(b));
		a.setRule(new RegularLocalRuleA());*/
		printMatrix(Decoder.bitbyte(a.getMatrix()));
		for(int i=0; i<100; i++)
			printMatrix(Decoder.bitbyte(a.step()));
			
		
	}
	
	public static void printMatrix(byte[] b) {
		for(int i=0;i<b.length;i++)
			System.out.print(String.format("%02X ", b[i]));

		System.out.println("");
	}

}
