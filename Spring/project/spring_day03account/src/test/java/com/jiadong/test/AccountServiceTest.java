package com.jiadong.test;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.jiadong.domain.Account;
import com.jiadong.service.IAccountService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/*
* 使用Junit单元测试，测试我们的配置
* */

public class AccountServiceTest {

    ApplicationContext ac;
    IAccountService accountService;

    @Before
    public void init(){
        ac = new ClassPathXmlApplicationContext("bean.xml");
        accountService = ac.getBean("accountService", IAccountService.class);
    }

    @Test
    public void test1() {
        accountService.transfer("aaa", "bbb", 100f);

    }



}
