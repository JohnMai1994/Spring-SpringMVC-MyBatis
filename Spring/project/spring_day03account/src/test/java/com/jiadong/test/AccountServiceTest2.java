package com.jiadong.test;


import com.jiadong.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/*
* 使用Junit单元测试，测试我们的配置
* */


public class AccountServiceTest2 {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean2.xml");
        IAccountService accountService = ac.getBean("accountService", IAccountService.class);
        accountService.transfer("aaa", "bbb", 50f);
    }
}
