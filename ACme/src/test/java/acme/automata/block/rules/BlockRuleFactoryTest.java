package acme.automata.block.rules;

import junit.framework.TestCase;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by kuro on 07.06.15.
 */
public class BlockRuleFactoryTest extends TestCase {

    BlockRuleFactory factory = new BlockRuleFactory();

    public void testGetRule_size() throws Exception {
        iBlockLocalRule rule = factory.getRule(new int[]{0,1, 2, 3});

        assertEquals(

                rule.blockSize(),2
        );

    }



    public void testGetRule_stepForward() throws Exception {
        iBlockLocalRule rule = factory.getRule(new int[]{0,1, 2, 3});

        assertTrue(Arrays.equals(

                rule.step(0, new boolean[]{false, true}),
                new boolean[]{true, false}
        ));

    }



    public void testGetRule_stepForward2Step() throws Exception {
        iBlockLocalRule rule = factory.getRule(new int[]{0,1, 2, 3});

        assertTrue(Arrays.equals(

                rule.step(1, new boolean[]{false, true}),
                new boolean[]{true, true}
        ));

    }

    public void testGetRule_stepBack() throws Exception {
        iBlockLocalRule rule = factory.getRule(new int[]{0, 1, 2, 3});
        assertTrue(Arrays.equals(
                rule.stepback(0, new boolean[]{true, false}),
                new boolean[]{false, true}
        ));

    }

    public void testGetRule_stepBack2Step() throws Exception {
        iBlockLocalRule rule = factory.getRule(new int[]{0, 1, 2, 3});
        assertTrue(Arrays.equals(
                rule.stepback(1, new boolean[]{true, false}),
                new boolean[]{true, true}
        ));

    }
}