package com.zhong.mapper;

import com.zhong.pojo.User;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

public class UserMapperImpl extends SqlSessionDaoSupport implements UserMapper {


    public List<User> selectUser() {
        User user = new User(5, "12", "2122121");

        addUser(user);
        deleteUser(5);

        return getSqlSession().getMapper(UserMapper.class).selectUser();
    }

    public int addUser(User user) {
        return getSqlSession().getMapper(UserMapper.class).addUser(user);
    }

    public int deleteUser(int id) {
        return getSqlSession().getMapper(UserMapper.class).deleteUser(id);
    }


}
