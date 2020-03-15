import JavaBase.String.Main;

import static org.junit.Assert.*;

public class MainTest {

    @org.junit.Test
    public void maxDemo() {
        assertEquals(2, Main.maxDemo(1,2));
        assertEquals(0, Main.maxDemo(0,-1));
    }
}