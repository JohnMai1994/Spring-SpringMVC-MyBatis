package com.jiadong.dao.impl;

import com.jiadong.dao.UserDao;
import com.jiadong.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private SqlSessionFactory factory;

    public UserDaoImpl(SqlSessionFactory factory) {
        this.factory = factory;
    }


    @Override
    public List<User> findAll() {
        //1. 使用工厂创建SqlSession对象
        SqlSession session = factory.openSession();
        //2. 使用session执行查询所有方法
        List<User> users = session.selectList("com.jiadong.dao.UserDao.findAll");
        //3. 返回查询结果
        return users;
    }
}
