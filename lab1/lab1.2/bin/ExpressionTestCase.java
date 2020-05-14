package bin;

import org.junit.Assert;
import org.junit.Test;

public class ExpressionTestCase {

    @Test
    public void TestOne() {
        Assert.assertEquals(2, Sum.Factorial(2), 0.0000000001);
    }
	
	@Test
    public void TestTwo() {
        Assert.assertEquals(120, Sum.Factorial(5), 0.0000000001);
    }
	
	@Test
    public void TestThree() {
        Assert.assertEquals(1, Sum.Calc(1, 0), 0.01);
    }
	
	@Test
    public void TestFour() {
        Assert.assertEquals(Math.sinh(2), Sum.Summation(2,0.01), 0.01);
    }
	
	@Test
    public void TestFive() {
        Assert.assertEquals(Math.sinh(1), Sum.Summation(1,0.01), 0.01);
    }    
}