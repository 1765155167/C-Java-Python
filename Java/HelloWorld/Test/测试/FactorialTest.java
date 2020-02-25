package 测试;

import org.junit.Test;

import static org.junit.Assert.*;

public class FactorialTest {
    @Test
    public void testFact() {
        assertEquals(1, Factorial.fact(0));
        assertEquals(1, Factorial.fact(1));
        assertEquals(2, Factorial.fact(2));
        assertEquals(6, Factorial.fact(3));
        assertEquals(3628800, Factorial.fact(10));
        assertEquals(2432902008176640000L, Factorial.fact(20));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testNegative() {
        Factorial.fact(-1);
        Factorial.fact(-2);
        Factorial.fact(-3);
        Factorial.fact(-5000);
    }
    @Test(expected = ArithmeticException.class)
    public void testLargeInput() {
        Factorial.fact(21);
        Factorial.fact(22);
        Factorial.fact(232);
        Factorial.fact(5000);
    }
}