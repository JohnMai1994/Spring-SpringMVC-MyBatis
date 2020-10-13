package com.jiadong.utils;


import org.aspectj.lang.ProceedingJoinPoint;

/*
* 用于记录日志的工具类，它里面提供了公共的代码
* */
public class Logger {
    /*
    * 前置通知
    * */
    public void beforePrintLog() {
        System.out.println("前置通知: Logger类中的beforePrintLog方法开始记录日志。。");
    }

    /*
     * 后置通知
     * */
    public void afterRuturningPrintLog() {
        System.out.println("后置通知: Logger类中的afterRuturningPrintLog方法开始记录日志。。");
    }

    /*
     * 异常通知
     * */
    public void afterThrowingPrintLog() {
        System.out.println("异常通知: Logger类中的afterThrowingPrintLog方法开始记录日志。。");
    }

    /*
     * 最终通知
     * */
    public void afterPrintLog() {
        System.out.println("最终通知: Logger类中的afterPrintLog方法开始记录日志。。");
    }

    /*
    * 环绕通知
    * 问题：
    *   当我们配置了环绕通知之后，切入点方法没有执行，而通知方法执行了。
    * 分析：
    *   通过对比动态代理中的环绕通知代码，发现动态代理中的环绕通知有明确的业务层的切入点方法调用，而我们的代码中没有。
    * 解决：
    *   Spring框架为我们提供了一个接口: ProceedingJoinPoint。该接口有一个方法proceed()，此方法相当于明确调用切入点方法
    *   该接口可以作为环绕通知的方法参数，在程序执行时，spring框架会为我们提供该接口的实现类供我们使用
    *
    * spring中的环绕通知
    *   是spring框架中为我们提供一种可以在代码中手动实行的一个方式
    *
    * */
    public Object aroundPrintLog(ProceedingJoinPoint pjp) {
        Object returnValue = null;

        try {
            Object[] args = pjp.getArgs(); // 得到方法执行所需的参数
            System.out.println("前置通知Logger类中的aroundPrintLog方法开始记录日志。。");
            returnValue = pjp.proceed(args); // 明确调用业务层方法（切入点方法）
            System.out.println("后置通知Logger类中的aroundPrintLog方法开始记录日志。。");
            return returnValue;
        } catch (Throwable throwable) {
            System.out.println("异常通知Logger类中的aroundPrintLog方法开始记录日志。。");
            throw new RuntimeException(throwable);
        }finally {
            System.out.println("最终通知Logger类中的aroundPrintLog方法开始记录日志。。");
        }


    }
}