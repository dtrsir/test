package com.zhong.pojo;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/*让这个类变成一个组件*/
@Component
public class User {

    @Value("123")
    public String name;
}
