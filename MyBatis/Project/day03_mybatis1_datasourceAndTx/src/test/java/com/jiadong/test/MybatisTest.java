package com.jiadong.test;

import com.jiadong.dao.UserDao;
import com.jiadong.domain.QueryVo;
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
import java.util.ArrayList;
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


    // 测试使用queryVO做完查询条件
    @Test
    public void testFindByVo() {
        QueryVo vo = new QueryVo();
        User user = new User();
        user.setUsername("%王%");
        vo.setUser(user);

        List<User> users = userDao.findUserByVo(vo);
        for (User u : users) {
            System.out.println(u);
        }
    }

    @Test
    public void testFindByCondition()  {
//        5. 查询所有
        User user = new User();
//        user.setUsername("老王");
        user.setSex("女");
        List<User> users = userDao.findUserByCondition(user);

        for (User u : users) {
            System.out.println(u);
        }
    }

    @Test
    public void testFindInIds()  {
        QueryVo queryVo = new QueryVo();
        List<Integer> list = new ArrayList<Integer>();
        list.add(41);
        list.add(42);
        list.add(46);
        queryVo.setIds(list);

        List<User> users = userDao.findUserInIds(queryVo);

        for (User u : users) {
            System.out.println(u);
        }
    }


    // 细节记录：
    /*
    * 1. 模糊查询
    * 方法一：select * from user where username like #{uName} --> 使用 %王%  --> 使用prepareStatement参数占位符
    * 方法二：select * from user where username like '%${value}%' 必须写成value --> 直接使用 王 --> 使用Statement的字符串拼接SQL
    *
    * ParameterType 输入参数
    * OGNL表达式：
    *   Object Graphic Navigation Language
    *   对象    图       导航        语言
    *   它是通过对象中的取值方法获取数据。在写法上把get给省略了。
    *   比如：我们获取用户的名称
    *        类中的写法：user.getUsername();
    *        OGNL表达式写法： user.username
    *   mybatis中为什么能直接写username,而不用user呢》
    *        因为在parameterType中已经提供了属性所属的类，所有此时不需要在写对象名
    *
    * resultType 输出参数
    * */


}
