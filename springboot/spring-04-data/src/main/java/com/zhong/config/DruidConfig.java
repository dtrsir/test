package com.zhong.config;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

//标注这个类是一个配置类
@Configuration
//这个数据源的配置类就相当于之前的web.xml，web.xml能够配置的东西这里都能配置
public class DruidConfig {

    //将yml文件中配置的属性绑定进来
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean //将这个new出来的对象托管给spring
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

    //后台监控
    //ServletRegistrationBean意识是帮助我们把一些druid的插件注册成bean
    @Bean //需要注册为bean
    public ServletRegistrationBean statViewServlet() {
        //new一个bean的注册，参数传递一些插件，同时指定路径，进入该路径的时候会进入该插件的图形界面
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        //监控后台需要登陆
        HashMap<String, String> initParameters = new HashMap<>();
        //增加配置
        initParameters.put("loginUsername","admin");//loginUsername固定写法
        initParameters.put("loginPassword","123456");//固定写法
        //允许访问
        initParameters.put("allow", "");//如果该属性为空，则代表所有人可以访问

        //禁止访问
//        initParameters.put("kuangsheng", "这里写ip地址");//只要这样配置之后，这个ip地址就会被禁止访问监控后台

        bean.setInitParameters(initParameters);//设置初始化参数
        return bean;
    }

    //注册filter
    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        HashMap<String, String> initParameters = new HashMap<>();
        //对请求这些资源或者路劲的请求不统计
        initParameters.put("exclusions", "*.js,*.css,/druid/*");


        bean.setInitParameters(initParameters);
        return bean;
    }


}
