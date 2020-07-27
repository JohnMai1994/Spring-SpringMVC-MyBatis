package com.jiadong.dao.impl;

import com.jiadong.dao.IAccountDao;
import com.jiadong.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class AccountDao2 implements IAccountDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Account findAccountById(Integer accountId) {
        List<Account> accounts = jdbcTemplate.query("select * from account1 where id = ?", new BeanPropertyRowMapper<Account>(Account.class), accountId);
        return accounts.isEmpty()? null: accounts.get(0);
    }

    @Override
    public Account findAccountByName(String accountName) {
        List<Account> accounts = jdbcTemplate.query("select * from account1 where name = ?", new BeanPropertyRowMapper<Account>(Account.class), accountName);
        if (accounts.isEmpty()) {
            return null;
        }
        if (accounts.size() > 1) {
            throw new RuntimeException("结果集不唯一");
        }
        return accounts.get(0);
    }

    @Override
    public void updateAccount(Account account) {
        jdbcTemplate.update("update account1 set name = ?, money = ? where id = ?", account.getName(), account.getMoney(), account.getId());
    }
}
