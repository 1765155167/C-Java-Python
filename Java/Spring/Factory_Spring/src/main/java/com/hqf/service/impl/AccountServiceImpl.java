package com.hqf.service.impl;

import com.hqf.dao.IAccountDao;
import com.hqf.log.LogUtil;
import com.hqf.service.IAccountService;

/**
 * 账户业务层实现类
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;

    public AccountServiceImpl(IAccountDao accountDao) {
        this.accountDao = accountDao;
        LogUtil.info("accountDao = {}", accountDao);
    }

    @Override
    public void saveAccount() {
        if (accountDao != null) {
            accountDao.saveAccount();
        } else {
            throw new NullPointerException("accountDao is null");
        }
    }
}
