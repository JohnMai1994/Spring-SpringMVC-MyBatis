package com.jiadong.dao;

import com.jiadong.domain.Account;

import java.util.List;
import java.util.Map;

public interface AccountDao {

    List<Account> findAll();

    /*根据用户id查询用户信息*/
    List<Account> findAccountByUid();
}
