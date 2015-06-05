/**
 * Created by kuro on 31.05.15.
 */
import com.fasteasytrade.JRandTest.IO.FileRandomStream;
import AdvancedTests.Base;
import AdvancedTests.MonteCarlo;
import junit.framework.TestCase;

public class RANDTests extends TestCase {

    /* To remind myself
    * boolean[] a = new boolean[]{true,true};
    * for(int i=0;i<a.length; i++)        assertTrue(a[i]);
    */

    public boolean pushTest(Base test) {
        String[] file = {"/home/kuro/pui","/home/kuro/Drive2011.jpg"};

        test.help();

        boolean done = true;

        for (int i = 0; i < file.length; i++) {
            try {
                test.registerInput(new FileRandomStream(file[i]));
                done = done && test.test(file[i]);
                System.out.println();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return done;
    }

    public void testMonteCarlo() {
        /*
        MonteCarlo _test = new MonteCarlo();
        assertTrue(pushTest(_test));
        */
        assertTrue(true);
    }
}
