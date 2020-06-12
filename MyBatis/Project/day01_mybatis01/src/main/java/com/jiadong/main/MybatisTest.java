package com.jiadong.main;

import com.jiadong.dao.UserDao;
import com.jiadong.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {

    public static void main(String[] args) throws IOException {
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory的构建者对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //3.使用构建者创建工厂对象
        SqlSessionFactory factory = builder.build(in);
        //4.使用SqlSessionFactory生产SqlSession对象
        SqlSession session = factory.openSession();
        //5.使用SqlSession创建dao接口的代理对象
        UserDao userDao = session.getMapper(UserDao.class);

        //6.使用方法

        //6.1 查
        // findById
        User user1 = userDao.findById(41);
        System.out.println(user1);
        // findAll
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        //6.2 改

        //7.释放资源
        session.close(); in.close();

    }

}
