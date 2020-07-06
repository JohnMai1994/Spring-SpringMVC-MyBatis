package com.jiadong.test;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.jiadong.domain.Account;
import com.jiadong.service.IAccountService;
import config.JdbcConfig;
import config.SpringConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import javax.swing.*;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;


/*
* 使用Junit单元测试，测试我们的配置
*
     spring整合junit的配置
         1. 导入spring中的junit的jar（坐标）
         2. 使用Junit提供的一个注解把原有的main方法替换了，替换成spring提供的
             @Runwith
         3. 告知spring的运行器，spring和ioc创建是基于xml还是注解的，并且说明位置
             @ContextConfiguation
                 locations: 知道xml文件的位置，加上classpath关键字，表示在类路径下
                 classes：指定注解类所在的位置
*
* */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {
    @Autowired
    private IAccountService accountService = null;


//    @Before
//    void init() {
////    ac = new ClassPathXmlApplicationContext("bean.xml");
//        ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
//        accountService = ac.getBean("accountService", IAccountService.class);
//    }

    @Test
    public void testFindAll()  {
        List<Account> accounts = accountService.findAllAccount();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void testFindAccountById() {
        Account account = accountService.findAccountById(1);
        System.out.println(account);
    }

    @Test
    public void testSaveAccount() {
        Account account = new Account();
        account.setName("ddd");
        account.setMoney(2000f);
        accountService.saveAccount(account);
    }

    @Test
    public void testUpdateAccount() {
        Account account = new Account();
        account.setId(4);
        account.setName("ddd");
        account.setMoney(3000f);

        accountService.updateAccount(account);

    }

    @Test
    public void testDeleteAccount() {
        accountService.deleteAccount(4);

    }
}
