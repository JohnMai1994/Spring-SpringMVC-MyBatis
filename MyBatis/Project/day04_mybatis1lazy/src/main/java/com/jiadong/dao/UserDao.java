package com.jiadong.dao;

import com.jiadong.domain.User;

import java.util.List;

public interface UserDao {
//   查询所有用户，同时获取到用户下所有账户的信息
    List<User> findAll();
//    查询用户id
    User findById(Integer userId);
}
