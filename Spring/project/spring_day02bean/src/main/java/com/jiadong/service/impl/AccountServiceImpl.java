package com.jiadong.service.impl;


import com.jiadong.service.IAccountService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {

    public AccountServiceImpl() {
        System.out.println("对象创建");
    }

    public void  saveAccount(){

        System.out.println("service中的saveAccount方法执行。。。");
    }

    public void init(){
        System.out.println("初始化对象");
    }

    public void destroy(){
        System.out.println("销毁对象。。");
    }
}
