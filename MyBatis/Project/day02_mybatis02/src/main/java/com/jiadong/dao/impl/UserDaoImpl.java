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

    public List<User> findAll() {
        // 1. 根据factory获取sqlsession对象
        SqlSession session = factory.openSession();
        // 2. 调用session中的方法，实现查询列表
        List<User> users = session.selectList("com.jiadong.dao.UserDao.findAll");//参数就是能获取配置信息的key
        // 3. 释放资源
        session.close();
        return users;
    }

    public void saveUser(User user) {
        // 1. 根据factory获取sqlsession对象
        SqlSession session = factory.openSession();
        // 2. 调用session中的方法，实现保存
        session.insert("com.jiadong.dao.UserDao.saveUser", user);
        // 3. 提交事务
        session.commit();
        // 4. 释放资源
        session.close();
        return;
    }

    public void updateUser(User user) {
        // 1. 根据factory获取sqlsession对象
        SqlSession session = factory.openSession();
        // 2. 调用session中的方法，实现更新
        session.update("com.jiadong.dao.UserDao.updateUser", user);
        // 3. 提交事务
        session.commit();
        // 4. 释放资源
        session.close();
        return;
    }

    public void deleteUser(Integer userId) {
        // 1. 根据factory获取sqlsession对象
        SqlSession session = factory.openSession();
        // 2. 调用session中的方法，实现更新
        session.delete("com.jiadong.dao.UserDao.deleteUser", userId);
        // 3. 提交事务
        session.commit();
        // 4. 释放资源
        session.close();
        return;

    }

    public User findById(Integer userId) {
        // 1. 根据factory获取sqlsession对象
        SqlSession session = factory.openSession();
        // 2. 调用session中的方法，实现id查询
        User user = session.selectOne("com.jiadong.dao.UserDao.findById", userId);//参数就是能获取配置信息的key
        // 3. 释放资源
        session.close();
        return user;
    }

    public List<User> findByName(String userName) {
        // 1. 根据factory获取sqlsession对象
        SqlSession session = factory.openSession();
        // 2. 调用session中的方法，实现模糊查询
        List<User> users = session.selectList("com.jiadong.dao.UserDao.findByName", userName);//参数就是能获取配置信息的key
        // 3. 释放资源
        session.close();
        return users;
    }

    public int findTotal() {
        // 1. 根据factory获取sqlsession对象
        SqlSession session = factory.openSession();
        // 2. 调用session中的方法，实现id查询
        Integer count = session.selectOne("com.jiadong.dao.UserDao.findTotal");
        // 3. 释放资源
        session.close();
        return count;
    }
}
