/**
 * Created by kuro on 31.05.15.
 */
import com.fasteasytrade.JRandTest.IO.FileRandomStream;
import com.fasteasytrade.JRandTest.Tests.Base;
import com.fasteasytrade.JRandTest.Tests.Count4Bits;
import com.fasteasytrade.JRandTest.Tests.MonteCarlo;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.Test;

public class RANDTests extends TestCase {

    /* To remind myself
    * boolean[] a = new boolean[]{true,true};
    * for(int i=0;i<a.length; i++)        assertTrue(a[i]);
    */

    public boolean pushTest(Base test) {
        String[] file = {"/home/kuro/hui","/home/kuro/Drive2011.jpg"};

        test.help();
        for (int i = 0; i < file.length; i++) {
            try {
                test.registerInput(new FileRandomStream(file[i]));
                test.test(file[i]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public void testMonteCarlo() {
        MonteCarlo _test = new MonteCarlo();
        assertTrue(pushTest(_test));
        Count4Bits test2 = new Count4Bits();
    }

    public void testCount4Bits() {
        Count4Bits _test = new Count4Bits();
        assertTrue(pushTest(_test));

    }
}
