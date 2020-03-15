package 测试;

import JavaBase.测试.Config;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConfigTest {
    Config config;
    @Before
    public void setUp() throws Exception {
        this.config = new Config();
    }

    @After
    public void tearDown() throws Exception {
        this.config = null;
    }
    @Test
    public void testWindows() {
        assertEquals("C:\\test.ini", config.getConfigFile("test.ini"));
    }

//    @Test
//    public void testLinuxAndMac() {
//        assertEquals("/usr/local/test.cfg", config.getConfigFile("test.cfg"));
//    }
}