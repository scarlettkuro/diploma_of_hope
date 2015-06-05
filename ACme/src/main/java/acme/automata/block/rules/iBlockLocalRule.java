package acme.automata.block.rules;

public interface iBlockLocalRule {
	boolean[] step(int n, boolean[] matrix);
	boolean[] stepback(int n, boolean[] matrix);
	int blockSize();
}
