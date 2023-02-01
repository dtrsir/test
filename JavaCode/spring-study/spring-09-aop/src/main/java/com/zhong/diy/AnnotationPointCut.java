package com.zhong.diy;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect//标记该类是切面
public class AnnotationPointCut {

    @Before("execution(* com.zhong.service.UserServiceImpl.*(..))")
    public void before() {
        System.out.println("==============================before");
    }

    @After("execution(* com.zhong.service.UserServiceImpl.*(..))")
    public void after() {
        System.out.println("=================================after");
    }

    //环绕中，使用参数获得连接点
    @Around("execution(* com.zhong.service.UserServiceImpl.*(..))")
    public void around(ProceedingJoinPoint jp) throws Throwable {

        System.out.println("环绕前");

        Signature signature = jp.getSignature();
        System.out.println(signature);
        Object proceed = jp.proceed();//真正执行方法

        System.out.println("环绕后");
        System.out.println(proceed);
    }
}
