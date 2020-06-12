package com.jiadong.dao;


import com.jiadong.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {
    /**
     * 查询所有用户 * @return
     */
    @Select("select * from user")
    List<User> findAll();
}
