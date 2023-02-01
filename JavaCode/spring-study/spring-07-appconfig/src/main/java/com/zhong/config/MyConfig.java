package com.zhong.config;

import com.zhong.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration //被spring托管，注册到容器中，它本身也是一个@Component。并且这个注解的意思是标志这个类是原来的配置.xml文件
//既然是原来的xml文件，那么原来的一些功能也可以通过注解来使用
@ComponentScan("com.zhong.pojo")
public class MyConfig {


    //注册一个bean，方法的名字就是bean标签里的id
    //返回值就是bean标签里的class
    //1.@Bean和2.在实体类上加上@Component配置类加上扫描，选择其一
    @Bean
    public User getUser() {
        return new User();//返回要注入到bean的对象
    }
}
