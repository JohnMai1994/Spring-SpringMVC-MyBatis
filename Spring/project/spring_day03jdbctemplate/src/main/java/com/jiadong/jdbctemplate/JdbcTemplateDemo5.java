package com.jiadong.jdbctemplate;

/*
* JdbcTemplate的最基本用法
*
* */

import com.jiadong.dao.IAccountDao;
import com.jiadong.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcTemplateDemo5 {

    public static void main(String[] args) {
        // 1. 获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean2.xml");
        // 2. 获取对象
        IAccountDao accountDao = ac.getBean("accountDao", IAccountDao.class);
        // 3. 执行操作
        Account aaa = accountDao.findAccountByName("aaa");
        System.out.println(aaa);


    }

}
