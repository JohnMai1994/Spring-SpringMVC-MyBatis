package com.jiadong.test;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.jiadong.domain.Account;
import com.jiadong.factory.BeanFactory;
import com.jiadong.service.IAccountService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/*
* 使用Junit单元测试，测试我们的配置
* */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceTest {

    @Autowired
    @Qualifier("proxyAccountService")
    IAccountService accountService;

//    @Before
//    public void init(){
//        ac = new ClassPathXmlApplicationContext("bean.xml");
//        accountService = ac.getBean("accountService", IAccountService.class);
////        proxyAccountService= ac.getBean("proxyAccountService", BeanFactory.class);
//    }

    @Test
    public void test1() {
//        accountService = proxyAccountService.getAccountService();
        accountService.transfer("aaa", "bbb", 100f);

    }



}
