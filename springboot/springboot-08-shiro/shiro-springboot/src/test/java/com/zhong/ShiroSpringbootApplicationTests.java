package com.zhong;

import com.zhong.service.UserService;
import com.zhong.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class ShiroSpringbootApplicationTests {

    @Resource
    UserServiceImpl userService;

    @Test
    void contextLoads() {

        System.out.println(userService.queryUserByName("zz"));


    }

}
