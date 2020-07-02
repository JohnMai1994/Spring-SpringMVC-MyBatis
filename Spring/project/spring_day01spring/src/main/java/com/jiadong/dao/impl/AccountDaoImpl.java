package com.jiadong.dao.impl;

import com.jiadong.dao.IAccountDao;

/**
 * 账户的持久层实现类
 */
public class AccountDaoImpl implements IAccountDao {

    public AccountDaoImpl() {
        System.out.println("Hello AccountDao");
    }

    public  void saveAccount(){

        System.out.println("保存了账户");
    }
}
