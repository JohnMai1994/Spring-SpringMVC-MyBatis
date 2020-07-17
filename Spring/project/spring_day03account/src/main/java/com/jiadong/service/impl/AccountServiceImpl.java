package com.jiadong.service.impl;

import com.jiadong.dao.IAccountDao;
import com.jiadong.domain.Account;
import com.jiadong.service.IAccountService;
import com.jiadong.utils.TransactionManager;

import java.util.List;

public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {

        this.accountDao = accountDao;
    }

    @Override
    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    @Override
    public Account findAccountById(Integer accountId) {

        return accountDao.findAccountById(accountId);
    }

    @Override
    public void saveAccount(Account account) {
        accountDao.saveAccount(account);

    }

    @Override
    public void updateAccount(Account account) {

        accountDao.updateAccount(account);
    }

    @Override
    public void deleteAccount(Integer accountId) {
        accountDao.deleteAccount(accountId);
    }

    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        // 1. 根据名称查询转出账户
        Account source = accountDao.findAccoundByName("aaa");
        // 2. 根据名称查询转入账户
        Account target = accountDao.findAccoundByName("bbb");
        // 3. 转出账户减钱
        source.setMoney(source.getMoney() - money);
        // 4. 转入账户加钱
        target.setMoney(target.getMoney() + money);
        // 5. 更新转出账户
        accountDao.updateAccount(source);
        // 6. 更新转入账户
        accountDao.updateAccount(target);

    }
}
