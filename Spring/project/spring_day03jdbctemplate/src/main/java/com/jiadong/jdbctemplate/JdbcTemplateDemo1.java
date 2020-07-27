package com.jiadong.jdbctemplate;

/*
* JdbcTemplate的最基本用法
*
* */

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.DriverManager;

public class JdbcTemplateDemo1 {

    public static void main(String[] args) {
        // 准备数据源：spring的内置数据源
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://127.0.0.1:3306/myusers?useUnicode=true&characterEncoding=utf8");
        ds.setUsername("root");
        ds.setPassword("password");

        // 1. 创建JdbcTemplate对象
        JdbcTemplate jt = new JdbcTemplate();
        // 给jt设置数据源
        jt.setDataSource(ds);
        // 2. 执行操作
        jt.execute("insert  into account1 (name, money) values ('fff', 1000)");

    }

}
