package com.jiadong.dao;

import com.jiadong.domain.Role;
import com.jiadong.domain.User;

import java.util.List;

public interface UserDao {
    /*查询所有用户，对应的角色*/
    List<User> findAll();
//    查询用户id
    User findById(Integer userId);
}
