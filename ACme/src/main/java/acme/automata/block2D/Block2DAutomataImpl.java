package acme.automata.block2D;


import acme.automata.block.BlockAutomata;
import acme.automata.block.rules.iBlockLocalRule;
import acme.automata.block2D.rules.iBlock2DLocalRule;

public class Block2DAutomataImpl implements  Block2DAutomata{
	private boolean[][] _cur; //current layer with elements
	int dx = 0; //count of steps
	iBlock2DLocalRule rule; //local rule



	@Override
	public void setFirstLine(boolean[] init) {
		_cur[0] = init;
	}

	@Override
	public void setSecondLine(boolean[] init) {
		_cur[1] = init;
	}

	@Override
	public boolean[] getFirstLine() {
		return _cur[0];
	}

	@Override
	public boolean[] getSecondLine() {
		return _cur[1];
	}

	public boolean[][] step() {
		//apply local rule to each block of the layer
		for(int i=dx; i<_cur.length-1; i+=rule.blockSize()) {
			boolean[][] ans = rule.step(i, _cur); //get new values of elements in the block
			for(int k=0;k<ans.length; k++)
				for(int j=0; j<ans.length;j++) //and put them here
					_cur[k][i+j] = ans[k][j];
		}
		dx++; dx = dx % rule.blockSize();
		return _cur;
	}


	//make n steps
	public boolean[][] step(int n) {
		for(int i=0; i<n;i++)
			step();
		return _cur;
	}

	@Override
	public boolean[][] stepbackFrom(int step) {
		dx = step % rule.blockSize();
		for(int i=dx; i<_cur.length-1; i+=rule.blockSize()) {
			boolean[][] ans = rule.step(i, _cur); //get new values of elements in the block
			for(int k=0;k<ans.length; k++)
				for(int j=0; j<ans.length;j++) //and put them here
					_cur[k][i+j] = ans[k][j];
		}
		dx--; if (dx<0) dx = rule.blockSize()-1;
		return _cur;
	}

	@Override
	public boolean[][] stepbackFrom(int stepFrom, int n) {
		for(int i=0; i<n;i++)
			step(stepFrom-i);
		return _cur;
	}

	@Override
	public void setRule(iBlock2DLocalRule r) {	rule = r;}

	@Override
	public int blockSize() {
		return rule.blockSize();
	}
}
