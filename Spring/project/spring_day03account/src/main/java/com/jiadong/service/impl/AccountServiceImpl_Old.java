package com.jiadong.service.impl;

import com.jiadong.dao.IAccountDao;
import com.jiadong.domain.Account;
import com.jiadong.service.IAccountService;
import com.jiadong.utils.TransactionManager;

import java.util.List;

public class AccountServiceImpl_Old implements IAccountService {

    private IAccountDao accountDao;
    private TransactionManager txManager;

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    public void setAccountDao(IAccountDao accountDao) {

        this.accountDao = accountDao;
    }

    @Override
    public List<Account> findAllAccount() {
        try {
            // 1. 开启事务
            txManager.beginTransaction();
            // 2. 执行操作
            List<Account> accounts = accountDao.findAllAccount();
            // 3. 提交事务
            txManager.commit();
            // 4. 返回结果
            return accounts;
        }catch (Exception e) {
            // 5. 回滚操作
            txManager.rollback();
            throw new RuntimeException(e);
        } finally {
            // 6. 释放连接
            txManager.release();
        }
    }

    @Override
    public Account findAccountById(Integer accountId) {
        try {
            // 1. 开启事务
            txManager.beginTransaction();
            // 2. 执行操作
            Account account = accountDao.findAccountById(accountId);
            // 3. 提交事务
            txManager.commit();
            // 4. 返回结果
            return account;
        }catch (Exception e) {
            // 5. 回滚操作
            txManager.rollback();
            throw new RuntimeException(e);
        } finally {
            // 6. 释放连接
            txManager.release();
        }
    }

    @Override
    public void saveAccount(Account account) {
        try {
            // 1. 开启事务
            txManager.beginTransaction();
            // 2. 执行操作
            accountDao.saveAccount(account);
            // 3. 提交事务
            txManager.commit();
            // 4. 返回结果
            return;
        }catch (Exception e) {
            // 5. 回滚操作
            txManager.rollback();
            throw new RuntimeException(e);
        } finally {
            // 6. 释放连接
            txManager.release();
        }


    }

    @Override
    public void updateAccount(Account account) {
        try {
            // 1. 开启事务
            txManager.beginTransaction();
            // 2. 执行操作
            accountDao.updateAccount(account);
            // 3. 提交事务
            txManager.commit();
            // 4. 返回结果
            return;
        }catch (Exception e) {
            // 5. 回滚操作
            txManager.rollback();
            throw new RuntimeException(e);
        } finally {
            // 6. 释放连接
            txManager.release();
        }

    }

    @Override
    public void deleteAccount(Integer accountId) {
        try {
            // 1. 开启事务
            txManager.beginTransaction();
            // 2. 执行操作
            accountDao.deleteAccount(accountId);
            // 3. 提交事务
            txManager.commit();
            // 4. 返回结果
            return;
        }catch (Exception e) {
            // 5. 回滚操作
            txManager.rollback();
            throw new RuntimeException(e);
        } finally {
            // 6. 释放连接
            txManager.release();
        }

    }

    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        try {
            // 1. 开启事务
            txManager.beginTransaction();
            // 2. 执行操作
            /*********************************/
            // 2.1. 根据名称查询转出账户
            Account source = accountDao.findAccoundByName("aaa");
            // 2.2. 根据名称查询转入账户
            Account target = accountDao.findAccoundByName("bbb");
            // 2.3. 转出账户减钱
            source.setMoney(source.getMoney() - money);
            // 2.4. 转入账户加钱
            target.setMoney(target.getMoney() + money);
            // 2.5. 更新转出账户
            accountDao.updateAccount(source);

            int i = 1/0;

            // 2.6. 更新转入账户
            accountDao.updateAccount(target);
            /**********************************/
            // 3. 提交事务
            txManager.commit();
            // 4. 返回结果
            return;
        }catch (Exception e) {
            // 5. 回滚操作
            txManager.rollback();
            e.printStackTrace();
        } finally {
            // 6. 释放连接
            txManager.release();
        }





    }
}
