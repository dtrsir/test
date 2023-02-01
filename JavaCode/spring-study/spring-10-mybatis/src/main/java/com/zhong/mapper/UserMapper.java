package com.zhong.mapper;

import com.zhong.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    List<User> selectUser();

}
