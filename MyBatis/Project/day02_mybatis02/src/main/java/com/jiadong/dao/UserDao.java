package com.jiadong.dao;

import com.jiadong.domain.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
// 保存用户
    void saveUser(User user);
//    更新用户
    void updateUser(User user);
//    删除用户
    void deleteUser(Integer userId);
//    查询用户id
    User findById(Integer userId);
//    根据名称模糊查询
    List<User> findByName(String userName);
//    查询总用户数
    int findTotal();


}
