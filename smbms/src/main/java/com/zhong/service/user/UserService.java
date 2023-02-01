package com.zhong.service.user;

import com.zhong.pojo.User;

import java.util.List;

public interface UserService {
    //用户登陆业务
    public User login(String userName, String userPassword);

    //根据用户id修改密码业务
    public boolean updatePwd(int id, String pwd);

    //查询用户数量
    public int getUserCount(String userName, int userRole);

    //根据条件查询用户列表
    public List<User> getUserList(String userName, int userRole, int currentPageNo, int pageSize);

    //添加用户
    public boolean addUser(User user);


}
