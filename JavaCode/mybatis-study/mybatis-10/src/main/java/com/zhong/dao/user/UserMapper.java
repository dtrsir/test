package com.zhong.dao.user;

import com.zhong.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {//通过userCode获取User
    public User getLoginUser(@Param("userCode") String userCode);

    //增加用户信息
    public int add(User user);

    //通过条件查询userList
    public List<User> getUserList(@Param("userName") String userName,
                                  @Param("userRole") Integer userRole,
                                  @Param("from") Integer from,
                                  @Param("pageSize") Integer pageSize);

    //通过条件查询-用户记录数
    public int getUserCount(@Param("userName") String userName,
                            @Param("userRole") Integer userRole);

    //通过userId删除user
    public int deleteUserById(@Param("id") Integer id);

    //通过useId获取user
    public User getUserById(@Param("id") Integer id);

    //修改用户信息
    public int modify(User user);

    //修改当前用户密码
    public int updatePwd(@Param("id") Integer id, @Param("pwd") String pwd);

}
