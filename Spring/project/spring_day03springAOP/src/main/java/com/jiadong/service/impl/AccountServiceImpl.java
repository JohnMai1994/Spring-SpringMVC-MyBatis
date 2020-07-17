package com.jiadong.service.impl;

import com.jiadong.service.IAccountService;


/*
* 账户的业务层实现类
* */
public class AccountServiceImpl implements IAccountService {
    @Override
    public void saveAccount() {
        System.out.println("执行保存");
    }

    @Override
    public void updateAccount(int i) {
        System.out.println("执行力更新");
    }

    @Override
    public int deleteAccount() {
        System.out.println("执行力删除");
        return 0;
    }
}
