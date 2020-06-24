package com.jiadong.dao;

import com.jiadong.domain.QueryVo;
import com.jiadong.domain.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
//    查询用户id
    User findById(Integer userId);
//    根据名称模糊查询
    List<User> findByName(String userName);
//    查询总用户数
    int findTotal();
//    根据queryVo中的查询条件来查询用户
    List<User> findUserByVo(QueryVo vo);

//    根据传入参数条件:
//      有可能有用户名，性别，地址，也有可能什么都没有
    List<User> findUserByCondition(User user);

//    根据queryvo中提供的id集合，查询User集合
    List<User> findUserInIds(QueryVo vo);
}
