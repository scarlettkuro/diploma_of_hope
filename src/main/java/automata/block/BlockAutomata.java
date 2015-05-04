package automata.block;


import automata.block.rules.iBlockLocalRule;

public class BlockAutomata {
	private boolean[] _cur; //current layer with elements
	int dx = 0; //count of steps
	iBlockLocalRule rule; //local rule
	
	public BlockAutomata(boolean[] init) {
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

	//make n steps
	public boolean[] step(int n) {
		for(int i=0; i<n;i++)
			step();
		return getMatrix();
	}
	
	public boolean[] getMatrix() {
		return _cur;
	}
	
	public void setRule(iBlockLocalRule r) {
		rule = r;
	}
}
