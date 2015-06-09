package acme.automata.block;

import acme.automata.block.rules.BlockRuleFactory;
import acme.automata.block.rules.BlockRuleFactoryTest;
import junit.framework.TestCase;

import java.util.Arrays;

/**
 * Created by kuro on 08.06.15.
 */
public class BlockAutomataImplTest extends TestCase {
    BlockAutomata automata = new BlockAutomataImpl();
    BlockRuleFactory factory = new BlockRuleFactory();
    {
        automata.setRule(factory.getRule(new int[]{0, 1, 2, 3}));
    }

    public void testStep() throws Exception {

        automata.setState(new boolean[]{false, true,true, false});
        assertTrue(Arrays.equals(
                automata.step(),
                new boolean[]{true, false, false, true}
        ));
    }

    public void testStep2() throws Exception {

        automata.setState(new boolean[]{false, true,true, false});

        assertTrue(Arrays.equals(
                automata.step(2),
                new boolean[]{false, true, true, false}
        ));
    }

    public void testStepBack() throws Exception {

        automata.setState(new boolean[]{true, false, false, true});
        assertTrue(Arrays.equals(
                automata.stepbackFrom(1),
                new boolean[]{false, true,true, false}
        ));
    }

    public void testStepBack2() throws Exception {

        automata.setState(new boolean[]{false, true, true, false});

        assertTrue(Arrays.equals(
                automata.step(2),
                new boolean[]{false, true,true, false}
        ));
    }
}