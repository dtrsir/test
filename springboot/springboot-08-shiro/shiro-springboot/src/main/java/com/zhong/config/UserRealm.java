package com.zhong.config;

import com.zhong.pojo.User;
import com.zhong.service.UserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import javax.annotation.Resource;

public class UserRealm extends AuthorizingRealm {

    //整合mybatis，连接到数据库
    @Resource
    UserServiceImpl userService;






    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了授权");
        //设置授权
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //设置授权名称
//        info.addStringPermission("user:add");

        //拿到当前登陆的对象
        Subject subject = SecurityUtils.getSubject();
        User currentUser = (User) subject.getPrincipal();//取出认证方法中存入的用户
        //设置当前用户权限
        info.addStringPermission(currentUser.getPerms());

        return info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行了认证");


        UsernamePasswordToken userToken = (UsernamePasswordToken) authenticationToken;

        //连接数据库
        User user = userService.queryUserByName(userToken.getUsername());

        if (user == null) {
            return null;//返回空，shiro会帮助我们抛出一个不明账户异常（UnknownAccountException），我们就可以在调用类中捕获来处理这种情况
        }

        //shiro不需要我们手动认证密码。它的实现类会自动帮我们验证密码。我们只需要新建一个实现类，将数据库的用户密码丢给它，让他去验证用户输入的密码即可
        return new SimpleAuthenticationInfo(user,user.getPwd(),"");
    }
}
