package com.jiadong.service;

/*
* 账户的业务层接口
* */

import com.jiadong.domain.Account;

import java.util.List;

public interface IAccountService {

    // 查询所有
    List<Account> findAllAccount();

    // 单个查询
    Account findAccountById(Integer accountId);

    // 保存
    void saveAccount(Account account);

    // 更新
    void updateAccount(Account account);

    // 删除
    void deleteAccount(Integer accountId);
}
