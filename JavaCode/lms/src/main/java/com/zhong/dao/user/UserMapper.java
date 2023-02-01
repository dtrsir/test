package com.zhong.dao.user;

import com.zhong.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    //通过账户名(唯一)查询用户
    User getUserByUserCode(@Param("userCode")String userCode);

    //通过id(唯一)获取用户
    User getUserById(@Param("id")int id);

    //条件查询用户。用户名称，性别，年龄，电话号码，用户角色（分页from和pageSize）
    List<User> getUserList(Map map);

    //增加用户
    int addUser(User user);

    //通过条件统计用户数，性别，用户名称，年龄，用户角色
    int getUserCount(Map map);

    //通过id删除用户
    int deleteById(@Param("id")int id);

    //修改某一个用户
    int modify(User user);

    //修改当前用户的密码
    int updatePwd(@Param("id")int id, @Param("pwd") String pwd);


}
