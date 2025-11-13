package calc;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    @Test
    public void calculate() {
        Assert.assertEquals(6, 0.1, Calculator.calculate(1,5,"+"));
        assertEquals(6, 0.1,Calculator.calculate(7,1,"-"));
        assertEquals(2, 0.1,Calculator.calculate(1,2,"*"));
        assertEquals(2, 0.1,Calculator.calculate(4,2,"/"));
    }

    @Test
    public void add() {
        assertEquals(6,0.1,Calculator.add(1,5));

    }

    @Test
    public void subtract() {
        assertEquals(6,0.1,Calculator.subtract(7,1));
    }

    @Test
    public void multiply() {
        assertEquals(6,0.1,Calculator.multiply(2,3));
    }

    @Test
    public void divide() {
        assertEquals(2,0.1,Calculator.divide(4,2));
    }
}