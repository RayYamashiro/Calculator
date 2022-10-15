package Tests;

import Programm.Calc;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


@ExtendWith(MockitoExtension.class)
public class CalcTest {
    @Mock
    Calc calcMock;
    /*
    @org.junit.jupiter.api.Test
    void valueOf() {

    }
*/

    @Test
//    @org.junit.jupiter.api.Test
    public void sum() {
        Calc calc = Calc.getInstance();
        double a = 6;
        double b = 5;

        double actualSum = calc.sum(a,b);
        double expectedSum = a + b;
        Assert.assertEquals(expectedSum, actualSum, 0.1);
    }

   // @org.junit.jupiter.api.Test
   @Test
    public void subtract() {
        Calc calc = Calc.getInstance();
        double a = 6;
        double b = 5;

        double actualSub = calc.subtract(a,b);
        double expectedSub = a - b;
        Assert.assertEquals(expectedSub, actualSub, 0.1);
    }

    //@org.junit.jupiter.api.Test
    @Test
   public void multiply() {
        Calc calc = Calc.getInstance();
        double a = 6;
        double b = 5;

        double  actualMul = calc.multiply(a,b);
        double expectedMul = a * b;
        Assert.assertEquals(expectedMul, actualMul, 0.1);
    }

   //= @org.junit.jupiter.api.Test
   //@Test(expected = ArithmeticException.class)
   public void divide() {
        Calc calc = Calc.getInstance();
        double a = 6;
        double b = 0;
        double actualDiv = calc.divide(a, b);
       double  exp = a / b;
    }
/*
    @Test
    public void TestClass()
    {
        assertNotNull(calcMock);
        when(calcMock.isAvailable()).thenReturn(true);
        Programm.Calc.getInstance(calcMock);
        boolean check = Programm.Calc.query("* from t");
        assertTrue(check);

    }

 */

    //@org.junit.jupiter.api.Test
    @Test
   public void getInstance() {
        Calc calc ;
        Calc calc1 = Calc.getInstance();
        Assert.assertEquals(calc = Calc.getInstance(), calc1);
    }


}