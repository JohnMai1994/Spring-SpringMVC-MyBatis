package com.jiadong.factory;

import com.jiadong.service.IAccountService;
import com.jiadong.service.impl.AccountServiceImpl;


/*
* 模拟一个工厂（该类可能存在于jar包中，我们无法通过修改源码的方式来提供默认构造函数）
* */
public class InstanceFactory {

    public IAccountService getAccountService(){
        return new AccountServiceImpl();
    }

}
