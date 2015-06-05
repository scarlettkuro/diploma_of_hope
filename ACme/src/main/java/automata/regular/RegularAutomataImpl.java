package automata.regular;

import automata.regular.rules.iRegularLocalRule;

public class RegularAutomataImpl implements  RegularAutomata {
	private boolean[] _cur; //current layer of elements
	private boolean[] _next; //layer  where we put new values of elemets
	private iRegularLocalRule rule;

	public RegularAutomataImpl() {}
	
	public RegularAutomataImpl(boolean[] init) {
		setState(init);
	}

	public void setState(boolean[] init) {
		_cur = init;
		_next = _cur.clone();
	}

	public boolean[] step() {
		//apply local rule to each element
		for(int i=0; i<_next.length; i++)
			_next[i] = rule.step(i, _cur);

		swapLayers();
		
		return _cur;
	}

	private void swapLayers() { //switch layers when we form next generation (make it current)
		boolean[] temp = _cur;
		_cur = _next;
		_next = temp;
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
	
	public void setRule(iRegularLocalRule r) {
		rule = r;
	}
	
	
	
}
