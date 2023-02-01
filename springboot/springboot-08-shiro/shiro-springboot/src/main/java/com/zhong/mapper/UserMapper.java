package com.zhong.mapper;

import com.zhong.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository//让spring识别并托管
@Mapper//让mybatis识别
public interface UserMapper {

    User queryUserByName(String name);
}
