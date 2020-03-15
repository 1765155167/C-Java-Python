package com.hqf.service.impl;

import com.hqf.dao.IAccountDao;
import com.hqf.factory.BeanFactory;
import com.hqf.service.IAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 账户业务层实现类
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;

    public AccountServiceImpl() {
        accountDao = (IAccountDao)
                BeanFactory.getBean("accountDao");
        Logger log = LoggerFactory.getLogger(AccountServiceImpl.class);
        log.info("accountDao = " + accountDao);
    }

    @Override
    public void saveAccount() {
        accountDao.saveAccount();
    }
}
