package com.jiadong.utils;

import java.sql.SQLException;

/*
* 和事务管理相关的工具类，它包含了，开启事务，提交事务，回滚事务，和释放连接
* */
public class TransactionManager {
    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    /*
    * 开启事务
    * */
    public void beginTransaction() {
        try {
            System.out.println("Begin Transaction: set autoCommit false");
            connectionUtils.getThreadConnection().setAutoCommit(false);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /*
     * 提交事务
     * */
    public void commit() {
        try {
            System.out.println("Commit!!!");
            connectionUtils.getThreadConnection().commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /*
     * 回滚事务
     * */
    public void rollback() {
        try {
            System.out.println("rollback");
            connectionUtils.getThreadConnection().rollback();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /*
     * 释放连接
     * */
    public void release() {
        try {
            // 还回到连接池中
            System.out.println("release connections");
            connectionUtils.getThreadConnection().close();
            connectionUtils.removeConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
