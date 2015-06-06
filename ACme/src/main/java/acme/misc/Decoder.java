package acme.misc;

//transform byte data to boolean data for cellular automata

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

	static public boolean[] arrayXOR(boolean[] a, boolean[] b) {
		int length = Math.min(a.length,b.length);
		boolean[] result = new boolean[length];
		for (int i=0; i<length; i++)
			result[i] = a[i] ^ b[i];
		return result;
	}
}
