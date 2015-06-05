package acme.automata.block.rules;

/**
 * Created by kuro on 04.05.15.
 */
public class BlockLocalRuleA implements iBlockLocalRule {

    private int blocksize = 2;

    public boolean[] step(int n, boolean[] matrix) {
        boolean[] a = new boolean[blocksize];

        //yep, this is the rule
        a[0] = n<(matrix.length-1) ? matrix[n+1] : matrix[0];
        a[1] = matrix[n];

        return a;
    }

    @Override
    public boolean[] stepback(int n, boolean[] matrix) {
        return step(n,matrix); //revert rule is same for this rule
    }

    public int blockSize() {
        return blocksize;
    }
}
