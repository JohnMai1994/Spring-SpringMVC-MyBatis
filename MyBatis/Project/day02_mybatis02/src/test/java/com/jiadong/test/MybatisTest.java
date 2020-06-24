package com.jiadong.test;

import com.jiadong.dao.UserDao;
import com.jiadong.dao.impl.UserDaoImpl;
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
    private UserDao userDao;


    @Before
    public void init() throws IOException {
//        1. 读取配置文件，生成字节输入流
        resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
//        2. 获取SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
//        3. 使用工厂对象，创建Dao对象
        userDao = new UserDaoImpl(factory);
    }

    @After
    public void destory() throws Exception {
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
    public void testSave() throws IOException {
        User user = new User();
        user.setUsername("dao impl user");
        user.setAddress("荔湾区皇上皇");
        user.setSex("男");
        user.setBirthday(new Date());
        System.out.println("保存前" + user);

//        5. 执行保存方法
        userDao.saveUser(user);
        System.out.println("保存后" + user);
    }
    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(52);
        user.setUsername("mybatis updateUser");
        user.setAddress("荔湾区皇上皇");
        user.setSex("女");
        user.setBirthday(new Date());

        userDao.updateUser(user);
    }
    @Test
    public void testDelete() {
        userDao.deleteUser(50);
    }

    @Test
    public void testFindById() {
        // 5. 执行查询一个方法
        User user = userDao.findById(46);
        System.out.println(user);
    }

    @Test
    public void testFindByName() {
        // 5. 执行根据名字查询
//        List<User> users = userDao.findByName("%王%");
        List<User> users = userDao.findByName("王");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindTotal() {
        // 5. 执行查询总记录条数
        int count = userDao.findTotal();
        System.out.println(count);
    }


}
