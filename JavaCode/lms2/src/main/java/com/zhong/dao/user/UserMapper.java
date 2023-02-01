package com.zhong.dao.user;

import com.zhong.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    //条件查询用户（查询所有用户）展示所有用户，展示条件查询用户，角色，姓名，年龄:starDate， endDate，性别。分页：from，pageSize
    //复用展示和搜索
    List<User> queryUser(Map map);

    //获得登陆用户:通过账号
    User getLoginUser(@Param("userCode") String userCode);

    //通过id查询一个用户
    User getUser(@Param("id") int id);

    //统计用户总数
    //条件统计用户数（角色，姓名，年龄:starDate， endDate，性别。分页：from，pageSize）
    int userCount(Map map);

    //增加一个用户
    int addUser(User user);

    //通过id删除用户
    int deleteUser(@Param("id") int id);

    //修改用户
    int updateUser(User user);

    //修改用户密码
    int updatePassword(@Param("id") int id, @Param("password") String password);

    /*解决删除用户之后id不连续问题*/

    //插入前查询该id用户是否存在
    int getUserOfInserter(@Param("id") int id);

    //删除后设置自增起点
    //检查后设置自增
    void setAutoIncrement(@Param("n") int autoIncrementNumber);

}
