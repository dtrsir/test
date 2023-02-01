package com.zhong.service.user;

import com.zhong.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    //登陆
    User login(String userCode, String pwd);

    //修改用户密码
    boolean updatePwd(int id, String pwd);

    //查询用户
    List<User> queryUser(Map map);

    //条件统计用户数量
    int getUserCount(Map map);

    //添加一个用户
    boolean addUser(User user);

    //通过id获取一个用户
    User getUserByID(int id);

    //修改一个对象
    boolean modify(User user);

    //删除一个用户
    Boolean deleteById(int id);
}
