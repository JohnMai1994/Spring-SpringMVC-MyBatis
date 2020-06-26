package com.jiadong.dao;

import com.jiadong.domain.Role;

import java.util.List;

public interface RoleDao  {

    /*查询所角色，对应的用户*/
    List<Role> findAll();


}
