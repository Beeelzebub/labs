package bin;

import org.junit.Assert;
import org.junit.Test;

public class ExpressionTestCase {

    @Test
    public void TestOne() {
        Assert.assertEquals(1, Calc.Calculate(1, 2.5, 1), 0.0000000001);
    }
	
	@Test
	public void TestTwo() {
        Assert.assertEquals(
            2.5,
            Calc.Calculate(2, 2.5, 1), 
            0.0000000001 
        );
    }
	
	@Test
	public void TestThree() {
        Assert.assertEquals(
            -5,
            Calc.Calculate(3, -1.5, 1), 
            0.0000000001 
        );
    }

   

    
}