package com.zhong.log;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class Log implements MethodBeforeAdvice {

    //args 方法需要调用的参数
    //method 被代理类需要被调用的方法
    //target 被代理类
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println(target.getClass().getName()+"的"+method.getName()+"准备执行了");
    }
}
