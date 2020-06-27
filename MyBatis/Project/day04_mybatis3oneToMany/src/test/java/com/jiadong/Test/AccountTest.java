package com.jiadong.Test;

import com.jiadong.dao.AccountDao;
import com.jiadong.dao.UserDao;
import com.jiadong.domain.Account;
import com.jiadong.domain.User;
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

public class AccountTest {
    private InputStream in;
    private SqlSessionFactoryBuilder sqlSessionFactoryBuilder;
    private SqlSessionFactory factory;
    private SqlSession session;
    private AccountDao accountDao;

    @Before
    public void init() throws IOException {
        //1. 获取字节输入流
        in  = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2. 根据字节输入流构建SqlSessionFactory
        factory = new SqlSessionFactoryBuilder().build(in);
        //3. 根据SqlSessionFactory生成一个SqlSession
        session = factory.openSession();
        //4. 使用SqlSession获取Dao的代理对象
        accountDao = session.getMapper(AccountDao.class);
    }

    @After
    public void close() throws IOException {
        session.commit();
        session.close();
        in.close();
    }

    @Test
    public void testFindAll() {
        List<Account> accounts = accountDao.findAll();
        for (Account account : accounts) {
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }



}
