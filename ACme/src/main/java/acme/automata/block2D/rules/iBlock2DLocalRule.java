package acme.automata.block2D.rules;

public interface iBlock2DLocalRule {
	boolean[][] step(int n, boolean[][] matrix);
	boolean[][] stepback(int n, boolean[][] matrix);
	int blockSize();
}
