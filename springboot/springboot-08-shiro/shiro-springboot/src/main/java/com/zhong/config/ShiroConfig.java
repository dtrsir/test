package com.zhong.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

@Configuration
public class ShiroConfig {

    //shiroFilterFactoryBean
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactorBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理
        bean.setSecurityManager(defaultWebSecurityManager);
        //添加shiro的内置过滤器实现登陆认证
        /*
        anno: 不用认证直接访问
        authc： 认证之后才能访问
        user： 开启记住我功能才能访问
        perms： 拥有某个资源的权限才能访问
        role： 拥有某个角色权限才能访问
         */

        //授权组，用来存放资源被授权给哪些权限
        LinkedHashMap<String, String> filterMap = new LinkedHashMap<>();

        //将该路劲下的资源文件授权给拥有user：add权限的用户。其他用户访问会报401
        filterMap.put("/user/add","perms[user:add]");
        filterMap.put("/user/update","perms[user:update]");
        filterMap.put("/logout", "logout");

        //设置user路径下的所有请求需要先认证才能放行
        filterMap.put("/user/*", "authc");

        //将权限组放进shiro责任链实例对象bean
        bean.setFilterChainDefinitionMap(filterMap);
        //设置登陆请求
        bean.setLoginUrl("/toLogin");

        //设置未授权请求
        bean.setUnauthorizedUrl("/noauth");
        return bean;
    }

    //defaultWebSecurityManager
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //管理userRealm
        securityManager.setRealm(userRealm);

        return securityManager;

    }

    //创建realm对象
    @Bean
    public UserRealm userRealm() {
        return new UserRealm();
    }

    //整合shrioDialect：用来整合thymeleaf
    @Bean
    public ShiroDialect getShiroDialect() {
        return new ShiroDialect();
    }

}
