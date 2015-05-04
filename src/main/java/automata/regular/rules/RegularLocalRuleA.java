package automata.regular.rules;


public class RegularLocalRuleA implements iRegularLocalRule {

	//This rule has solid FALSE border
	public boolean step(int n, boolean[] matrix) {
		boolean prev = n>0 ? matrix[n-1] : false;
		boolean cur = matrix[n];
		boolean next = n<(matrix.length-1) ? matrix[n+1] : false;

		//yes, this is rule
		if (prev && cur && !next)
			return true;
		else if (prev && !cur && !next)
			return true;
		else return false;
		
	}

}
