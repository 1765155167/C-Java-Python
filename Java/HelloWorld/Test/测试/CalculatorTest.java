package 测试;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    Calculator calculator;

    @Before
    public void setUp() throws Exception {
        this.calculator = new Calculator();
    }

    @After
    public void tearDown() throws Exception {
        this.calculator = null;
    }

    @Test
    public void add() {
        assertEquals(100, this.calculator.add(100));
        assertEquals(150,this.calculator.add(50));
        assertEquals(150,this.calculator.add(0));
    }

    @Test
    public void sub() {
        assertEquals(-100,this.calculator.sub(100));
        assertEquals(-150, this.calculator.sub(50));
        assertEquals(-150, this.calculator.sub(0));
    }
}