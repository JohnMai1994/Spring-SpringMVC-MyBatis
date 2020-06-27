package com.jiadong.test;

import com.jiadong.dao.AccountDao;
import com.jiadong.dao.UserDao;
import com.jiadong.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class AccountTest {
    private InputStream resourceAsStream;
    private SqlSession session;
    private AccountDao accountDao;


    @Before
    public void init() throws IOException {
//        1. 读取配置文件，生成字节输入流
        resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
//        2. 获取SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
//        3. 获取SqlSession对象
        session = factory.openSession();
//        4. 获取dao的代理对象
        accountDao = session.getMapper(AccountDao.class);
    }

    @After
    public void destory() throws Exception {
//        5.5 提交事务
        session.commit();

//        6. 释放资源
        session.close();
        resourceAsStream.close();
    }

    @Test
    public void testFindAll() {
        List<Account> accounts = accountDao.findAll();

        for (Account account : accounts) {
            System.out.println(account);
//            System.out.println(account.getUser());
        }
    }


}
