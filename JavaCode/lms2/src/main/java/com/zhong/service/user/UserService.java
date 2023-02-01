package com.zhong.service.user;

import com.zhong.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserService {

    /*条件查询用户（查询所有用户）展示所有用户。
    展示条件查询用户:角色，姓名，年龄:starDate， endDate，性别。
    分页：from，pageSize*/
    List<User> queryUser(Map map);

    //用户登陆
    User getLoginUser(@Param("userCode") String userCode);

    //统计用户数
    //统计用户总数
    //条件统计用户数（角色，姓名，年龄:starDate， endDate，性别。分页：from，pageSize）
    int userCount(Map map);

    //添加一个用户
    boolean addUser(User user);

    //删除一个用户
    boolean deleteUser(int userId);

    //通过id查找一个用户
    User getUserById(int id);

    //修改用户
    boolean modifyUser(User user);

    //修改当前用户密码
    boolean modifyPassword(int id, String password);

}
