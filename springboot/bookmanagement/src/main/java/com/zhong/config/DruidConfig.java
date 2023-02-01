package com.zhong.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;

/**
 * druid数据源的配置文件
 * 注册配置文件中的druid数据源到容器中，在内置注册过滤器和插件
 */

@Configuration
public class DruidConfig {

    //将配置文件中配置好的数据源属性new出实例并注册到容器
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

    //配置后台监控，注册到容器中
    @Bean
    public ServletRegistrationBean statViewServlet() {
        //new一个bean的注册，参数传递一些插件，同时指定路径，进入该路径的时候会进入该插件的图形界面
        //插件注册，这里注册图形化界面，并指定访问路径
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        //设置配置参数
        HashMap<String, String> initParameters = new HashMap<>();
        //设置图形化界面登陆账号
        initParameters.put("loginUsername","admin");//loginUsername固定写法
        initParameters.put("loginPassword","123456");//固定写法
        //设置所有人允许访问
        initParameters.put("allow", "");//如果该属性为空，则代表所有人可以访问
        //设置初始化参数
        bean.setInitParameters(initParameters);
        return bean;
    }


    //注册filter
    @Bean
    public FilterRegistrationBean webStatFilter() {
        //过滤器注册
        FilterRegistrationBean bean = new FilterRegistrationBean();
        //注册web统计过滤插件
        bean.setFilter(new WebStatFilter());
        //设置参数
        HashMap<String, String> initParameters = new HashMap<>();
        //排除以下路径的请求或资源请求统计
        initParameters.put("exclusions", "*.js,*.css,/druid/*");
        //设置初始化参数
        bean.setInitParameters(initParameters);
        return bean;
    }
}
