package com.zhong.dao;

import com.zhong.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    @Select("select * from `user`")
    List<User> getUsers();


}
