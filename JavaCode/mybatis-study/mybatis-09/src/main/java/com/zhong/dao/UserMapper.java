package com.zhong.dao;

import com.zhong.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    //根据id查询用户
    User getUserById(@Param("id") int id);


}
