package com.hqf.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtil {
    final static Logger logger = LoggerFactory.getLogger(LogUtil.class);

    public static void info(String var1, Object var2) {
        logger.info(var1, var2);
    }
    public static void info(String var1) {
        logger.info(var1);
    }
    public static void debug(String var1, Object var2) {
        logger.debug(var1, var2);
    }
    public static void debug(String var1) {
        logger.debug(var1);
    }
}
