package com.jiadong.test;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.jiadong.domain.Account;
import com.jiadong.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;


/*
* 使用Junit单元测试，测试我们的配置
* */
public class AccountServiceTest {

    ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
    IAccountService accountService = ac.getBean("accountService", IAccountService.class);


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
