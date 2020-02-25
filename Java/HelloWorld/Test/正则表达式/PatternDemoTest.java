package 正则表达式;

import org.junit.Test;

import static org.junit.Assert.*;

public class PatternDemoTest {

    @Test
    public void timeRegex() {
        int[] data = PatternDemo.timeRegex("10:56:37");
        assertEquals(10, data[0]);
        assertEquals(56, data[1]);
        assertEquals(37, data[2]);
        assertNull(PatternDemo.timeRegex("12:60:00"));
        assertNull(PatternDemo.timeRegex("13:50:00"));
        assertNull(PatternDemo.timeRegex("12:50:60"));
        assertNull(PatternDemo.timeRegex("12:60:100"));
    }

}