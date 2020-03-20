package com.hqf.dao.impl;


import com.hqf.dao.IAccountDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 账户的持久层实现类
 */
public class AccountDaoImpl implements IAccountDao {
    Logger logger = LoggerFactory.getLogger(AccountDaoImpl.class);
    @Override
    public void saveAccount() {
        logger.info("save Info");
    }
}
