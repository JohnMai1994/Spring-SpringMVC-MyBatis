package com.jiadong.dao;

import com.jiadong.domain.Account;

import java.util.List;

public interface IAccountDao {
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

    // 根据用户名字查询-> 如果有唯一的结果就返回，没有就返回null
    Account findAccoundByName(String accountName);
}
