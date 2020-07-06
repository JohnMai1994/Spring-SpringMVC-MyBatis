package com.jiadong.ui;


import com.jiadong.service.IAccountService;
import com.jiadong.service.impl.AccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 模拟一个表现层，用于调用业务层
 */
public class Client {


    public static void main(String[] args) {
//        1. 获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        2. 根据id获取bean对象
        IAccountService as = ac.getBean("accountService", AccountServiceImpl.class);
        as.saveAccount();


    }
}
