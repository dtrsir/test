package com.zhong.mapper;

import com.zhong.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper//表示这个类是一个mybaits的一个mapper
//@MapperScan("com.zhong.mapper")或者在主启动类上添加mapper包扫描
@Repository//在spring中表示这是一个dao层对象
public interface UserMapper {

    List<User> queryUserList();

    User queryUserById(int id);

    int addUser(User user);

    int updateUser(User user);

    int deleteUserById(int id);
}
