package com.jiadong.service.impl;

import com.jiadong.dao.IAccountDao;
import com.jiadong.dao.impl.AccountDaoImpl;
import com.jiadong.service.IAccountService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao = new AccountDaoImpl();
    public void  saveAccount(){

        accountDao.saveAccount();
    }
}
