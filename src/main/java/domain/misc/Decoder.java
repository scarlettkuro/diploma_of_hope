package domain.misc;

//transform byte data to boolean data for cellular domain.automata

public class Decoder {
	static public boolean[] bytebit(byte[] orig) {
		boolean[] neu = new boolean[orig.length*8];
		for(int i=0; i<orig.length;i++)
			for(int j=0;j<8;j++)
				neu[i*8 + j] = (orig[i]&(1<<j))!=0;
		
		return neu;
	}
	
	static public byte[] bitbyte(boolean[] orig) {
		byte[] neu = new byte[orig.length/8];
		for(int i=0; i<neu.length;i++){
			byte b = 0;
			for(int j=0;j<8;j++)
				if (orig[i*8 + j]) b += (1<<j);
			neu[i] = b;
		}
		
		return neu;
	}
}
