package com.hqf.ui;

import com.hqf.factory.BeanFactory;
import com.hqf.service.IAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 模拟一个表现层，调用业务层
 */
public class Client {
    final static Logger logger = LoggerFactory.getLogger(Client.class);
    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            IAccountService as = (IAccountService)
                    BeanFactory.getBean("accountService");
            logger.debug(as.toString());
            as.saveAccount();
        }
    }
}
