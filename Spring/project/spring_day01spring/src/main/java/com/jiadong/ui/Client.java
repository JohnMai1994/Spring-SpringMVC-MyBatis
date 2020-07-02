package com.jiadong.ui;


import com.jiadong.dao.IAccountDao;
import com.jiadong.service.IAccountService;
import com.jiadong.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * 模拟一个表现层，用于调用业务层
 */
public class Client {

    /*
    * 获取spring的Ioc核心容器，并根据id获取对象
    *
    * ApplicationContext的三个常用实现类：
    *       ClassPathXmlApplicationContext： 它可以加载类路径下的配置文件，要去配置文件必须在类路径下。不在的话，加载不了(更常用)
    *       FileSystemXmlApplicationContext： 它可以加载磁盘任意路径下的配置文件（必须有访问权限）
    *
    *       AnnotationConfigApplicationContext： 它是用于读取注解创建容器的
    *
    * 核心容器的两个接口引发出的问题：
    *       ApplicationContext： 试用场景，单例对象使用 （更多使用此接口）
    *           它在构建核心容器时，创建对象采用的策略是采用立即加载的方式。也就是说，只要一读取完配置文件马上就创建配置文件中配置的对象
    *       BeanFactory:        适用场景，多例对象使用
    *           它在构建核心容器时，创建对象采取的策略是采用延迟加载的方式，也就是说，什么时候根据id获取对象，什么时候才真正创建对象
    * */
    public static void main(String[] args) {
//        1. 获取核心容器对象
//          FileSystemXmlApplicationContext
//        ApplicationContext ac = new FileSystemXmlApplicationContext("C:\\Users\\Jiadong\\Desktop\\bean.xml");
//          使用ClassPathXmlApplicationContext
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        2. 根据id获取bean对象
        IAccountService as = ac.getBean("accountService", AccountServiceImpl.class);
        IAccountDao adao = (IAccountDao) ac.getBean("accountDao");
        System.out.println(as);
        System.out.println(adao);


//        ---------------BeanFactory--------------------
//        Resource resource = new ClassPathResource("bean.xml");
//        BeanFactory bf = new XmlBeanFactory(resource);
//
//        IAccountService as = bf.getBean("accountService", AccountServiceImpl.class);
//        System.out.println(as);

    }
}
