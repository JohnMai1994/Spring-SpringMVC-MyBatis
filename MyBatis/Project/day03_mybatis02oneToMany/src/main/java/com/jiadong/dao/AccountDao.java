package com.jiadong.dao;

import com.jiadong.domain.Account;

import java.util.List;
import java.util.Map;

public interface AccountDao {

    List<Account> findAll();

    /*
    * 查询所有账户，并且带有用户名称和地址信息
    * */
    List<Account> findAllAccount();
}
