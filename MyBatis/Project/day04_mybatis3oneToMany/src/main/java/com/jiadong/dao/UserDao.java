package com.jiadong.dao;

import com.jiadong.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface UserDao {


    /*在mybatis中针对，CRUD一共四个注解*/
    @Select("select * from user")
    @Results(id = "userMap", value = {
            @Result(id = true, column = "id", property = "userId"),
            @Result(column = "username", property = "userName"),
            @Result(column = "sex", property = "userSex"),
            @Result(column = "address", property = "userAddress"),
            @Result(column = "birthday", property = "userBirthday"),
            @Result(property = "accounts", column = "id",
                    many = @Many(select = "com.jiadong.dao.AccountDao.findAccountByUid",
                            fetchType = FetchType.LAZY))
    })
    List<User> findAll();

    /*根据id查询用户*/
    @Select("select * from user where id = #{id}")
    @ResultMap(value = {"userMap"})
    User findById(int id);

    /*根据用户名称模糊查询*/
//    方法一
//    @Select("select * from user where username like #{username}")
//    方法二
    @Select("select * from user where username like '%${value}%'")
    @ResultMap(value = {"userMap"})
    List<User> findByName(String name);

}
