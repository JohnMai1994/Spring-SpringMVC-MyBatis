package com.jiadong.test;

import com.jiadong.dao.UserDao;
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
import java.util.Date;
import java.util.List;

public class MybatisTest {
    private InputStream resourceAsStream;
    private SqlSession session;
    private UserDao userDao;


    @Before
    public void init() throws IOException {
//        1. 读取配置文件，生成字节输入流
        resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
//        2. 获取SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
//        3. 获取SqlSession对象
        session = factory.openSession();
//        4. 获取dao的代理对象
        userDao = session.getMapper(UserDao.class);
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
    public void testFindAll()  {
//        5. 查询所有
        List<User> users = userDao.findAll();

        for (User user : users) {
            System.out.println(user);
        }
    }


    @Test
    public void testFindById() {
        // 5. 执行查询一个方法
        User user = userDao.findById(46);
        System.out.println(user);
    }



}
