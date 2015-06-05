package acme.automata.block;


import acme.automata.block.rules.iBlockLocalRule;

public class BlockAutomataImpl implements  BlockAutomata{
	private boolean[] _cur; //current layer with elements
	int dx = 0; //count of steps
	iBlockLocalRule rule; //local rule

	public BlockAutomataImpl() {
	}
	
	public BlockAutomataImpl(boolean[] init) {
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


	//make n steps
	public boolean[] step(int n) {
		for(int i=0; i<n;i++)
			step();
		return getState();
	}

	@Override
	public boolean[] stepbackFrom(int step) {
		dx = step % rule.blockSize();
		for(int i=dx; i<_cur.length-1; i+=rule.blockSize()) {
			boolean[] ans = rule.step(i, _cur); //get new values of elements in the block
			for(int j=0; j<ans.length;j++) //and put them here
				_cur[i+j] = ans[j];
		}
		dx--; if (dx<0) dx = rule.blockSize()-1;
		return _cur;
	}

	@Override
	public boolean[] stepbackFrom(int stepFrom, int n) {
		for(int i=0; i<n;i++)
			step(stepFrom-i);
		return getState();
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
		return getState();
	}
	
	public boolean[] getState() {
		return _cur;
	}
	
	public void setRule(iBlockLocalRule r) {
		rule = r;
	}
}
