package hqf.service.impl;

import hqf.dao.IAccountDao;
import hqf.dao.impl.AccountDaoImpl;
import hqf.service.IAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 账户业务层实现类
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;

    public AccountServiceImpl() {
        accountDao = new AccountDaoImpl();
        Logger log = LoggerFactory.getLogger(AccountServiceImpl.class);
        log.info("accountDao = {}",accountDao);
    }

    @Override
    public void saveAccount() {
        accountDao.saveAccount();
    }
}
