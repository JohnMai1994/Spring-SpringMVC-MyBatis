package com.jiadong.dao;

import com.jiadong.domain.User;

import java.util.List;

public interface UserDao {
    /**
     * 查询所有用户 * @return
     */
    List<User> findAll();
    User findById(Integer id);
}
