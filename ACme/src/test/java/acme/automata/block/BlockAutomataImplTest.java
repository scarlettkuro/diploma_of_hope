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
    boolean[] A0 = new boolean[]{false, true,true, false};
    boolean[] A1 = new boolean[]{true, false, true, true};
    boolean[] A2 = new boolean[]{false, true, false, false};

    public void testStep() throws Exception {

        automata.setState(A0);/*
        System.out.println(Arrays.toString(automata.getState()));
        System.out.println(Arrays.toString(automata.step()));
        System.out.println(Arrays.toString(automata.step()));
        System.out.println(Arrays.toString(automata.stepbackFrom(1)));
        System.out.println(Arrays.toString(automata.stepbackFrom(1)));*/
        assertTrue(
              Arrays.equals(
                automata.step(), A1
        )
        );
    }

    public void testStep2() throws Exception {

        automata.setState(A0);

        assertTrue(Arrays.equals(
                automata.step(2), A2
        ));
    }

    public void testStepBack() throws Exception {

        automata.setState(A1);
        assertTrue(Arrays.equals(
                automata.stepbackFrom(1), A0
        ));
    }

    public void testStepBack2() throws Exception {

        automata.setState(A2);

        assertTrue(Arrays.equals(
                automata.stepbackFrom(2, 2), A0
        ));
    }
}