package domain.automata.block.rules;

public interface iBlockLocalRule {
	boolean[] step(int n, boolean[] matrix);
	int blockSize();
}
