package com.zhong.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.zhong.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

//@RestController//使用@
@Controller
public class UserController {

    //响应体注解不会进入视图解析器
    @ResponseBody
    @RequestMapping("/j1")//但是这样返回去的json中文是乱码的
    //我们可以这样使用，用原生是spring的方式解决json乱码问题
//    @RequestMapping(value = "j1", produces = "application/json;charset=utf-8")//但是每次都要配置乱码会比较麻烦，spring配置文件中可以配置来解决乱码问题
    public String json1() throws JsonProcessingException {
        //创建一个对象
        User user = new User("中", 3, "1");

        //jackson里有一个objectmap类型
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(user);
        return s;
    }



    @ResponseBody
    @RequestMapping("/j2")
    public String json2() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        //关闭时间戳方式
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        //自定义日期格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        mapper.setDateFormat(simpleDateFormat);
        Date date = new Date();
        String s = mapper.writeValueAsString(date);
        return s;
    }
}
