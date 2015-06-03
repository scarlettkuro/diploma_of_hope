package domain.automata.block;


import domain.automata.Automata;
import domain.automata.ReversibleAutomata;
import domain.automata.block.rules.iBlockLocalRule;

public class BlockAutomata implements ReversibleAutomata {
	private boolean[] _cur; //current layer with elements
	int dx = 0; //count of steps
	iBlockLocalRule rule; //local rule

	public BlockAutomata() {
	}
	
	public BlockAutomata(boolean[] init) {
		setState(init);
	}

	public void setState(boolean[] init) {
		_cur = init;
	}

	public boolean[] step() {
		//apply local rule to each block of the layer
		for(int i=dx; i<_cur.length-1; i+=rule.blockSize()) {
			boolean[] ans = rule.step(i, _cur); //get new values of elements in the block
			for(int j=0; j<ans.length;j++) //and put them here
				_cur[i+j] = ans[j];
		}
		dx++; dx = dx % rule.blockSize();
		return _cur;
	}

	public boolean[] stepback() {
		return new boolean[0];
	}

	//make n steps
	public boolean[] step(int n) {
		for(int i=0; i<n;i++)
			step();
		return getMatrix();
	}

	public boolean[] stepback(int n) {
		//apply local rule to each block of the layer
		dx = n;
		for(int i=(dx % rule.blockSize()); i<_cur.length-1; i+=rule.blockSize()) {
			boolean[] ans = rule.step(i, _cur); //get new values of elements in the block
			for(int j=0; j<ans.length;j++) //and put them here
				_cur[i+j] = ans[j];
		}
		dx--;
		return getMatrix();
	}
	
	public boolean[] getMatrix() {
		return _cur;
	}
	
	public void setRule(iBlockLocalRule r) {
		rule = r;
	}
}
